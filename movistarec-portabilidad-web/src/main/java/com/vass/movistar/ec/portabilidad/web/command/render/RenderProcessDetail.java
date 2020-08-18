package com.vass.movistar.ec.portabilidad.web.command.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.vass.movistar.ec.portabilidad.api.PortabilidadUtil;
import com.vass.movistar.ec.portabilidad.api.dto.ResponseOperator;
import com.vass.movistar.ec.portabilidad.api.dto.ResponseOperatorChangeText;
import com.vass.movistar.ec.portabilidad.web.command.action.ActionCodeNIP;
import com.vass.movistar.ec.portabilidad.web.command.action.ActionProcessDetail;
import com.vass.movistar.ec.portabilidad.web.constants.PortabilidadWebPortletKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
		"javax.portlet.name=" +  PortabilidadWebPortletKeys.PORTABILIDADWEB,
		"mvc.command.name=render-process-detail" }, service = MVCRenderCommand.class)
public class RenderProcessDetail implements MVCRenderCommand  {
	
	private static final Log _log = LogFactoryUtil.getLog(ActionProcessDetail.class);

	@Reference
	PortabilidadUtil portabilidadUtil;
	@Override
	public String render (RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		String operator = ParamUtil.getString(renderRequest, PortabilidadWebPortletKeys.OPERATOR);
		_log.info("[Portabilidad - Operator] " + operator );
		String title = "Estas iniciando el proceso de cambio de operadora";
		String subTitle1 = "[" +operator + "]" + " dejará de cobrarte de manera automática en cuanto se haga el cambio";
		String subTitle2 = "No tienes que darte de baja de " + "[" +operator + "]" + " ni modificar tu plan";
		String subTitle3 = "El proceso tarda aproximadamente 48hs.";
		String subTitle4 = "Te pediremos algunos datos, incluyendo fotos de tu cédula. Todos son requeridos para realizar el proceso.";
		
		renderRequest.setAttribute("descripcion-portabilidad-titulo", title);
		renderRequest.setAttribute("descripcion-portabilidad-s1", subTitle1);
		renderRequest.setAttribute("descripcion-portabilidad-s2", subTitle2);
		renderRequest.setAttribute("descripcion-portabilidad-s3", subTitle3);
		renderRequest.setAttribute("descripcion-portabilidad-s4", subTitle4);
		
//		// Check operator code on List
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		_log.info("[Portabilidad - Service] " + "GetOperatorChangeText");
		_log.info("[Portabilidad - Request] " + themeDisplay);
		ResponseOperatorChangeText responseOperatorChangeText = portabilidadUtil.GetOperatorChangeText(themeDisplay);

		_log.info("[Portabilidad - Response] " + responseOperatorChangeText);
//		_log.info("[Portabilidad - GetTitle] " + responseOperatorChangeText.getTitle());
//		_log.info("[Portabilidad - GetSubTitle] " + responseOperatorChangeText.getSubtitles());
		return "/processDetail.jsp";
	}

}
