package com.vass.movistar.ec.portabilidad.web.command.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.vass.movistar.ec.portabilidad.web.constants.PortabilidadWebPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "javax.portlet.name=" + PortabilidadWebPortletKeys.PORTABILIDADWEB,
		"mvc.command.name=action-send-chip-data" }, service = MVCActionCommand.class)
public class ActionSendChipData implements MVCActionCommand {

	private static final Log _log = LogFactoryUtil.getLog(ActionSendChipData.class);

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		String province = ParamUtil.getString(actionRequest, PortabilidadWebPortletKeys.PROVINCE);
		String city = ParamUtil.getString(actionRequest, PortabilidadWebPortletKeys.PROVINCE);
		String principalStreet = ParamUtil.getString(actionRequest, PortabilidadWebPortletKeys.PRINCIPAL_STREET);
		String secondaryStreet = ParamUtil.getString(actionRequest, PortabilidadWebPortletKeys.SECONDARY_STREET);
		String buildingNumber = ParamUtil.getString(actionRequest, PortabilidadWebPortletKeys.BUILDING_NUMBER);
		String reference = ParamUtil.getString(actionRequest, PortabilidadWebPortletKeys.REFERENCE);
		String contactNumber = ParamUtil.getString(actionRequest, PortabilidadWebPortletKeys.CONTACT_NUMBER);

		String sendLocation = province + " " + city + " " + principalStreet + " " + secondaryStreet + " "
				+ buildingNumber;
		String isNotOwnerRecieved = ParamUtil.getString(actionRequest, PortabilidadWebPortletKeys.RECIEVED);

		// Save variable
		HttpServletRequest httpReq = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
		httpReq.getSession(true).setAttribute(PortabilidadWebPortletKeys.PROVINCE, province);
		httpReq.getSession(true).setAttribute(PortabilidadWebPortletKeys.CITY, city);
		httpReq.getSession(true).setAttribute(PortabilidadWebPortletKeys.PRINCIPAL_STREET, principalStreet);
		httpReq.getSession(true).setAttribute(PortabilidadWebPortletKeys.SECONDARY_STREET, secondaryStreet);
		httpReq.getSession(true).setAttribute(PortabilidadWebPortletKeys.BUILDING_NUMBER, buildingNumber);
		httpReq.getSession(true).setAttribute(PortabilidadWebPortletKeys.REFERENCE, reference);
		httpReq.getSession(true).setAttribute(PortabilidadWebPortletKeys.CONTACT_NUMBER, contactNumber);
		

		
		if (isNotOwnerRecieved.equals("isNotOwnerRecieved")) {
			_log.info("RECEPCION TERCERO");
			actionResponse.setRenderParameter("mvcRenderCommandName", "render-who-recieves-chip");
		} else {
			actionResponse.setRenderParameter("mvcRenderCommandName", "render-purchase-confirmation");
		}

		return false;
	}

}
