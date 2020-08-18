package com.vass.movistar.ec.portabilidad.web.command.action;

import com.liferay.portal.kernel.io.ByteArrayFileInputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;
import com.vass.movistar.ec.portabilidad.api.PortabilidadUtil;
import com.vass.movistar.ec.portabilidad.api.dto.RequestDNIDocument;
import com.vass.movistar.ec.portabilidad.api.dto.ResponseDNIDocument;
import com.vass.movistar.ec.portabilidad.api.dto.ResponseManagePortability;
import com.vass.movistar.ec.portabilidad.web.constants.PortabilidadWebPortletKeys;

import java.io.File;
import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
		"javax.portlet.name=" + PortabilidadWebPortletKeys.PORTABILIDADWEB,
		"mvc.command.name=action-photo-document" }, service = MVCActionCommand.class)
public class ActionPhotoDocument implements MVCActionCommand {
	@Reference
	PortabilidadUtil portabilidadUtil;
	
	private static final Log _log = LogFactoryUtil.getLog(ActionClientData.class);
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_log.info("INTO ActionPhotoDocument");
		//
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		ByteArrayFileInputStream inputstream = null;
		
		File fileFront = uploadPortletRequest.getFile("inpFileFront");
		File fileBack = uploadPortletRequest.getFile("inpFileBack");
		
		if(!fileFront.exists() || !fileBack.exists())
		{
			_log.info("Archivo vacío");
		}
		else 
		{
			RequestDNIDocument requestDNIDocument = new RequestDNIDocument();
			requestDNIDocument.setFullname("Anderson Guarnizo");
			requestDNIDocument.setDNIFront(fileFront);
			requestDNIDocument.setDniBack(fileBack);
			ResponseManagePortability response = portabilidadUtil.ManagePortability(null, requestDNIDocument, null, null);
			_log.info("Archivo valido front: "+ fileFront);
			_log.info("Nombre archivo front: "+ uploadPortletRequest.getFileName("inpFileFront"));
			_log.info("Archivo valido Back: "+ fileBack);
			_log.info("Nombre archivo back: "+ uploadPortletRequest.getFileName("inpFileBack"));
		}
		
		
		actionResponse.setRenderParameter("mvcRenderCommandName", "render-attach-signature");
		return false;
	}

}
