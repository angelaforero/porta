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
		"mvc.command.name=action-client-data" }, service = MVCActionCommand.class)
public class ActionClientData implements MVCActionCommand {

	private static final Log _log = LogFactoryUtil.getLog(ActionClientData.class);

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		String name = ParamUtil.getString(actionRequest, PortabilidadWebPortletKeys.CUSTOMER_NAME);
		String lastname = ParamUtil.getString(actionRequest, PortabilidadWebPortletKeys.CUSTOMER_LASTNAME);
		String IDNumber = ParamUtil.getString(actionRequest, PortabilidadWebPortletKeys.CUSTOMER_IDNUMBER);
		String isNotOwner = ParamUtil.getString(actionRequest, PortabilidadWebPortletKeys.NOT_OWNER);
		
		// Save variable
		HttpServletRequest httpReq = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
		httpReq.getSession(true).setAttribute(PortabilidadWebPortletKeys.CUSTOMER_NAME, name);
		httpReq.getSession(true).setAttribute(PortabilidadWebPortletKeys.CUSTOMER_LASTNAME, lastname);
		httpReq.getSession(true).setAttribute(PortabilidadWebPortletKeys.CUSTOMER_IDNUMBER, IDNumber);
		httpReq.getSession(true).setAttribute(PortabilidadWebPortletKeys.NOT_OWNER, isNotOwner);

		actionResponse.setRenderParameter("mvcRenderCommandName", "render-photo-document");
		return false;
	}

}
