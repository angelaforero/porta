package com.vass.movistar.ec.portabilidad.api.dto;

public class PortabilitySOAPHeaders {

	private String application;
	private String serviceChannel;
	private String password;
	private String userLogin;
	private String ipAddress;

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getServiceChannel() {
		return serviceChannel;
	}

	public void setServiceChannel(String serviceChannel) {
		this.serviceChannel = serviceChannel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public PortabilitySOAPHeaders() {
		this.application = "";
		this.serviceChannel = "";
		this.password = "";
		this.userLogin = "";
		this.ipAddress = "";
	}

	public PortabilitySOAPHeaders(String application, String serviceChannel, String password, String userLogin,
			String ipAddress) {
		this.application = application;
		this.serviceChannel = serviceChannel;
		this.password = password;
		this.userLogin = userLogin;
		this.ipAddress = ipAddress;
	}

}
