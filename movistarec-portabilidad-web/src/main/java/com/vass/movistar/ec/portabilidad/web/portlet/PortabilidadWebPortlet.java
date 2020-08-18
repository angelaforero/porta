package com.vass.movistar.ec.portabilidad.web.portlet;

import com.vass.movistar.ec.portabilidad.web.constants.PortabilidadWebPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author angelica.fandino
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=NuevoPortalEc",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=PortabilidadWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + PortabilidadWebPortletKeys.PORTABILIDADWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class PortabilidadWebPortlet extends MVCPortlet {

	private static final Log _log = LogFactoryUtil.getLog(PortabilidadWebPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		renderRequest.setAttribute("a", "a");
		HttpServletRequest httpReq = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));

		// first validation
		String cellphone = httpReq.getParameter("cellphone");
		String identification = httpReq.getParameter("identification");
		String name = httpReq.getParameter("name");
		String email = httpReq.getParameter("email");
		String url = httpReq.getParameter("url");
		String clientid = httpReq.getParameter("clientid");
		String plan = httpReq.getParameter("plan");
		String utm_campaign = httpReq.getParameter("utm_campaign");
		String utm_content = httpReq.getParameter("utm_content");
		String utm_medium = httpReq.getParameter("utm_medium");
		String utm_source = httpReq.getParameter("utm_source");

		_log.info("[Portabilidad - PortabilidadWebPortlet - cellphone] " + cellphone);
		_log.info("[Portabilidad - PortabilidadWebPortlet - identification] " + identification);
		_log.info("[Portabilidad - PortabilidadWebPortlet - name] " + name);
		_log.info("[Portabilidad - PortabilidadWebPortlet - email] " + email);
		_log.info("[Portabilidad - PortabilidadWebPortlet - url] " + url);
		_log.info("[Portabilidad - PortabilidadWebPortlet - clientid] " + clientid);
		_log.info("[Portabilidad - PortabilidadWebPortlet - plan] " + plan);
		_log.info("[Portabilidad - PortabilidadWebPortlet - utm_campaign] " + utm_campaign);
		_log.info("[Portabilidad - PortabilidadWebPortlet - utm_content] " + utm_content);
		_log.info("[Portabilidad - PortabilidadWebPortlet - utm_medium] " + utm_medium);
		_log.info("[Portabilidad - PortabilidadWebPortlet - utm_source] " + utm_source);

		// keep data
		this.SaveDataServletRequest(renderRequest, PortabilidadWebPortletKeys.CUSTOMER_IDNUMBER, identification);
		this.SaveDataServletRequest(renderRequest, PortabilidadWebPortletKeys.CUSTOMER_NAME, name);
		this.SaveDataServletRequest(renderRequest, PortabilidadWebPortletKeys.EMAIL, email);
		this.SaveDataServletRequest(renderRequest, PortabilidadWebPortletKeys.CLIENTID, clientid);
		this.SaveDataServletRequest(renderRequest, PortabilidadWebPortletKeys.PLAN_CODE, plan);
		this.SaveDataServletRequest(renderRequest, PortabilidadWebPortletKeys.UTM_CAMPAIGN, utm_campaign);
		this.SaveDataServletRequest(renderRequest, PortabilidadWebPortletKeys.UTM_CONTENT, utm_content);
		this.SaveDataServletRequest(renderRequest, PortabilidadWebPortletKeys.UTM_MEDIUM, utm_medium);
		this.SaveDataServletRequest(renderRequest, PortabilidadWebPortletKeys.UTM_SOURCE, utm_source);

		// Redirect when cellphone is ok
		if (!(cellphone == null)) {
			this.SaveDataServletRequest(renderRequest, PortabilidadWebPortletKeys.CELLPHONE, cellphone);
			include("/telephoneOperator.jsp", renderRequest, renderResponse);
		} else {
			super.doView(renderRequest, renderResponse);
		}
	}

	/**
	 * Save the intital parameters to be set on OBO final service
	 * 
	 * @param renderRequest
	 * @param key           name of the porlet key PortabilidadWebPortletKeys
	 *                      asociate to a input data
	 * @param value         captured information from url extraction
	 * @return void
	 */
	public void SaveDataServletRequest(RenderRequest renderRequest, String key, String value) {
		_log.info("[Portabilidad - keepDataPorletSession - value] " + value);
		if (!(value == null)) {
			HttpServletRequest httpReq = PortalUtil
					.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
			httpReq.getSession(true).setAttribute(key, value);
		} else {
			HttpServletRequest httpReq = PortalUtil
					.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
			httpReq.getSession(true).setAttribute(key, "");
		}
	}
}