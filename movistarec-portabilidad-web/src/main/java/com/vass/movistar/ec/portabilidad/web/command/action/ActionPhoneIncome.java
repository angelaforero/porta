package com.vass.movistar.ec.portabilidad.web.command.action;

import com.liferay.portal.kernel.log.Log;

import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.vass.movistar.ec.portabilidad.web.constants.PortabilidadWebPortletKeys;
import com.vass.movistar.ec.portabilidad.api.PortabilidadUtil;
import com.vass.movistar.ec.portabilidad.api.dto.ResponseMovistarCellphone;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + PortabilidadWebPortletKeys.PORTABILIDADWEB,
		"mvc.command.name=action-phone-income" }, service = MVCActionCommand.class)
public class ActionPhoneIncome implements MVCActionCommand {
	@Reference
	PortabilidadUtil portabilidadUtil;

	private static final Log _log = LogFactoryUtil.getLog(ActionPhoneIncome.class);

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		String cellphone = ParamUtil.getString(actionRequest, PortabilidadWebPortletKeys.CELLPHONE);

		// ValidationisMovistar
		_log.info("[Portabilidad - Service] " + "IsMovistarCellphone");
		_log.info("[Portabilidad - Cellphone] " + cellphone);
		ResponseMovistarCellphone response = portabilidadUtil.IsMovistarCellphone(cellphone);
		_log.info("[Portabilidad - Response] " + response);
		_log.info("[Portabilidad - Validation] " + response.getIsMovistar());
		// Save variable
		HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
		httpReq.getSession(true).setAttribute(PortabilidadWebPortletKeys.CELLPHONE, cellphone);

		actionResponse.setRenderParameter("mvcRenderCommandName", "render-telephone-operator");
		return false;
	}
}
