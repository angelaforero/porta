package com.vass.movistar.ec.portabilidad.api.dto;

public class PlanDetailPrice {

	private String channelType;
	private String name;
	private String price;
	private String priceWithTaxes;
	private String tax;
	private String tax2;

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPriceWithTaxes() {
		return priceWithTaxes;
	}

	public void setPriceWithTaxes(String priceWithTaxes) {
		this.priceWithTaxes = priceWithTaxes;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getTax2() {
		return tax2;
	}

	public void setTax2(String tax2) {
		this.tax2 = tax2;
	};

}
