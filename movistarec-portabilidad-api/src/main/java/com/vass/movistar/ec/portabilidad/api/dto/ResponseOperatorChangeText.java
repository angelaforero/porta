package com.vass.movistar.ec.portabilidad.api.dto;

import java.util.List;
import java.util.Map;

public class ResponseOperatorChangeText {

	private String status;
	private String message;
	private String title;
	private List<String> subtitles;
	private String json;
	private Map<String, String> errors;

	public ResponseOperatorChangeText() {
		this.status = "";
		this.message = "";
		this.title = "";
		this.subtitles = null;
		this.errors = null;
	}

	public ResponseOperatorChangeText(String status, String message, String title, List<String> subtitles,
			Map<String, String> errors) {
		super();
		this.status = status;
		this.message = message;
		this.title = title;
		this.subtitles = subtitles;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getSubtitles() {
		return subtitles;
	}

	public void setSubtitles(List<String> subtitles) {
		this.subtitles = subtitles;
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
		return "ResponseOperatorChangeText [status=" + status + ", message=" + message + ", title=" + title + "]";
	}
}
