package com.vass.movistar.ec.portabilidad.web.command.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.vass.movistar.ec.portabilidad.web.constants.PortabilidadWebPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = {
		"javax.portlet.name=" + PortabilidadWebPortletKeys.PORTABILIDADWEB,
		"mvc.command.name=action-attach-signature" }, service = MVCActionCommand.class)
public class ActionAttachSignature implements MVCActionCommand {
	private static final Log _log = LogFactoryUtil.getLog(ActionClientData.class);

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_log.info("INTO ActionClientData");
		actionResponse.setRenderParameter("mvcRenderCommandName", "render-send-chip-data");
		return false;
	}
	

}
