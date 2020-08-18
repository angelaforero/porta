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
import javax.portlet.PortletSession;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "javax.portlet.name=" + PortabilidadWebPortletKeys.PORTABILIDADWEB,
		"mvc.command.name=action-who-recieves-chip" }, service = MVCActionCommand.class)
public class ActionWhoRecievesChip implements MVCActionCommand {

	private static final Log _log = LogFactoryUtil.getLog(ActionSendChipData.class);

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		String authorizedPersonName = ParamUtil.getString(actionRequest,
				PortabilidadWebPortletKeys.AUTHORIZED_PERSON_NAME);
		String authorizedPersonLastname = ParamUtil.getString(actionRequest,
				PortabilidadWebPortletKeys.AUTHORIZED_PERSON_LASTNAME);
		String authorizedPersonIDNumber = ParamUtil.getString(actionRequest,
				PortabilidadWebPortletKeys.AUTHORIZED_PERSON_IDNUMBER);
		String authorizedPersonContactNumber = ParamUtil.getString(actionRequest,
				PortabilidadWebPortletKeys.AUTHORIZED_PERSON_CONTACT_NUMBER);

		// Save variable
		HttpServletRequest httpReq = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
		httpReq.getSession(true).setAttribute(PortabilidadWebPortletKeys.AUTHORIZED_PERSON_NAME, authorizedPersonName);
		httpReq.getSession(true).setAttribute(PortabilidadWebPortletKeys.AUTHORIZED_PERSON_LASTNAME,
				authorizedPersonLastname);
		httpReq.getSession(true).setAttribute(PortabilidadWebPortletKeys.AUTHORIZED_PERSON_IDNUMBER,
				authorizedPersonIDNumber);
		httpReq.getSession(true).setAttribute(PortabilidadWebPortletKeys.AUTHORIZED_PERSON_CONTACT_NUMBER,
				authorizedPersonContactNumber);

		actionResponse.setRenderParameter("mvcRenderCommandName", "render-purchase-confirmation");
		return false;
	}

}
