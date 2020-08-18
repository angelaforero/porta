package com.vass.movistar.ec.portabilidad.web.command.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.vass.movistar.ec.portabilidad.api.PortabilidadUtil;
import com.vass.movistar.ec.portabilidad.web.constants.PortabilidadWebPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + PortabilidadWebPortletKeys.PORTABILIDADWEB,
		"mvc.command.name=action-telephone-operator" }, service = MVCActionCommand.class)
public class ActionTelephoneOperator implements MVCActionCommand {

	@Reference
	PortabilidadUtil portabilidadUtil;

	private static final Log _log = LogFactoryUtil.getLog(ActionTelephoneOperator.class);

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

		String customerType = ParamUtil.getString(actionRequest, PortabilidadWebPortletKeys.CUSTOMERTYPE);
		String operator = ParamUtil.getString(actionRequest, PortabilidadWebPortletKeys.OPERATOR);

		// Save variable
		HttpServletRequest httpReq = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
		httpReq.getSession(true).setAttribute(PortabilidadWebPortletKeys.CUSTOMERTYPE, customerType);
		httpReq.getSession(true).setAttribute(PortabilidadWebPortletKeys.OPERATOR, operator);

		_log.info("[Portabilidad - customerType] " + customerType);
		_log.info("[Portabilidad - operator] " + operator);

		if (customerType.equals("prepago")) {
			actionResponse.setRenderParameter("mvcRenderCommandName", "render-code-NIP");
		} else {
			actionResponse.setRenderParameter("mvcRenderCommandName", "render-process-detail");
		}

		return false;
	}

}
