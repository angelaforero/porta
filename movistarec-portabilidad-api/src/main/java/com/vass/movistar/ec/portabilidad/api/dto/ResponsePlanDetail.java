package com.vass.movistar.ec.portabilidad.api.dto;

import java.util.List;
import java.util.Map;

public class ResponsePlanDetail {

	private String status;
	private String message;
	private String name;
	private String shortName;
	private String slug;
	private String planCode;
	private String product;
	private String isMainPlan;
	private String isOutstandingPlan;
	private String showPlan;
	private String orderDesktop;
	private String orderMobile;
	private List<PlanDetailOutstandingBenefits> outstandingBenefits;
	private PlanDetailPrice price;
	private PlanDetailContentTags contentTags;

	private String json;
	private Map<String, String> errors;

	public ResponsePlanDetail() {
		this.status = "";
		this.message = "";
		this.name = "";
		this.shortName = "";
		this.slug = "";
		this.planCode = "";
		this.product = "";
		this.isMainPlan = "";
		this.isOutstandingPlan = "";
		this.showPlan = "";
		this.orderDesktop = "";
		this.orderMobile = "";
		this.errors = null;
		this.outstandingBenefits = null;
		this.price = new PlanDetailPrice();
		this.contentTags = new PlanDetailContentTags();

	}

	public ResponsePlanDetail(String status, String message, String name, String short_name, String slug,
			String planCode, String product, String is_main_plan, String is_outstanding_plan, String show_plan,
			String order_desktop, String order_mobile, List<PlanDetailOutstandingBenefits> outstandingBenefits,
			PlanDetailPrice price, PlanDetailContentTags contentTags, Map<String, String> errors) {
		super();
		this.status = status;
		this.message = message;
		this.name = name;
		this.shortName = short_name;
		this.slug = slug;
		this.planCode = planCode;
		this.product = product;
		this.isMainPlan = is_main_plan;
		this.isOutstandingPlan = is_outstanding_plan;
		this.showPlan = show_plan;
		this.orderDesktop = order_desktop;
		this.orderMobile = order_mobile;
		this.outstandingBenefits = outstandingBenefits;
		this.price = price;
		this.contentTags = contentTags;
		this.errors = errors;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getPlanCode() {
		return planCode;
	}

	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getIsMainPlan() {
		return isMainPlan;
	}

	public void setIsMainPlan(String isMainPlan) {
		this.isMainPlan = isMainPlan;
	}

	public String getIsOutstandingPlan() {
		return isOutstandingPlan;
	}

	public void setIsOutstandingPlan(String isOutstandingPlan) {
		this.isOutstandingPlan = isOutstandingPlan;
	}

	public String getShowPlan() {
		return showPlan;
	}

	public void setShowPlan(String showPlan) {
		this.showPlan = showPlan;
	}

	public String getOrderDesktop() {
		return orderDesktop;
	}

	public void setOrderDesktop(String orderDesktop) {
		this.orderDesktop = orderDesktop;
	}

	public String getOrderMobile() {
		return orderMobile;
	}

	public void setOrderMobile(String orderMobile) {
		this.orderMobile = orderMobile;
	}

	public List<PlanDetailOutstandingBenefits> getOutstandingBenefits() {
		return outstandingBenefits;
	}

	public void setOutstandingBenefits(List<PlanDetailOutstandingBenefits> outstandingBenefits) {
		this.outstandingBenefits = outstandingBenefits;
	}

	public PlanDetailPrice getPrice() {
		return price;
	}

	public void setPrice(PlanDetailPrice price) {
		this.price = price;
	}

	public PlanDetailContentTags getContentTags() {
		return contentTags;
	}

	public void setContentTags(PlanDetailContentTags contentTags) {
		this.contentTags = contentTags;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	@Override
	public String toString() {
		return "ResponsePlanDetail [status=" + status + ", message=" + message + "]";
	}

}
