package com.vass.movistar.ec.portabilidad.api;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.vass.movistar.ec.portabilidad.api.dto.RequestDNIDocument;
import com.vass.movistar.ec.portabilidad.api.dto.RequestMergedDocument;
import com.vass.movistar.ec.portabilidad.api.dto.RequestPortabilityDocument;
import com.vass.movistar.ec.portabilidad.api.dto.RequestPinRequest;
import com.vass.movistar.ec.portabilidad.api.dto.RequestPinStatus;
import com.vass.movistar.ec.portabilidad.api.dto.RequestSendOBO;
import com.vass.movistar.ec.portabilidad.api.dto.ResponseDNIDocument;
import com.vass.movistar.ec.portabilidad.api.dto.ResponseManagePortability;
import com.vass.movistar.ec.portabilidad.api.dto.ResponseMergedDocument;
import com.vass.movistar.ec.portabilidad.api.dto.ResponsePortabilityDocument;
import com.vass.movistar.ec.portabilidad.api.dto.ResponseMovistarCellphone;
import com.vass.movistar.ec.portabilidad.api.dto.ResponseOperator;
import com.vass.movistar.ec.portabilidad.api.dto.ResponseOperatorChangeText;
import com.vass.movistar.ec.portabilidad.api.dto.ResponsePinRequest;
import com.vass.movistar.ec.portabilidad.api.dto.ResponsePinStatus;
import com.vass.movistar.ec.portabilidad.api.dto.ResponsePlanDetail;
import com.vass.movistar.ec.portabilidad.api.dto.ResponseSaveFileFTP;
import com.vass.movistar.ec.portabilidad.api.dto.ResponseSendOBO;
import com.vass.movistar.ec.portabilidad.api.dto.ResponseValidDocument;

import java.io.File;

/**
 * @author angelica.fandino
 */
public interface PortabilidadUtil {

	public ResponseMovistarCellphone IsMovistarCellphone(String cellphone);

	public ResponseValidDocument IsValidDocument(String document);

	public ResponsePlanDetail GetPlanDetail(String planCode);

	public ResponseOperatorChangeText GetOperatorChangeText(ThemeDisplay themeDisplay);
	
	public ResponseOperator GetOperatorList(ThemeDisplay themeDisplay);

	public ResponseSendOBO SendOBO(RequestSendOBO requestSendOBO, ThemeDisplay themeDisplay);

	public ResponsePortabilityDocument GetPortabilityDocument(
			RequestPortabilityDocument requestPortabilityDocument);

	public ResponseDNIDocument GetDNIDocument(RequestDNIDocument requestDNIDocument);
	
	public ResponseMergedDocument GetMergedDocument(RequestMergedDocument requestMergedDocument);

	public ResponsePinRequest PinRequest(RequestPinRequest requestPinRequest);

	public ResponsePinStatus PinStatus(RequestPinStatus requestPinStatus);

	public ResponseSaveFileFTP SaveFileFTP(File file);
	
	public ResponseManagePortability ManagePortability(RequestPortabilityDocument requestPortabilityDocument,
			RequestDNIDocument requestDNIDocument, RequestSendOBO requestSendOBO, ThemeDisplay themeDisplay);

}