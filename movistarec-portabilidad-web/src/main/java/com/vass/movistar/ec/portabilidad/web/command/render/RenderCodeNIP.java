package com.vass.movistar.ec.portabilidad.web.command.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.vass.movistar.ec.portabilidad.api.PortabilidadUtil;
import com.vass.movistar.ec.portabilidad.api.dto.OperatorID;
import com.vass.movistar.ec.portabilidad.api.dto.RequestPinRequest;
import com.vass.movistar.ec.portabilidad.api.dto.ResponseOperator;
import com.vass.movistar.ec.portabilidad.api.dto.ResponsePinRequest;
import com.vass.movistar.ec.portabilidad.web.command.action.ActionCodeNIP;
import com.vass.movistar.ec.portabilidad.web.constants.PortabilidadWebPortletKeys;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + PortabilidadWebPortletKeys.PORTABILIDADWEB,
		"mvc.command.name=render-code-NIP" }, service = MVCRenderCommand.class)
public class RenderCodeNIP implements MVCRenderCommand {

	private static final Log _log = LogFactoryUtil.getLog(ActionCodeNIP.class);

	@Reference
	PortabilidadUtil portabilidadUtil;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		//set counter 
		
		renderRequest.setAttribute("limitCounter", 30);
		
		
		// get cellphone value
		HttpServletRequest httpReq = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		String cellphone = httpReq.getSession().getAttribute(PortabilidadWebPortletKeys.CELLPHONE).toString();

		// Check operator code on List
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		_log.info("[Portabilidad - Service] " + "GetOperatorList");
		_log.info("[Portabilidad - Request] " + themeDisplay);
		ResponseOperator operator = portabilidadUtil.GetOperatorList(themeDisplay);
		_log.info("[Portabilidad - Response] " + operator);
		if (operator.getStatus() == "0") {
			// list just with movistar
			String idOperator = this.findCodeOperator(operator.getListOperators(), "Movistar");
			_log.info("[Portabilidad - idOperator] " + idOperator);

			// Send SMS PinRequest
			RequestPinRequest requestPinRequest = new RequestPinRequest();
			requestPinRequest.setCellphone(cellphone);
			requestPinRequest.setIdOperator(idOperator);
			_log.info("[Portabilidad - Service] " + "PinRequest");
			_log.info("[Portabilidad - Request] " + requestPinRequest);
			ResponsePinRequest responsePinRequest = portabilidadUtil.PinRequest(requestPinRequest);
			_log.info("[Portabilidad - Response] " + responsePinRequest);
			String InquiryId = responsePinRequest.getInquiryId();
			// Save variable
			httpReq.getSession(true).setAttribute(PortabilidadWebPortletKeys.INQUIRY_ID, InquiryId);
		}
		
		return "/codeNIP.jsp";
	}

	/**
	 * Find idoperator from a list
	 * 
	 * @param list operator  that include name and idOperator
	 * @param operator set operator Movistar
	 * @return res string idoPERATOR
	 */
	public String findCodeOperator(List<OperatorID> list, String operator) {
		String res = "";
		_log.info("[Portabilidad - operator] " + operator);
		_log.info("[Portabilidad - setoperadorid] " + list.get(5).getIdOperator());
		for (int i = 0; i < list.size(); i++) {
			_log.info("[Portabilidad - name] " + list.get(i).getName());
			if (list.get(i).getName() == operator) {
				_log.info("[Portabilidad - getIdOperator] " + list.get(i).getIdOperator());
				res = list.get(i).getIdOperator();
			}
		}
		_log.info("[Portabilidad - res] " + res);

		return res;
	}

}
