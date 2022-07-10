package com.kapelle.procheck.Classes;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.github.openjson.JSONArray;

@Converter
public class JSONArrayConverter implements AttributeConverter<JSONArray, String> {

    @Override
    public String convertToDatabaseColumn(JSONArray jsonData) {
        String json;
        //if(jsonData == null || jsonData.isEmpty()){//org.jsom
        if(jsonData == null || jsonData.isNull(0)){//com.github.openjson
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