package com.vass.movistar.ec.portabilidad.web.command.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.vass.movistar.ec.portabilidad.api.PortabilidadUtil;
import com.vass.movistar.ec.portabilidad.api.dto.PlanDetailOutstandingBenefits;
import com.vass.movistar.ec.portabilidad.api.dto.ResponsePlanDetail;
import com.vass.movistar.ec.portabilidad.web.command.action.ActionCodeNIP;
import com.vass.movistar.ec.portabilidad.web.constants.PortabilidadWebPortletKeys;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + PortabilidadWebPortletKeys.PORTABILIDADWEB,
		"mvc.command.name=render-purchase-confirmation" }, service = MVCRenderCommand.class)
public class RenderPurchaseConfirmation implements MVCRenderCommand {

	private static final Log _log = LogFactoryUtil.getLog(ActionCodeNIP.class);

	@Reference
	PortabilidadUtil portabilidadUtil;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		// P0073
		// get plan code value
		HttpServletRequest httpReq = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		String plan = httpReq.getSession().getAttribute(PortabilidadWebPortletKeys.PLAN_CODE).toString();
		_log.info("[Portabilidad - Plan] " + plan);
		// plan validation

		if (plan == "") {
			renderRequest.setAttribute("shortName", "00 GB");
			renderRequest.setAttribute("price", "00.00");
			renderRequest.setAttribute("description", "00 GB incluido + 00 GB extra cada mes");
			renderRequest.setAttribute("topText", "Promoción vigente 10% OFF");
		} else {
			// Check operator code on List
			_log.info("[Portabilidad - Service] " + "GetPlanDetail");
			_log.info("[Portabilidad - Request] " + plan);
			ResponsePlanDetail planDetail = portabilidadUtil.GetPlanDetail(plan);
			_log.info("[Portabilidad - Response] " + planDetail);

			String price = planDetail.getPrice().getPrice();
			String priceWithTaxes = planDetail.getPrice().getPriceWithTaxes();
			String shortName = planDetail.getShortName();
			List<PlanDetailOutstandingBenefits> outstandingBenefits = (List<PlanDetailOutstandingBenefits>) planDetail
					.getOutstandingBenefits();
			String description = outstandingBenefits.get(0).getDescription();
			String topText = planDetail.getContentTags().getTopText();

			double  valuePrice = Double.parseDouble(priceWithTaxes);
			double  valuePriceWithTaxes = Double.parseDouble(priceWithTaxes);
			_log.info("[Portabilidad - RenderPurchaseConfirmation - valuePrice] " + valuePrice);
			_log.info("[Portabilidad - RenderPurchaseConfirmation - valuePriceWithTaxes] " + valuePriceWithTaxes);
			double taxes = valuePriceWithTaxes - valuePrice;

			_log.info("[Portabilidad - RenderPurchaseConfirmation - price] " + price);
			_log.info("[Portabilidad - RenderPurchaseConfirmation - priceWithTaxes] " + priceWithTaxes);
			_log.info("[Portabilidad - RenderPurchaseConfirmation - taxes] " + taxes);
			_log.info("[Portabilidad - RenderPurchaseConfirmation - shortName] " + shortName);
			_log.info("[Portabilidad - RenderPurchaseConfirmation - description] " + description);
			_log.info("[Portabilidad - RenderPurchaseConfirmation - topText] " + topText);
			renderRequest.setAttribute("shortName", shortName);
			renderRequest.setAttribute("price", price);
			renderRequest.setAttribute("priceWithTaxes", priceWithTaxes);
			renderRequest.setAttribute("taxes", taxes);
			renderRequest.setAttribute("description", description);
			renderRequest.setAttribute("topText", topText);
		}

		return "/purchaseConfirmation.jsp";
	}

}
