package com.vass.movistar.ec.portabilidad.service;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfArray;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.utils.PdfMerger;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.TimeZoneUtil;
import com.vass.movistar.ec.portabilidad.api.dto.RequestDNIDocument;
import com.vass.movistar.ec.portabilidad.api.dto.RequestPortabilityDocument;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class PortabilidadFileHandling {

	final String PORTABILITY_FORMAT_ORIGIN = "EDITABLE_NUEVO_FORMATO_DE_SOLICITUD_DE_PORTABILIDAD_DE_NUMEROS_TELEFONICOS_MOVILES_CON_FIRMA.pdf";
	final String PORTABILITY_FORMAT_DESTINY = "_portability_form.pdf";
	final String CEDULA_PDF = "_cedula.pdf";
	final String PORTABILITY_FINAL_DOCUMENT = "_portability_final_document.pdf";

	private static Log _log = LogFactoryUtil.getLog(PortabilidadFileHandling.class);

	public File generatePortabilityDocument(RequestPortabilityDocument requestPortabilityDocument)
			throws FileNotFoundException, IOException {

		// Ruta de origen en los recursos del proyecto
		String SRC = PropsUtil.get("path.pdf.src") + PORTABILITY_FORMAT_ORIGIN;
																				
		//Ruta de destino en el servidor de liferay
		String DEST = getDestPdfPath(requestPortabilityDocument.getFullName(), PORTABILITY_FORMAT_DESTINY);
		
		InputStream isPDFOrigin = PortabilidadFileHandling.class.getResourceAsStream(SRC);
		File fileDEST = new File(DEST);
		FileUtils.copyInputStreamToFile(isPDFOrigin, fileDEST);// Se genera una copia local del PDF

		isPDFOrigin.close();
		
		PdfDocument pdf = new PdfDocument(new PdfReader(SRC), new PdfWriter(DEST));
		PdfAcroForm form = PdfAcroForm.getAcroForm(pdf, true);
		//////
//		final Map<String, PdfFormField> mapFields = form.getFormFields();
//
//		for (Map.Entry<String,PdfFormField> entry : mapFields.entrySet()) 
//		{
//            _log.info("Key = " + entry.getKey());
//            PdfFormField fieldpdf = entry.getValue();
//            fieldpdf.setValue(entry.getKey());
//		}
		//////

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.now();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = convertDateInstance(PortabilidadServiceUtil.getTimeZone());

		form.getField("untitled2").setValue(dtf.format(localDate));// fecha
		form.getField("untitled3").setValue(dateFormat.format(date));// hora
		// form.getField("untitled4").setValue("Off");//Persona natural
		form.getField("untitled5").setValue("Off");// Persona jurídica, untitled4-> Persona Natural
		form.getField("untitled7").setValue(requestPortabilityDocument.getFullName());// Nombre
		form.getField("untitled9").setValue(requestPortabilityDocument.getCellphone());// Número de contacto, el mismo
																						// de portabilidad

		if (requestPortabilityDocument.getCurrentPlan().toLowerCase().equals("pospaid")) {
			form.getField("untitled10").setValue("Off");// Modalidad Actual prepago
		} else {
			form.getField("untitled12").setValue("Off");// Modalidad Actual pospago
		}

		if (requestPortabilityDocument.getFuturePlan().toLowerCase().equals("pospaid")) {
			form.getField("untitled11").setValue("Off");// Modalidad Nueva prepago
		} else {
			form.getField("untitled13").setValue("Off");// Modalidad Nueva pospago
		}

		form.getField("untitled14").setValue(requestPortabilityDocument.getOperator());
		form.getField("untitled15").setValue(requestPortabilityDocument.getNIP());
		form.getField("untitled18").setValue(requestPortabilityDocument.getCellphone());
		form.getField("untitled16").setValue("1");
		form.getField("untitled17").setValue("1");
		form.getField("untitled38").setValue(requestPortabilityDocument.getFullName());
		form.getField("untitled39").setValue(requestPortabilityDocument.getDocument());

		// Gets size of signature field
		PdfFormField signatureField = form.getField("Firma");
		PdfArray position = signatureField.getWidgets().get(0).getRectangle();
		float width = (float) (position.getAsNumber(2).getValue() - position.getAsNumber(0).getValue());
		float height = (float) (position.getAsNumber(3).getValue() - position.getAsNumber(1).getValue());

		// Place canvas on the signature field
		PdfPage page = signatureField.getWidgets().get(0).getPage();
		PdfCanvas canvas = new PdfCanvas(page);
		Rectangle rect = new Rectangle((float) position.getAsNumber(0).getValue(),
				(float) position.getAsNumber(1).getValue(), width, height);

		// Place image on the canvas
		byte[] signatureImageBytes = base64ImageSkipMetadata(requestPortabilityDocument.getBase64Signature());
		ImageData imaged = ImageDataFactory.create(signatureImageBytes);
		canvas.addImage(imaged, rect, true);

		if (_log.isTraceEnabled()) {
			Map<String, PdfFormField> fields = form.getFormFields();

			Iterator<Entry<String, PdfFormField>> it = fields.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<String, PdfFormField> pair = it.next();
				_log.trace(pair.getKey() + " = " + pair.getValue().getValueAsString());
			}
		}

		// Convert PDF form to non-editable
		form.flattenFields();
		pdf.close();

		return new File(DEST);
	}

	public File generateDNIDocument(RequestDNIDocument requestDNIDocument) throws MalformedURLException, FileNotFoundException {

		final String DEST = getDestPdfPath(requestDNIDocument.getFullName(), CEDULA_PDF);

		File frontDNI = requestDNIDocument.getDniFront();
		File backDNI = requestDNIDocument.getDNIBack();

		frontDNI = downSizeImage(frontDNI);
		backDNI = downSizeImage(backDNI);

		final String[] images = { frontDNI.getAbsolutePath(), backDNI.getAbsolutePath() };
		PdfDocument pdfDoc = new PdfDocument(new PdfWriter(DEST));
		Document doc = null;

		Image image = new Image(ImageDataFactory.create(images[0]));
		
		doc = new com.itextpdf.layout.Document(pdfDoc, new PageSize(image.getImageWidth(), image.getImageHeight()));
		for (int i = 0; i < images.length; i++) {
			image = new Image(ImageDataFactory.create(images[i]));
			pdfDoc.addNewPage(new PageSize(image.getImageWidth(), image.getImageHeight()));
			image.setFixedPosition(i + 1, 0, 0);
			doc.add(image);
		}
		doc.close();
		return new File(DEST);
	}

	public File generateMergedPDFFormatDNI(String fullName, String pathPDF1, String pathPDF2) throws FileNotFoundException, IOException
	{
		String DEST = getDestPdfPath(fullName, PORTABILITY_FINAL_DOCUMENT);
		PdfDocument pdfDocument = new PdfDocument(new PdfReader(pathPDF1), new PdfWriter(DEST));
        PdfDocument pdfDocument2 = new PdfDocument(new PdfReader(pathPDF2));

        PdfMerger merger = new PdfMerger(pdfDocument);
        merger.merge(pdfDocument2, 1, pdfDocument2.getNumberOfPages());
        pdfDocument2.close();
        pdfDocument.close();
        
        return new File(DEST);
	}
	
	public boolean saveFileFTP(File localFile) {
		FTPClient ftpClient = new FTPClient();
		boolean fileSaved = false;

		try {
			String server = PropsUtil.get("portabilidad.ftp.server");
			int port = Integer.getInteger(PropsUtil.get("portabilidad.ftp.server"));
			String user = PropsUtil.get("portabilidad.ftp.user");
			String pass = PropsUtil.get("portabilidad.ftp.password");

			ftpClient.connect(server, port);
			ftpClient.login(user, pass);
			ftpClient.enterLocalPassiveMode();

			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

			String remoteFile = localFile.getName();
			InputStream inputStream = new FileInputStream(localFile);

			fileSaved = ftpClient.storeFile(remoteFile, inputStream);
			inputStream.close();
			return fileSaved;

		} catch (IOException e) {

			_log.info(e.getMessage());

		} finally {
			try {
				if (ftpClient.isConnected()) {
					ftpClient.logout();
					ftpClient.disconnect();
				}
			} catch (IOException ex) {
				_log.info(ex.getMessage());
			}
		}
		return fileSaved;
	}

	private String getDestPdfPath(String filename, String portabilityDoc) {

		String pdfFilesPath = PropsUtil.get("path.pdf.dest");

		StringBuilder sb = new StringBuilder(pdfFilesPath).append(filename.replaceAll(" ", "_")).append(portabilityDoc);

		return sb.toString();
	}

	private Date convertDateInstance(TimeZone timeZone) {
		Date dateInicial = new Date();
		Date dateFinal = null;
		try {
			DateFormat df = new SimpleDateFormat("dd MMM yyyy HH:mm:ss.SSS");
			df.setTimeZone(TimeZone.getTimeZone(timeZone.getID()));
			DateFormat df1 = new SimpleDateFormat("dd MMM yyyy HH:mm:ss.SSS");
			dateFinal = df1.parse(df.format(dateInicial));
		} catch (ParseException e) {
			e.printStackTrace();
			timeZone = TimeZoneUtil.getDefault();
			dateFinal = new Date();
		}
		return dateFinal;
	}

	private File downSizeImage(File imageDNI) {
		float FACTOR = 0;
		FACTOR = reduceFactor(imageDNI);
		ImageIcon im = new ImageIcon(imageDNI.getAbsolutePath());
		java.awt.Image con = im.getImage();
		int width = (int) (con.getWidth(null) * FACTOR);
		int height = (int) (con.getHeight(null) * FACTOR);
		java.awt.Image tam = con.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		ImageIcon fin = new ImageIcon(tam);
		File newFile = new File(imageDNI.getAbsolutePath());
		BufferedImage buffered = new BufferedImage(width, height, BufferedImage.SCALE_SMOOTH);
		buffered.getGraphics().drawImage(fin.getImage(), 0, 0, null);
		try {
			ImageIO.write(buffered, getFileExtension(newFile), newFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newFile;
	}

	private String getFileExtension(File file) {
		String extension = "";

		try {
			if (file != null && file.exists()) {
				String name = file.getName();
				extension = name.substring(name.lastIndexOf(".") + 1);
			}
		} catch (Exception e) {
			extension = "";
		}

		return extension;
	}

	private float reduceFactor(File imageDNI) {
		float factor = 0;
		long imgSize = imageDNI.length();
		if (imgSize > 10000000) {
			factor = 0.07f;
		} else if (imgSize > 1000000 && imgSize < 10000000) {
			factor = 0.2f;
		} else {
			factor = 0.5f;
		}
		return factor;
	}

	private byte[] base64ImageSkipMetadata(String base64Image) {
		int start = base64Image.indexOf(",");
		String base64Signature = base64Image.substring(start + 1);
		byte[] signatureImageBytes = Base64.getDecoder().decode(base64Signature);

		return signatureImageBytes;
	}
}
