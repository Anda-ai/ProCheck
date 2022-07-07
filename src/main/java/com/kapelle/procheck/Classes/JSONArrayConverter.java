package com.kapelle.procheck.Classes;

/**
 *
 * @author anda
 */
import org.json.JSONArray;
import org.json.JSONException;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class JSONArrayConverter implements AttributeConverter<JSONArray, String> {

    @Override
    public String convertToDatabaseColumn(JSONArray jsonData) {
        String json;
        if(jsonData == null || jsonData.isEmpty()){
            json = "";
        }
        else{
            json = jsonData.toString();
        }
        return json;
    }
    @Override
    public JSONArray convertToEntityAttribute(String jsonDataAsJson) {
        System.out.println("string_jsonarray: "+jsonDataAsJson);
        JSONArray jsonData;
        if(jsonDataAsJson == null || jsonDataAsJson.isEmpty()){
            jsonData = null;
        }
        else{
            jsonData = new JSONArray(jsonDataAsJson);
        }
        return jsonData;
    }
}