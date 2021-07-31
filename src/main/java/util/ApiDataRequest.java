package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ApiDataRequest {

    JSONObject resJsonObj;

    public void sendRequest() {

        RestAssured.baseURI= "https://reqres.in/api";

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,"/users?page=2");
        String responseBody = response.getBody().asString();
        //ResponseBody<?> responseBody = response.getBody();
        //jsonToMap(responseBody);


        //String responseBody = response.getBody().asString();

        JSONParser parse = new JSONParser();

        try {
            resJsonObj = (JSONObject) parse.parse(responseBody);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        _jsonToMap_(resJsonObj);
        //printJsonObject(resJsonObj);
        int statusCode = response.getStatusCode();
        System.out.println(responseBody);
        System.out.println(statusCode);


    }

    public void sendPostRequest() {

        RequestSpecBuilder builder = new RequestSpecBuilder();



    }


    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void printJsonObject(JSONObject jsonObj) {


        for (Object key : jsonObj.keySet()) {
            //based on you key types
            String keyStr = (String)key;
            Object keyvalue = jsonObj.get(keyStr);

            //Print key and value
            System.out.println("key: "+ keyStr + " value: " + keyvalue);

	    /*

			Map currentKeyVal = ((Map)jsonObj.get(keyStr));
	        Iterator<Map.Entry> itr1 = currentKeyVal.entrySet().iterator();
	        while (itr1.hasNext()) {
	            Map.Entry pair = itr1.next();
	            System.out.println(pair.getKey() + " : " + pair.getValue());
	        }


	        if (keyvalue instanceof JSONArray) {

	        	JSONArray innerJArray =  (JSONArray) jsonObj.get(keyStr);
	        	Iterator jaIter = innerJArray.iterator();
	        	While(jaIter.hasNext()){
	        		Iterator<Map.Entry> itrInner = ((Map)jaIter.next())
	        	}



	        }

	       */
            //for nested objects iteration if required
            if (keyvalue instanceof JSONObject)
                printJsonObject((JSONObject)keyvalue);
        }


    }

	/*
	private static Map<String,Object> jsonToMap(Object json){

		if(json instanceof JSONObject) {

			return _jsonToMap((JSONObject)json);
		}
		else if(json instanceof String) {
			JSONObject jsonObject = new JSONObject(json);
			System.out.println("it is a string");
		}
	}

	*/

    public Map<String, Object> _jsonToMap_(JSONObject json){
        Map<String, Object> retMap = new HashMap<String, Object>();

        //if(json != JSONObject.NULL) {
        retMap = toMap(json);
        //}
        return retMap;
    }


    private static Map<String, Object> toMap(JSONObject object){
        Map<String, Object> map = new HashMap<String, Object>();

        Set<?> s = object.keySet();
        Iterator<?> keysItr = s.iterator();
        while(keysItr.hasNext()) {
            String key = keysItr.next().toString();
            Object value = object.get(key);

            //Print key and value
            System.out.println("key: "+ key + " value: " + value);

            if(value instanceof JSONArray) {
                value = toList((JSONArray) value);
            }

            else if(value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }

            map.put(key, value);
        }
        return map;
    }

    public static List<Object> toList(JSONArray array){
        List<Object> list = new ArrayList<Object>();
        for(int i = 0; i < array.size(); i++) {
            Object value = array.get(i);
            if(value instanceof JSONArray) {
                value = toList((JSONArray) value);
            }

            else if(value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            System.out.println(" value: " + value);
            list.add(value);
        }
        return list;
    }


}
