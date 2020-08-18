package com.vass.movistar.ec.portabilidad.service;

import com.liferay.dynamic.data.lists.model.DDLRecord;
import com.liferay.dynamic.data.lists.model.DDLRecordSet;
import com.liferay.dynamic.data.lists.service.DDLRecordSetLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PropsUtil;
import com.vass.movistar.ec.portabilidad.api.dto.OperatorID;
import com.vass.movistar.ec.portabilidad.api.dto.ResponseOperator;
import com.vass.movistar.ec.portabilidad.api.dto.ResponseOperatorChangeText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class PortabilidadDDLUtil {
	private static Log _log = LogFactoryUtil.getLog(PortabilidadDDLUtil.class);

	private DDLRecordSet getDynamicDataListByName(long scopeGroupId, String listName) {
		try {
			List<DDLRecordSet> recordSets = DDLRecordSetLocalServiceUtil.getRecordSets(scopeGroupId);
			for (DDLRecordSet recordSet : recordSets) {
				if (recordSet.getNameCurrentValue().equals(listName)) {
					return recordSet;
				}
			}
		} catch (Exception e) {
			_log.info("Error when reading dynamic data list: " + listName, e);
		}
		return null;
	}

	public Map<String, String> getAllDynamicDataList(long scopeGroupId) {

		Map<String, String> recorsetList = new HashMap<String, String>();

		try {
			List<DDLRecordSet> recordSets = DDLRecordSetLocalServiceUtil.getRecordSets(scopeGroupId);

			_log.info("Número de listas devueltas : " + recordSets.size());

			for (DDLRecordSet recordSet : recordSets) {

				_log.info("Añadiendo registros: " + recordSet.getNameCurrentValue());

				recorsetList.put(recordSet.getNameCurrentValue(), String.valueOf(recordSet.getRecordSetId()));
			}

			_log.info("Registros desde util : " + recorsetList.toString());

			return recorsetList;
		} catch (Exception e) {
			_log.info("Error when reading dynamic data list: ", e);
			return recorsetList;
		}
	}

	public static String getDDLRecordFieldStringValue(DDLRecord ddlRecord, String field, Locale locale)
			throws Exception {
		return ddlRecord.getDDMFormFieldValues(field).get(0).getValue().getString(locale);
	}

	public ResponseOperatorChangeText getDataListChangeOperator(ThemeDisplay themeDisplay) throws Exception
	{
		ResponseOperatorChangeText responseOperatorChangeText = new ResponseOperatorChangeText();

		String dataListName = PropsUtil.get("portabilidad.datalist.operatorChangeProcess");
		Locale locale = themeDisplay.getLocale();
		PortabilidadDDLUtil portabilidadDDLUtil = new PortabilidadDDLUtil();
		DDLRecordSet rsDataList = portabilidadDDLUtil.getDynamicDataListByName(themeDisplay.getScopeGroupId(),
				dataListName);
		if (rsDataList != null) {
			List<DDLRecord> ddlRecordList = rsDataList.getRecords();
			List<String> lstSubtitles = new ArrayList<String>();
			for (DDLRecord ddlRecord : ddlRecordList) {
				responseOperatorChangeText.setTitle(getDDLRecordFieldStringValue(ddlRecord, "titulo", locale));
				lstSubtitles.add(getDDLRecordFieldStringValue(ddlRecord, "subtitulo1", locale));
				lstSubtitles.add(getDDLRecordFieldStringValue(ddlRecord, "subtitulo2", locale));
				lstSubtitles.add(getDDLRecordFieldStringValue(ddlRecord, "subtitulo3", locale));
				lstSubtitles.add(getDDLRecordFieldStringValue(ddlRecord, "subtitulo4", locale));
			}

			responseOperatorChangeText.setSubtitles(lstSubtitles);
		}
		
		return responseOperatorChangeText;
	}
	
	public ResponseOperator getDataListOperators(ThemeDisplay themeDisplay) throws Exception
	{
		ResponseOperator responseOperator = new ResponseOperator();

		String dataListName = PropsUtil.get("portabilidad.datalist.operatorsList");
		Locale locale = themeDisplay.getLocale();
		PortabilidadDDLUtil portabilidadDDLUtil = new PortabilidadDDLUtil();
		DDLRecordSet rsDataList = portabilidadDDLUtil.getDynamicDataListByName(themeDisplay.getScopeGroupId(),
				dataListName);
		if (rsDataList != null) {
			List<DDLRecord> ddlRecordList = rsDataList.getRecords();
			List<OperatorID> listOperators = new ArrayList<OperatorID>();
			for (DDLRecord ddlRecord : ddlRecordList) {
				OperatorID operatorID = new OperatorID(
						getDDLRecordFieldStringValue(ddlRecord, "IdOperadora", locale),
						getDDLRecordFieldStringValue(ddlRecord, "NombreOperadora", locale));
				listOperators.add(operatorID);
			}
			
			responseOperator.setListOperators(listOperators);
		}
			
		return responseOperator;
	}

	public String getFieldValueOBO(String fieldName, ThemeDisplay themeDisplay) throws Exception
	{
		String fieldValueOBO = "";
		String dataListName = PropsUtil.get("portabilidad.datalist.oboFixedFields");
		Locale locale = themeDisplay.getLocale();
		PortabilidadDDLUtil portabilidadDDLUtil = new PortabilidadDDLUtil();
		DDLRecordSet rsDataList = portabilidadDDLUtil.getDynamicDataListByName(themeDisplay.getScopeGroupId(),
				dataListName);
		if (rsDataList != null) {
			List<DDLRecord> ddlRecordList = rsDataList.getRecords();
			for (DDLRecord ddlRecord : ddlRecordList) {
				String oboField = getDDLRecordFieldStringValue(ddlRecord, "campo", locale);
				if (oboField.equals(fieldName))
				{
					fieldValueOBO = getDDLRecordFieldStringValue(ddlRecord, "valor", locale);
					break;
				}
			}
		}
		
		return fieldValueOBO;
	}
}
