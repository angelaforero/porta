package com.vass.movistar.ec.portabilidad.web.command.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.vass.movistar.ec.portabilidad.api.PortabilidadUtil;
import com.vass.movistar.ec.portabilidad.api.dto.RequestPinRequest;
import com.vass.movistar.ec.portabilidad.api.dto.RequestPinStatus;
import com.vass.movistar.ec.portabilidad.api.dto.ResponsePinRequest;
import com.vass.movistar.ec.portabilidad.api.dto.ResponsePinStatus;
import com.vass.movistar.ec.portabilidad.web.constants.PortabilidadWebPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + PortabilidadWebPortletKeys.PORTABILIDADWEB,
		"mvc.command.name=action-code-nip" }, service = MVCActionCommand.class)
public class ActionCodeNIP implements MVCActionCommand {

	private static final Log _log = LogFactoryUtil.getLog(ActionCodeNIP.class);

	@Reference
	PortabilidadUtil portabilidadUtil;

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

		String d1 = ParamUtil.getString(actionRequest, PortabilidadWebPortletKeys.DIGIT1);
		String d2 = ParamUtil.getString(actionRequest, PortabilidadWebPortletKeys.DIGIT2);
		String d3 = ParamUtil.getString(actionRequest, PortabilidadWebPortletKeys.DIGIT3);
		String d4 = ParamUtil.getString(actionRequest, PortabilidadWebPortletKeys.DIGIT4);

		String codeNIP = d1 + d2 + d3 + d4;
		
		HttpServletRequest httpReq = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
		String inquiryID = httpReq.getSession().getAttribute(PortabilidadWebPortletKeys.INQUIRY_ID).toString();
		String cellphone = httpReq.getSession().getAttribute(PortabilidadWebPortletKeys.CELLPHONE).toString();
		
		httpReq.getSession(true).setAttribute(PortabilidadWebPortletKeys.CODE_NIP, codeNIP);
		// Send SMS PinRequest
		RequestPinStatus requestPinStatus = new RequestPinStatus();

		requestPinStatus.setPin(codeNIP);
		requestPinStatus.setCellphone(cellphone);
		requestPinStatus.setInquiryId(inquiryID);

		_log.info("[Portabilidad - Service] " + "PinStatus");
		_log.info("[Portabilidad - Request] " + requestPinStatus);
		ResponsePinStatus responsePinStatus = portabilidadUtil.PinStatus(requestPinStatus);
		_log.info("[Portabilidad - Response] " + responsePinStatus);

		_log.info("INTO ActionCodeNIP");
		actionResponse.setRenderParameter("mvcRenderCommandName", "render-process-detail");
		return false;
	}

}
