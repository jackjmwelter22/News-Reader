package com.jackwelter.newsreader;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by jackjmwelter22 on 11/21/17.
 */

public class JsonConverter {

    //Filename
    InputStream inputStreamObject;

    //constructor
    public JsonConverter(InputStream inputStreamObject){
        this.inputStreamObject = inputStreamObject;
    }


    public static StringBuilder inputStreamToStringBuilder(InputStream inputStreamObject){

        try{
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(inputStreamObject, "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();

            String inputStr;
            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);

            return responseStrBuilder;

        }catch(Exception e){
            e.printStackTrace();
            return new StringBuilder();
        }
    }

    //Returns a json object from an input stream
    public JSONObject getJsonObject(){

        try {

            StringBuilder responseStrBuilder = JsonConverter.inputStreamToStringBuilder(inputStreamObject);

            JSONObject jsonObject = new JSONObject(responseStrBuilder.toString());

            //returns the json object
            return jsonObject;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        //if something went wrong, return null
        return null;
    }
}
