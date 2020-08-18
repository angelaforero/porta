package com.vass.movistar.ec.portabilidad.api.dto;

public class RequestSendOBO {

	private String numero_cel;
	private String tipo_documento;
	private String num_documento;
	private String nombre;
	private String campana;
	private String producto;
	private String url;
	private String clientId;
	private String email_contacto;
	private String temp_telf;
	private String equipo;
	private String solicitud;
	private String ubicacion;
	private String num_cel_pro;
	private String utm_source;
	private String utm_medium;
	private String utm_campaign;
	private String utm_content;
	private String chk_term;
	private String dia_contacto;
	private String hora_contacto;
	private String origen;
	private String creatividad;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public String getNum_documento() {
		return num_documento;
	}

	public void setNum_documento(String num_documento) {
		this.num_documento = num_documento;
	}

	public String getEmail_contacto() {
		return email_contacto;
	}

	public void setEmail_contacto(String email_contacto) {
		this.email_contacto = email_contacto;
	}

	public String getNumero_cel() {
		return numero_cel;
	}

	public void setNumero_cel(String numero_cel) {
		this.numero_cel = numero_cel;
	}

	public String getTemp_telf() {
		return temp_telf;
	}

	public void setTemp_telf(String temp_telf) {
		this.temp_telf = temp_telf;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public String getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getNum_cel_pro() {
		return num_cel_pro;
	}

	public void setNum_cel_pro(String num_cel_pro) {
		this.num_cel_pro = num_cel_pro;
	}

	public String getUtm_source() {
		return utm_source;
	}

	public void setUtm_source(String utm_source) {
		this.utm_source = utm_source;
	}

	public String getUtm_medium() {
		return utm_medium;
	}

	public void setUtm_medium(String utm_medium) {
		this.utm_medium = utm_medium;
	}

	public String getUtm_campaign() {
		return utm_campaign;
	}

	public void setUtm_campaign(String utm_campaign) {
		this.utm_campaign = utm_campaign;
	}

	public String getUtm_content() {
		return utm_content;
	}

	public void setUtm_content(String utm_content) {
		this.utm_content = utm_content;
	}

	public String getCampana() {
		return campana;
	}

	public void setCampana(String campana) {
		this.campana = campana;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getChk_term() {
		return chk_term;
	}

	public void setChk_term(String chk_term) {
		this.chk_term = chk_term;
	}

	public String getDia_contacto() {
		return dia_contacto;
	}

	public void setDia_contacto(String dia_contacto) {
		this.dia_contacto = dia_contacto;
	}

	public String getHora_contacto() {
		return hora_contacto;
	}

	public void setHora_contacto(String hora_contacto) {
		this.hora_contacto = hora_contacto;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getCreatividad() {
		return creatividad;
	}

	public void setCreatividad(String creatividad) {
		this.creatividad = creatividad;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public RequestSendOBO() {
		this.clientId = "";
		this.nombre = "";
		this.tipo_documento = "";
		this.num_documento = "";
		this.email_contacto = "";
		this.numero_cel = "";
		this.temp_telf = "";
		this.equipo = "";
		this.solicitud = "";
		this.ubicacion = "";
		this.num_cel_pro = "";
		this.utm_source = "";
		this.utm_medium = "";
		this.utm_campaign = "";
		this.utm_content = "";
		this.campana = "";
		this.producto = "";
		this.chk_term = "";
		this.dia_contacto = "";
		this.hora_contacto = "";
		this.origen = "";
		this.creatividad = "";
		this.url = "";
	}

	public RequestSendOBO(String clientId, String nombre, String tipo_documento, String num_documento,
			String email_contacto, String numero_cel, String temp_telf, String equipo, String solicitud,
			String ubicacion, String num_cel_pro, String utm_source, String utm_medium, String utm_campaign,
			String utm_content, String campana, String producto, String chk_term, String dia_contacto,
			String hora_contacto, String origen, String creatividad, String url) {
		this.clientId = clientId;
		this.nombre = nombre;
		this.tipo_documento = tipo_documento;
		this.num_documento = num_documento;
		this.email_contacto = email_contacto;
		this.numero_cel = numero_cel;
		this.temp_telf = temp_telf;
		this.equipo = equipo;
		this.solicitud = solicitud;
		this.ubicacion = ubicacion;
		this.num_cel_pro = num_cel_pro;
		this.utm_source = utm_source;
		this.utm_medium = utm_medium;
		this.utm_campaign = utm_campaign;
		this.utm_content = utm_content;
		this.campana = campana;
		this.producto = producto;
		this.chk_term = chk_term;
		this.dia_contacto = dia_contacto;
		this.hora_contacto = hora_contacto;
		this.origen = origen;
		this.creatividad = creatividad;
		this.url = url;

	}

}
