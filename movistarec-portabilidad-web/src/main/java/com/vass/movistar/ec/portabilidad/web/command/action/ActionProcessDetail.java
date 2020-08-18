package com.vass.movistar.ec.portabilidad.web.command.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.vass.movistar.ec.portabilidad.web.constants.PortabilidadWebPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = {
		"javax.portlet.name=" + PortabilidadWebPortletKeys.PORTABILIDADWEB,
		"mvc.command.name=action-process-detail" }, service = MVCActionCommand.class)
public class ActionProcessDetail implements MVCActionCommand {
	
	
	private static final Log _log = LogFactoryUtil.getLog(ActionTelephoneOperator.class);

	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		
		String cellphone = (String) actionRequest.getPortletSession(true)
				.getAttribute(PortabilidadWebPortletKeys.OBJECT_CACHE, PortletSession.APPLICATION_SCOPE);
		_log.info("CELLPHONE ON PROCESS DETAIL-->"+ cellphone);
		
		actionResponse.setRenderParameter("mvcRenderCommandName", "render-client-data");
		return false;
	}

}
