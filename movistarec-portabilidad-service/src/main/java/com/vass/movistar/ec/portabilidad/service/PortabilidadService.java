package com.vass.movistar.ec.portabilidad.service;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PropsUtil;
import com.vass.movistar.ec.portabilidad.api.PortabilidadUtil;
import com.vass.movistar.ec.portabilidad.api.dto.OperatorID;
import com.vass.movistar.ec.portabilidad.api.dto.PlanDetailContentTags;
import com.vass.movistar.ec.portabilidad.api.dto.PlanDetailOutstandingBenefits;
import com.vass.movistar.ec.portabilidad.api.dto.PlanDetailPrice;
import com.vass.movistar.ec.portabilidad.api.dto.PortabilitySOAPHeaders;
import com.vass.movistar.ec.portabilidad.api.dto.RequestDNIDocument;
import com.vass.movistar.ec.portabilidad.api.dto.RequestMergedDocument;
import com.vass.movistar.ec.portabilidad.api.dto.RequestPortabilityDocument;
import com.vass.movistar.ec.portabilidad.api.dto.RequestPinRequest;
import com.vass.movistar.ec.portabilidad.api.dto.RequestPinStatus;
import com.vass.movistar.ec.portabilidad.api.dto.RequestSendOBO;
import com.vass.movistar.ec.portabilidad.api.dto.ResponseDNIDocument;
import com.vass.movistar.ec.portabilidad.api.dto.ResponseManagePortability;
import com.vass.movistar.ec.portabilidad.api.dto.ResponseMergedDocument;
import com.vass.movistar.ec.portabilidad.api.dto.ResponsePortabilityDocument;
import com.vass.movistar.ec.portabilidad.api.dto.ResponseMovistarCellphone;
import com.vass.movistar.ec.portabilidad.api.dto.ResponseOperator;
import com.vass.movistar.ec.portabilidad.api.dto.ResponseOperatorChangeText;
import com.vass.movistar.ec.portabilidad.api.dto.ResponsePinRequest;
import com.vass.movistar.ec.portabilidad.api.dto.ResponsePinStatus;
import com.vass.movistar.ec.portabilidad.api.dto.ResponsePlanDetail;
import com.vass.movistar.ec.portabilidad.api.dto.ResponseSaveFileFTP;
import com.vass.movistar.ec.portabilidad.api.dto.ResponseSendOBO;
import com.vass.movistar.ec.portabilidad.api.dto.ResponseValidDocument;
import com.vass.movistar.ec.util.api.MovistarEcUtilApi;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.w3c.dom.NodeList;

import javax.xml.soap.SOAPElement;

/**
 * @author angelica.fandino
 */
@Component(immediate = true, property = {}, service = PortabilidadUtil.class)
public class PortabilidadService implements PortabilidadUtil {

	private final String RESPONSE_CODE_EXITOSO = "0000";
	private final String RESPONSE_MESSAGE_EXITOSO = "PROCESO EXITOSO";

	@Reference
	MovistarEcUtilApi movistarEcUtil;

	private static Log _log = LogFactoryUtil.getLog(PortabilidadService.class);

	@Override
	public ResponseMovistarCellphone IsMovistarCellphone(String cellphone) {
		String url = PropsUtil.get("portabilidad.endpoint.IsMovistarCellphone");
		ResponseMovistarCellphone responseMovistarCellphone = new ResponseMovistarCellphone();

		try {
			String urlParameters = url + cellphone;
			_log.info(urlParameters);
			String response = movistarEcUtil.callRestServiceByGet(urlParameters, new HashMap<>(),
					new LinkedHashMap<>());
			_log.info(response);

			responseMovistarCellphone.setJson(response);

			JSONObject responseJson = JSONFactoryUtil.createJSONObject(response);
			responseMovistarCellphone.setStatus(responseJson.get("ResponseCode").toString());
			responseMovistarCellphone.setMessage(responseJson.get("retorno").toString());
			responseMovistarCellphone.setIsMovistar(false);
			if (responseJson.get("codigo").toString().equals("1")) {
				responseMovistarCellphone.setIsMovistar(true);
			}

		} catch (Exception e) {
			_log.info(e.getLocalizedMessage());
			e.printStackTrace();
			responseMovistarCellphone.setStatus("-1");
			responseMovistarCellphone.setMessage("Error on method IsMovistarCellphone");
		}

		return responseMovistarCellphone;
	}

	@Override
	public ResponseValidDocument IsValidDocument(String document) {

		ResponseValidDocument responseValidDocument = new ResponseValidDocument();

		try {

			responseValidDocument.setStatus("0");
			responseValidDocument.setMessage("OK");
			responseValidDocument.setIsValid(false);

			if (document == null || document.isEmpty() || document.length() != 10) {
				return responseValidDocument;
			}

			int total = 0;
			int longitud = document.length();
			int longcheck = longitud - 1;
			for (int i = 0; i < longcheck; i++) {
				if (i % 2 == 0) {
					int aux = Character.getNumericValue(document.charAt(i)) * 2;
					if (aux > 9)
						aux -= 9;
					total += aux;
				} else {
					total += Character.getNumericValue(document.charAt(i));
				}
			}

			// total = total % 10 ? 10 - (total % 10) : 0;
			if (total % 10 != 0) {
				total = 10 - (total % 10);
			} else {
				total = 0;
			}

			if (Character.getNumericValue(document.charAt(longitud - 1)) == total) {
				responseValidDocument.setIsValid(true);
			}

		} catch (Exception e) {
			_log.info(e.getLocalizedMessage());
			responseValidDocument.setStatus("-1");
			responseValidDocument.setMessage("Error on method IsValidDocument");
		}

		return responseValidDocument;
	}

	public ResponsePlanDetail GetPlanDetail(String planCode) {
		
		String url = PropsUtil.get("portabilidad.endpoint.GetPlanDetail");
		ResponsePlanDetail responsePlanDetail = new ResponsePlanDetail();
		try {
			responsePlanDetail.setStatus("false");
			responsePlanDetail.setMessage("Error. No se encuentran listas con el código de plan ingresado");
			String response = movistarEcUtil.callRestServiceByGet(url, new HashMap<String, String>(),
					new LinkedHashMap<String, String>());
			_log.info(response);
			responsePlanDetail.setJson(response);
			JSONObject responseJson = JSONFactoryUtil.createJSONObject(response);
			if ("true".equals(responseJson.get("status").toString())) {
				JSONArray arPlans = (JSONArray) ((JSONObject) responseJson.get("data")).get("plans");
				for (int i = 0; i < arPlans.length(); i++) {
					JSONObject plan = (JSONObject) arPlans.get(i);
					String textPlanCode = plan.get("plan_code").toString();
					if (textPlanCode.equals(planCode)) {
						responsePlanDetail.setStatus(responseJson.get("status").toString());
						responsePlanDetail.setMessage(responseJson.get("message").toString());
						responsePlanDetail.setName(plan.get("name").toString());
						responsePlanDetail.setShortName(plan.get("short_name").toString());
						responsePlanDetail.setSlug(plan.get("slug").toString());
						responsePlanDetail.setPlanCode(plan.get("plan_code").toString());
						responsePlanDetail.setProduct(plan.get("product").toString());
						responsePlanDetail.setIsMainPlan(plan.get("is_main_plan").toString());
						responsePlanDetail.setIsOutstandingPlan(plan.get("is_outstanding_plan").toString());
						responsePlanDetail.setShowPlan(plan.get("show_plan").toString());
						responsePlanDetail.setOrderDesktop(plan.get("order_desktop").toString());
						responsePlanDetail.setOrderMobile(plan.get("order_mobile").toString());
						
						JSONArray arOutstanding = (JSONArray) ((JSONObject) plan).get("outstandingBenefits");
						List<PlanDetailOutstandingBenefits> outstandingBenefits = new ArrayList<PlanDetailOutstandingBenefits>();
						for (int j = 0; j < arOutstanding.length(); j++)
						{
							JSONObject jsonOutstandingB = (JSONObject) arOutstanding.get(j);
							PlanDetailOutstandingBenefits outstanding = new PlanDetailOutstandingBenefits();
							outstanding.setId(jsonOutstandingB.get("id").toString());
							outstanding.setType(jsonOutstandingB.get("type").toString());
							outstanding.setName(jsonOutstandingB.get("name").toString());
							outstanding.setDescription(jsonOutstandingB.get("description").toString());
							outstanding.setIcon(jsonOutstandingB.get("icon").toString());
							outstanding.setStatus(jsonOutstandingB.get("status").toString());
							outstanding.setOutstanding(jsonOutstandingB.get("outstanding").toString());
							outstanding.setOrder(jsonOutstandingB.get("order").toString());
							outstandingBenefits.add(outstanding);
						}
						responsePlanDetail.setOutstandingBenefits(outstandingBenefits);
						
						JSONObject objPrice = (JSONObject) plan.get("price");
						PlanDetailPrice price = new PlanDetailPrice();
						price.setChannelType(objPrice.get("channel_type").toString());
						price.setName(objPrice.get("name").toString());
						price.setPrice(objPrice.get("price").toString());
						price.setPriceWithTaxes(objPrice.get("price_with_taxes").toString());
						price.setTax(objPrice.get("tax").toString());
						price.setTax2(objPrice.get("tax2").toString());

						JSONObject objContentTags = (JSONObject) plan.get("content_tags");
						PlanDetailContentTags contentTags = new PlanDetailContentTags();
						contentTags.setTopText(objContentTags.get("topText").toString());
						contentTags.setGigas(objContentTags.get("gigas").toString());

						responsePlanDetail.setPrice(price);
						responsePlanDetail.setContentTags(contentTags);
						
						break;
					}
				}
				return responsePlanDetail;
			}
		} catch (Exception e) {
			_log.info(e.getLocalizedMessage());
			responsePlanDetail.setStatus("-1");
			responsePlanDetail.setMessage("Error on method GetPlanDetail");
		}
		
		return responsePlanDetail;
	}

	public ResponseOperatorChangeText GetOperatorChangeText(ThemeDisplay themeDisplay) {
		ResponseOperatorChangeText responseOperatorChangeText = new ResponseOperatorChangeText();
		try {
			PortabilidadDDLUtil portabilidadDDLUtil = new PortabilidadDDLUtil();
			ResponseOperatorChangeText responseLista = portabilidadDDLUtil.getDataListChangeOperator(themeDisplay);
			List<String> listSubtitles = responseLista.getSubtitles();
			if (listSubtitles != null && listSubtitles.size() > 0) {
				responseOperatorChangeText.setTitle(responseLista.getTitle());
				responseOperatorChangeText.setSubtitles(listSubtitles);
				responseOperatorChangeText.setStatus("0");
				responseOperatorChangeText.setMessage("OK");
			} else {
				responseOperatorChangeText.setStatus("1");
				responseOperatorChangeText.setMessage("Error. No se encuentra la lista o los valores");
			}
		} catch (Exception e) {
			_log.info(e.getLocalizedMessage());
			responseOperatorChangeText.setStatus("-1");
			responseOperatorChangeText.setMessage("Error on method GetOperatorChangeText");
			e.printStackTrace();
		}

		return responseOperatorChangeText;
	}

	public ResponseOperator GetOperatorList(ThemeDisplay themeDisplay) {
		ResponseOperator responseOperator = new ResponseOperator();
		try {
			PortabilidadDDLUtil portabilidadDDLUtil = new PortabilidadDDLUtil();
			ResponseOperator responseLista = portabilidadDDLUtil.getDataListOperators(themeDisplay);
			List<OperatorID> listOperators = responseLista.getListOperators();
			if (listOperators != null && listOperators.size() > 0) {
				responseOperator.setStatus("0");
				responseOperator.setMessage("OK");
				responseOperator.setListOperators(listOperators);
			} else {
				responseOperator.setStatus("1");
				responseOperator.setMessage("Error. No se encuentra la lista o los valores");
			}

		} catch (Exception e) {
			_log.info(e.getLocalizedMessage());
			responseOperator.setStatus("-1");
			responseOperator.setMessage("Error on method GetOperatorList");
			e.printStackTrace();
		}
		
		return responseOperator;
	}

	public ResponseSendOBO SendOBO(RequestSendOBO requestSendOBO, ThemeDisplay themeDisplay) {
		String url = PropsUtil.get("portabilidad.endpoint.SendOBO");
		ResponseSendOBO responseSendOBO = new ResponseSendOBO();
		PortabilidadDDLUtil portabilidadDDLUtil = new PortabilidadDDLUtil();
		try {

			_log.info(url);
			JSONObject requestJSON = JSONFactoryUtil.createJSONObject();
			requestJSON.put("clientId", requestSendOBO.getClientId());
			requestJSON.put("nombre", requestSendOBO.getNombre());
			requestJSON.put("tipo_documento", requestSendOBO.getTipo_documento());
			requestJSON.put("num_documento", requestSendOBO.getNum_documento());
			requestJSON.put("email_contacto", requestSendOBO.getEmail_contacto());
			requestJSON.put("numero_cel", requestSendOBO.getNumero_cel());
			requestJSON.put("temp_telf", requestSendOBO.getTemp_telf());
			requestJSON.put("equipo", requestSendOBO.getEquipo());
			requestJSON.put("solicitud", requestSendOBO.getSolicitud());
			requestJSON.put("ubicacion", requestSendOBO.getUbicacion());
			requestJSON.put("num_cel_pro", requestSendOBO.getNum_cel_pro());
			requestJSON.put("utm_source", requestSendOBO.getUtm_source());
			requestJSON.put("utm_medium", requestSendOBO.getUtm_medium());
			requestJSON.put("utm_campaign", requestSendOBO.getUtm_campaign());
			requestJSON.put("utm_content", requestSendOBO.getUtm_content());
			String campana = requestSendOBO.getCampana().isEmpty()
					? portabilidadDDLUtil.getFieldValueOBO("campana", themeDisplay)
					: requestSendOBO.getCampana();

			requestJSON.put("campana", campana);

			String producto = requestSendOBO.getProducto().isEmpty()
					? portabilidadDDLUtil.getFieldValueOBO("producto", themeDisplay)
					: requestSendOBO.getProducto();

			requestJSON.put("producto", producto);
			requestJSON.put("chk_term", requestSendOBO.getChk_term());
			requestJSON.put("dia_contacto", requestSendOBO.getDia_contacto());
			requestJSON.put("hora_contacto", requestSendOBO.getHora_contacto());
			requestJSON.put("origen", requestSendOBO.getOrigen());
			requestJSON.put("creatividad", requestSendOBO.getCreatividad());
			requestJSON.put("url", requestSendOBO.getUrl());

			String response = movistarEcUtil.callRestServiceByPost(url, requestJSON.toJSONString(), new HashMap<>(),
					new LinkedHashMap<>());
			_log.info(response);

			responseSendOBO.setJson(response);

			JSONObject responseJson = JSONFactoryUtil.createJSONObject(response);
			String statusOBO = responseJson.get("status").toString().equals("true") ? "0" : "1";
			responseSendOBO.setStatus(statusOBO);
			responseSendOBO.setMessage(responseJson.get("message").toString());

		} catch (Exception e) {

			_log.info(e.getLocalizedMessage());
			e.printStackTrace();
			responseSendOBO.setStatus("-1");
			responseSendOBO.setMessage("Error on method SendOBO");
		}

		return responseSendOBO;
	}

	public ResponsePortabilityDocument GetPortabilityDocument(RequestPortabilityDocument requestPortabilityDocument) {
		ResponsePortabilityDocument responsePortabilityDocument = new ResponsePortabilityDocument();
		PortabilidadFileHandling fileHandling = new PortabilidadFileHandling();
		try {

			File generatedFile = fileHandling.generatePortabilityDocument(requestPortabilityDocument);
			if (generatedFile != null && generatedFile.exists()) {
				responsePortabilityDocument.setStatus("0");
				responsePortabilityDocument.setMessage("OK");
				responsePortabilityDocument.setPortabilityDocument(generatedFile);
				return responsePortabilityDocument;
			}
			responsePortabilityDocument.setStatus("1");
			responsePortabilityDocument.setMessage("Error. No se pudo generar o no se encuentra el archivo generado");
			return responsePortabilityDocument;

		} catch (Exception e) {
			_log.info(e.getLocalizedMessage());
			e.printStackTrace();
			responsePortabilityDocument.setStatus("-1");
			responsePortabilityDocument.setMessage("Error on method GetPortabilityDocument");
		}

		return responsePortabilityDocument;
	}

	public ResponseDNIDocument GetDNIDocument(RequestDNIDocument requestDNIDocument) {
		ResponseDNIDocument responseDNIDocument = new ResponseDNIDocument();
		PortabilidadFileHandling fileHandling = new PortabilidadFileHandling();
		try {

			File generatedFile = fileHandling.generateDNIDocument(requestDNIDocument);
			if (generatedFile != null && generatedFile.exists()) {
				responseDNIDocument.setStatus("0");
				responseDNIDocument.setMessage("OK");
				responseDNIDocument.setDNIDocument(generatedFile);
				return responseDNIDocument;
			}
			responseDNIDocument.setStatus("1");
			responseDNIDocument.setMessage("Error. No se pudo generar o no se encuentra el archivo generado");
			return responseDNIDocument;

		} catch (Exception e) {
			_log.info(e.getLocalizedMessage());
			responseDNIDocument.setStatus("-1");
			responseDNIDocument.setMessage("Error on method GetDNIDocument");
		}

		return responseDNIDocument;
	}
	
	public ResponseMergedDocument GetMergedDocument(RequestMergedDocument requestMergedDocument) {
		ResponseMergedDocument responseMergedDocument = new ResponseMergedDocument();
		PortabilidadFileHandling fileHandling = new PortabilidadFileHandling();
		try {

			File generatedFile = fileHandling.generateMergedPDFFormatDNI(requestMergedDocument.getFullName(),
					requestMergedDocument.getPathPDF1(), requestMergedDocument.getPathPDF2());
			if (generatedFile != null && generatedFile.exists()) {
				responseMergedDocument.setStatus("0");
				responseMergedDocument.setMessage("OK");
				responseMergedDocument.setMergedDocument(generatedFile);
				return responseMergedDocument;
			}
			responseMergedDocument.setStatus("1");
			responseMergedDocument.setMessage("Error. No fue posible unir los archivos PDF");
			return responseMergedDocument;

		} catch (Exception e) {
			_log.info(e.getLocalizedMessage());
			e.printStackTrace();
			responseMergedDocument.setStatus("-1");
			responseMergedDocument.setMessage("Error on method GetMergedDocument");
		}

		return responseMergedDocument;
	}

	public ResponsePinRequest PinRequest(RequestPinRequest requestPinRequest) {
		String url = PropsUtil.get("portabilidad.endpoint.PinRequest");
		String soapActionPinRequest = PropsUtil.get("portabilidad.soapaction.pinRequest");

		PortabilitySOAPHeaders soapHeaders = PortabilidadServiceUtil.GetPortabilityHeaders();

		String serviceName = PropsUtil.get("portabilidad.headerin.pinRequest.serviceName");
		String version = PropsUtil.get("portabilidad.headerin.pinRequest.version");
		String systemId = PropsUtil.get("portabilidad.headerin.pinRequest.body.systemId");
		String bodyUserLogin = PropsUtil.get("portabilidad.headerin.pinRequest.body.userLogin");

		ResponsePinRequest responsePinRequest = new ResponsePinRequest();

		try {
			String requestPinRequestJSONXML = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:v1=\"http://telefonica.ec/CommonBusinessEntities/BusinessInteractionABE/HeaderInfo/v1\" xmlns:typ=\"http://telefonica.ec/Service/ServiceOrderManagement/ServiceActivationManagement/PortabilityManagement/v1/types\" xmlns:v11=\"http://telefonica.ec/Customer/CustomerABE/SubscriberIdentification/v1\" xmlns:v12=\"http://telefonica.ec/CommonBusinessEntities/BusinessInteractionABE/Request/v1\" xmlns:v13=\"http://telefonica.ec/Service/ServiceABE/ServiceOrderABE/BasicRequestSpn/v1\" xmlns:v14=\"http://telefonica.ec/Service/ServiceABE/ServiceOrderABE/CommonRequestSpn/v1\">\r\n"
					+ "    <soapenv:Header>\r\n" + "      <v1:headerInfo>\r\n" + "         <v1:application>"
					+ soapHeaders.getApplication() + "</v1:application>\r\n" + "         <v1:serviceChannel>"
					+ soapHeaders.getServiceChannel() + "</v1:serviceChannel>\r\n" + "         <v1:password>"
					+ soapHeaders.getPassword() + "</v1:password>\r\n" + "         <v1:userLogin>"
					+ soapHeaders.getUserLogin() + "</v1:userLogin>\r\n" + "         <!--Optional:-->\r\n"
					+ "         <v1:sessionCode></v1:sessionCode>\r\n" + "         <!--Optional:-->\r\n"
					+ "         <v1:idMessage></v1:idMessage>\r\n" + "         <v1:ipAddress>"
					+ soapHeaders.getIpAddress() + "</v1:ipAddress>\r\n" + "         <!--Optional:-->\r\n"
					+ "         <v1:functionalityCode></v1:functionalityCode>\r\n"
					+ "         <v1:transactionTimestamp>" + PortabilidadServiceUtil.getFormatCurrentTimeStamp()
					+ "</v1:transactionTimestamp>\r\n" + "         <v1:serviceName>" + serviceName
					+ "</v1:serviceName>\r\n" + "         <v1:version>" + version + "</v1:version>\r\n"
					+ "      </v1:headerInfo>\r\n" + "   </soapenv:Header>\r\n" + "   <soapenv:Body>\r\n"
					+ "      <typ:pinRequestRequest>\r\n" + "         <typ:msisdn>\r\n"
					+ "            <v11:identificationValue>" + requestPinRequest.getCellphone()
					+ "</v11:identificationValue>\r\n"
					+ "            <v11:identificationType>MSISDN</v11:identificationType>\r\n"
					+ "         </typ:msisdn>\r\n" + "         <typ:recipientOperator>\r\n"
					+ "            <!--Optional:-->\r\n" + "            <v12:requestId>"
					+ requestPinRequest.getIdOperator() + "</v12:requestId>\r\n"
					+ "         </typ:recipientOperator>\r\n" + "         <typ:commonRequestSpn>\r\n"
					+ "            <!--Optional:-->\r\n" + "            <v13:systemId>" + systemId
					+ "</v13:systemId>\r\n" + "            <!--Optional:-->\r\n" + "            <v13:userLogin>"
					+ bodyUserLogin + "</v13:userLogin>\r\n" + "          </typ:commonRequestSpn>\r\n"
					+ "      </typ:pinRequestRequest>\r\n" + "   </soapenv:Body>\r\n" + "</soapenv:Envelope>";

			_log.info(requestPinRequestJSONXML);
			String response = movistarEcUtil.callSOAPService(url, requestPinRequestJSONXML, soapActionPinRequest,
					new HashMap<>(), new LinkedHashMap<>());
			_log.info(response);

			InputStream inputStream = new ByteArrayInputStream(response.getBytes());
			SOAPMessage responseSOAP = MessageFactory.newInstance().createMessage(null, inputStream);
			SOAPBody soapBody = responseSOAP.getSOAPBody();
			SOAPFault soapFault = soapBody.getFault();

			// Cuando se recibe un fault y el PIN no es enviado
			if (soapFault != null) {
				responsePinRequest.setStatus("1");
				responsePinRequest.setMessage(soapFault.getFaultString());
				return responsePinRequest;
			}

			// No se recibe fault, se evalúa la respuesta
			String inquiryId = "";
			String responseCode = "";
			NodeList pinRequestResponse = soapBody.getElementsByTagName("typ:pinRequestResponse");

			if (pinRequestResponse.getLength() > 0) {
				NodeList responseId = ((SOAPElement) pinRequestResponse.item(0)).getElementsByTagName("v1:responseId");
				if (responseId.getLength() > 0) {
					inquiryId = responseId.item(0).getTextContent();
				}

				NodeList transacInfoResponseCode = ((SOAPElement) pinRequestResponse.item(0))
						.getElementsByTagName("v1:responseCode");
				if (transacInfoResponseCode.getLength() > 0) {
					responseCode = transacInfoResponseCode.item(0).getTextContent();
				}
			}

			if (responseCode.equals(RESPONSE_CODE_EXITOSO) && !responseCode.isEmpty()) {
				responsePinRequest.setStatus("0");
				responsePinRequest.setMessage("OK");
				responsePinRequest.setInquiryId(inquiryId);
				responsePinRequest.setPinSent(true);
				return responsePinRequest;
			}

			responsePinRequest.setStatus("1");
			responsePinRequest.setMessage("Error. Ocurrió un problema al procesar la petición de PIN Request");
			return responsePinRequest;
		} catch (Exception e) {
			_log.info(e.getMessage());
			responsePinRequest.setStatus("-1");
			responsePinRequest.setMessage("Error on method PinRequest");
			return responsePinRequest;
		}
	}

	public ResponsePinStatus PinStatus(RequestPinStatus requestPinStatus) {

		String url = PropsUtil.get("portabilidad.endpoint.PinStatus");
		String soapActionPinStatus = PropsUtil.get("portabilidad.soapaction.pinStatus");

		PortabilitySOAPHeaders soapHeaders = PortabilidadServiceUtil.GetPortabilityHeaders();
		String serviceName = PropsUtil.get("portabilidad.headerin.pinStatus.serviceName");
		String version = PropsUtil.get("portabilidad.headerin.pinStatus.version");
		String systemId = PropsUtil.get("portabilidad.headerin.pinStatus.body.systemId");
		String bodyUserLogin = PropsUtil.get("portabilidad.headerin.pinStatus.body.userLogin");

		ResponsePinStatus responsePinStatus = new ResponsePinStatus();

		try {
			String requestPinStatusJSONXML = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:v1=\"http://telefonica.ec/CommonBusinessEntities/BusinessInteractionABE/HeaderInfo/v1\" xmlns:typ=\"http://telefonica.ec/Service/ServiceOrderManagement/ServiceOrderTrackingAndManagement/PortabilityInquiry/v1/types\" xmlns:v11=\"http://telefonica.ec/CommonBusinessEntities/BusinessInteractionABE/InquiryRequest/v1\" xmlns:v12=\"http://telefonica.ec/Service/ServiceABE/ServiceOrderABE/PortabilityMSISDN/v1\" xmlns:v13=\"http://telefonica.ec/Service/ServiceABE/ServiceOrderABE/BasicRequestSpn/v1\">\r\n"
					+ "    <soapenv:Header>\r\n" + "      <v1:headerInfo>\r\n" + "         <v1:application>"
					+ soapHeaders.getApplication() + "</v1:application>\r\n" + "         <v1:serviceChannel>"
					+ soapHeaders.getServiceChannel() + "</v1:serviceChannel>\r\n" + "         <v1:password>"
					+ soapHeaders.getPassword() + "</v1:password>\r\n" + "         <v1:userLogin>"
					+ soapHeaders.getUserLogin() + "</v1:userLogin>\r\n" + "         <!--Optional:-->\r\n"
					+ "         <v1:sessionCode></v1:sessionCode>\r\n" + "         <!--Optional:-->\r\n"
					+ "         <v1:idMessage></v1:idMessage>\r\n" + "         <v1:ipAddress>"
					+ soapHeaders.getIpAddress() + "</v1:ipAddress>\r\n" + "         <!--Optional:-->\r\n"
					+ "         <v1:functionalityCode></v1:functionalityCode>\r\n"
					+ "         <v1:transactionTimestamp>" + PortabilidadServiceUtil.getFormatCurrentTimeStamp()
					+ "</v1:transactionTimestamp>\r\n" + "         <v1:serviceName>" + serviceName
					+ "</v1:serviceName>\r\n" + "         <v1:version>" + version + "</v1:version>\r\n"
					+ "      </v1:headerInfo>\r\n" + "   </soapenv:Header>\r\n" + "   <soapenv:Body>\r\n"
					+ "      <typ:pinStatusRequest>\r\n" + "         <typ:pinId>\r\n"
					+ "            <!--Optional:-->\r\n" + "            <v11:inquiryId>"
					+ requestPinStatus.getInquiryId() + "</v11:inquiryId>\r\n" + "         </typ:pinId>\r\n"
					+ "         <typ:msisdn>\r\n" + "            <!--Optional:-->\r\n" + "            <v12:msisdn>"
					+ requestPinStatus.getCellphone() + "</v12:msisdn>\r\n" + "            <v12:pin>"
					+ requestPinStatus.getPin() + "</v12:pin>\r\n" + "         </typ:msisdn>\r\n"
					+ "         <typ:basicRequestSpn>\r\n" + "            <!--Optional:-->\r\n"
					+ "            <v13:systemId>" + systemId + "</v13:systemId>\r\n"
					+ "            <!--Optional:-->\r\n" + "            <v13:userLogin>" + bodyUserLogin
					+ "</v13:userLogin>\r\n" + "         </typ:basicRequestSpn>\r\n" + "      </typ:pinStatusRequest>"
					+ "   </soapenv:Body>\r\n" + "</soapenv:Envelope>";

			_log.info(requestPinStatusJSONXML);
			String response = movistarEcUtil.callSOAPService(url, requestPinStatusJSONXML, soapActionPinStatus,
					new HashMap<>(), new LinkedHashMap<>());
			_log.info(response);

			InputStream inputStream = new ByteArrayInputStream(response.getBytes());
			SOAPMessage responseSOAP = MessageFactory.newInstance().createMessage(null, inputStream);
			SOAPBody soapBody = responseSOAP.getSOAPBody();
			SOAPFault soapFault = soapBody.getFault();

			// Cuando se recibe un fault y el PIN no es enviado
			if (soapFault != null) {
				responsePinStatus.setStatus("1");
				responsePinStatus.setMessage(soapFault.getFaultString());
				return responsePinStatus;
			}

			// No se recibe fault, se evalúa la respuesta
			boolean pinValid = false;
			boolean pinExpired = false;
			String responseCode = "";
			NodeList pinStatusResponse = soapBody.getElementsByTagName("typ:pinStatusResponse");

			if (pinStatusResponse.getLength() > 0) {
				NodeList portabilityStatus = ((SOAPElement) pinStatusResponse.item(0))
						.getElementsByTagName("v11:portabilityStatus");

				if (portabilityStatus.getLength() > 0) {
					for (int i = 0; i < portabilityStatus.getLength(); i++) {
						NodeList portabilityState = ((SOAPElement) portabilityStatus.item(i))
								.getElementsByTagName("v11:state");
						if (portabilityState.getLength() > 0) {
							switch (portabilityState.item(0).getTextContent()) {
							case "CENT":
								pinValid = true;
								break;
							default:
								break;
							}
						}
					}
				}

				NodeList transacInfoResponseCode = ((SOAPElement) pinStatusResponse.item(0))
						.getElementsByTagName("v1:responseCode");
				if (transacInfoResponseCode.getLength() > 0) {
					responseCode = transacInfoResponseCode.item(0).getTextContent();

					NodeList transacInfoResponseMessage = ((SOAPElement) pinStatusResponse.item(0))
							.getElementsByTagName("v1:responseMessage");
					if (transacInfoResponseMessage.getLength() > 0) {
						// Si el texto de la respuesta es "Proceso exitoso" y previamente no hay un tag
						// portabilityStatus/state = CENT
						// entonces el PIN ha caducado
						pinExpired = transacInfoResponseMessage.item(0).getTextContent().toUpperCase()
								.equals(RESPONSE_MESSAGE_EXITOSO);
					}
				}
			}

			responsePinStatus.setStatus("1");
			responsePinStatus.setMessage("Incorrect PIN");
			responsePinStatus.setPinValid(false);

			if (responseCode.equals(RESPONSE_CODE_EXITOSO)) {
				if (pinExpired) {
					responsePinStatus.setMessage("PIN Expired");
				}
				if (pinValid) {
					responsePinStatus.setStatus("0");
					responsePinStatus.setMessage("OK");
					responsePinStatus.setPinValid(true);
				}
			}

			return responsePinStatus;

		} catch (Exception e) {
			e.printStackTrace();
			responsePinStatus.setStatus("-1");
			responsePinStatus.setMessage("Error on method PinStatus");
			return responsePinStatus;
		}
	}

	public ResponseSaveFileFTP SaveFileFTP(File file) {
		ResponseSaveFileFTP responseSendFileFTP = new ResponseSaveFileFTP();
		PortabilidadFileHandling fileHandling = new PortabilidadFileHandling();
		try {
			if (fileHandling.saveFileFTP(file)) {
				responseSendFileFTP.setStatus("0");
				responseSendFileFTP.setMessage("OK");
				responseSendFileFTP.setFileSaved(fileHandling.saveFileFTP(file));
				return responseSendFileFTP;
			}
			responseSendFileFTP.setStatus("1");
			responseSendFileFTP.setMessage("Error. No fue posible guardar el archivo en el FTP de destino");
			responseSendFileFTP.setFileSaved(false);
			return responseSendFileFTP;

		} catch (Exception e) {
			_log.info(e.getLocalizedMessage());
			responseSendFileFTP.setStatus("-1");
			responseSendFileFTP.setMessage("Error on method ResponseSaveFileFTP");
			responseSendFileFTP.setFileSaved(false);
		}
		return responseSendFileFTP;
	}

	public ResponseManagePortability ManagePortability(RequestPortabilityDocument requestPortabilityDocument,
			RequestDNIDocument requestDNIDocument, RequestSendOBO requestSendOBO, ThemeDisplay themeDisplay) {
		
		ResponseManagePortability responseManagePortability = new ResponseManagePortability();
		responseManagePortability.setStatus("1");
		responseManagePortability.setIsCompleted(false);
		
		try {
			
			ResponsePortabilityDocument responsePortabilityDocument = GetPortabilityDocument(requestPortabilityDocument);
			if (!responsePortabilityDocument.getStatus().equals("0")) {
				responseManagePortability.setMessage("Error. Archivo de portabilidad no generado -> " + responsePortabilityDocument.getMessage());
				return responseManagePortability;
			}
			ResponseDNIDocument responseDNIDocument = GetDNIDocument(requestDNIDocument);
			if (!responseDNIDocument.getStatus().equals("0")) {
				responseManagePortability.setMessage("Error. Archivo de cédula no generado -> " + responseDNIDocument.getMessage());
				return responseManagePortability;
			}

			RequestMergedDocument requestMergedDocument = new RequestMergedDocument(requestPortabilityDocument.getFullName(),
					responsePortabilityDocument.getPortabilityDocument().getPath(),
					responseDNIDocument.getDNIDocument().getPath());
			
			ResponseMergedDocument responseMergedDocument = GetMergedDocument(requestMergedDocument);
			if (!responseMergedDocument.getStatus().equals("0")) {
				responseManagePortability.setMessage("Error. Archivo agrupado de portabilidad no generado -> " + responseMergedDocument.getMessage());
				return responseManagePortability;
			}
			
			ResponseSaveFileFTP responseSaveFileFTP_PortabilityFormat = SaveFileFTP(
					responsePortabilityDocument.getPortabilityDocument());
			if (!responseSaveFileFTP_PortabilityFormat.getStatus().equals("0")) {
				responseManagePortability.setMessage("Error. Archivo de portabilidad no almacenado en FTP -> " + responsePortabilityDocument.getMessage());
				return responseManagePortability;
			}

			ResponseSaveFileFTP responseSaveFileFTP_DNIDocument = SaveFileFTP(responseDNIDocument.getDNIDocument());
			if (!responseSaveFileFTP_DNIDocument.getStatus().equals("0")) {
				responseManagePortability.setMessage("Error. Archivo de documento DNI no almacenado en FTP -> " + responseDNIDocument.getMessage());
				return responseManagePortability;
			}
			
			ResponseSendOBO responseSendOBO = SendOBO(requestSendOBO, themeDisplay);
			if (!responseSendOBO.getStatus().equals("0")) {
				responseManagePortability.setMessage("Error. Petición de portabilidad no almacenada en OBO -> " + responseSendOBO.getMessage());
				return responseManagePortability;
			}
			
			responseManagePortability.setStatus("0");
			responseManagePortability.setIsCompleted(true);
			
		} catch (Exception e) {
			responseManagePortability.setStatus("-1");
			_log.info(e.getLocalizedMessage());
			_log.info("Error on method ManagePortability");
			e.printStackTrace();
		}
		return responseManagePortability;
	}
}