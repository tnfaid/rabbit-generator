package com.example.rabbitInjectGenerator.domain.util;
import com.example.rabbitInjectGenerator.adapter.out.message_broker.CampaignProgram;
import com.example.rabbitInjectGenerator.adapter.out.message_broker.QueueFulfillment;
import com.example.rabbitInjectGenerator.adapter.out.message_broker.OfferPush;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.NonNull;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Util {
    public static final Logger tdrLogger = LogManager.getLogger("tdr");
    public static final Logger debugLogger = LogManager.getLogger("debugger");
    public static final Logger errorLogger = LogManager.getLogger("error");
    public static String hashMapToStringParam(Map<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for(Map.Entry<String, String> entry : params.entrySet()){
            if (first) {
                first = false;
                result.append("?");
            } else
                result.append("&");

            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }

        return result.toString();
    }

    public JsonObject mapToJson(Map<String,ArrayList> bonus){
        Iterator<Map.Entry<String, ArrayList>> bonusItr = bonus.entrySet().iterator();
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        while (bonusItr.hasNext()){
            Map.Entry<String, ArrayList> bonusEntry = bonusItr.next();
            ArrayList<String> bonusList = bonusEntry.getValue();
            for (String jsonArrayStr: bonusList){
                jsonArray.add(jsonArrayStr);
            }
            jsonObject.add(bonusEntry.getKey(),jsonArray);
        }
        return jsonObject;
    }

    public static String encodeBase64(String inputString) {
        String base64 = "";

        try {
            byte[] byteArray = Base64.encodeBase64(inputString.getBytes());
            base64 = new String(byteArray);
        } catch (Exception e) {
            Util.debugLogger.error("Error while encode Base64..{}",e);
        }

        return base64;
    }

    public static String parseSHA256(String inputString) {
        String sha256 = "";

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashInBytes = md.digest(inputString.getBytes(StandardCharsets.UTF_8));

            // bytes to hex
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : hashInBytes) {
                stringBuilder.append(String.format("%02x", b));
            }

            sha256 = stringBuilder.toString();
        }
        catch (Exception e) {
            Util.debugLogger.error("Error while hash SHA256..{}",e);
        }

        return sha256;
    }

    public JSONObject esbFulfillmentToJSONObject(QueueFulfillment queueFulfillment){
        String jsonString= new Gson().toJson(queueFulfillment);
        return new JSONObject(jsonString);
    }

    public JSONObject esbFulfillmentToJSONObject(OfferPush offerPush){
        String jsonString= new Gson().toJson(offerPush);
        return new JSONObject(jsonString);
    }

    public JSONObject esbFulfillmentToJSONObject(CampaignProgram campaignProgram){
        String jsonString= new Gson().toJson(campaignProgram);
        return new JSONObject(jsonString);
    }

    public static String generateID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
    public String mapToString(Map<String, ArrayList> map){
        StringBuilder mapAsString = new StringBuilder("{");
        for (String key : map.keySet()) {
            mapAsString.append(key + ":" + map.get(key) + ", ");
        }
        mapAsString.delete(mapAsString.length()-2, mapAsString.length()).append("}");
        return mapAsString.toString();
    }
    public String dateToString(){
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(date);
        return strDate;
    }

    public static Throwable lastThrowable(@NonNull Throwable throwable) {
        Throwable result = throwable;

        while ((throwable = throwable.getCause()) != null) {
            result = throwable;
        }

        return result;
    }

}
