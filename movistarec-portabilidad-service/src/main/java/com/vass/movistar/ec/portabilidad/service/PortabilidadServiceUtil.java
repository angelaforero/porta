package com.vass.movistar.ec.portabilidad.service;

import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.TimeZoneUtil;
import com.vass.movistar.ec.portabilidad.api.dto.PortabilitySOAPHeaders;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class PortabilidadServiceUtil {

	public static final String PATTERN_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

	public static String getFormatCurrentTimeStamp() {
		Date date = new Date();
		final DateFormat df = new SimpleDateFormat(PATTERN_DATE_FORMAT);
		TimeZone timeZone = getTimeZone();

		df.setTimeZone(TimeZone.getTimeZone(timeZone.getID()));

		return df.format(date);
	}

	public static TimeZone getTimeZone() {
		TimeZone timeZone = null;
		String sTimeZoneEntity = PropsUtil.get("portabilidad.time.zone");

		if (sTimeZoneEntity != null) {
			timeZone = TimeZone.getTimeZone(sTimeZoneEntity);
		} else {
			timeZone = TimeZoneUtil.getDefault();
		}

		return timeZone;
	}

	public static PortabilitySOAPHeaders GetPortabilityHeaders() {
		PortabilitySOAPHeaders soapHeaders = new PortabilitySOAPHeaders();
		soapHeaders.setApplication(PropsUtil.get("portabilidad.headerin.application"));
		soapHeaders.setServiceChannel(PropsUtil.get("portabilidad.headerin.serviceChannel"));
		soapHeaders.setPassword(PropsUtil.get("portabilidad.headerin.password"));
		soapHeaders.setUserLogin(PropsUtil.get("portabilidad.headerin.userLogin"));
		soapHeaders.setIpAddress(PropsUtil.get("portabilidad.headerin.ipaddress"));
		return soapHeaders;
	}
}
