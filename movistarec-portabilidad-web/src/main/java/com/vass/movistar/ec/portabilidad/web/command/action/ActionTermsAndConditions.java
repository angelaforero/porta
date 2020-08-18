package com.vass.movistar.ec.portabilidad.web.command.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.vass.movistar.ec.portabilidad.web.constants.PortabilidadWebPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = {
		"javax.portlet.name=" + PortabilidadWebPortletKeys.PORTABILIDADWEB,
		"mvc.command.name=action-terms-conditions" }, service = MVCActionCommand.class)
public class ActionTermsAndConditions implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		actionResponse.setRenderParameter("mvcRenderCommandName", "render-welcome-movistar");
		return false;
	}
	
}
