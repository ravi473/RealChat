package com.ea.utils;
import javax.json.Json;
/**
 * Created by ravikumarpothuganti on 2017-08-27.
 */


public class JsonUtil {

    public static String formatMessage(String message, String user) {
        return Json.createObjectBuilder()
                .add("text", message)
                .add("userName", user)
                //.add("messageScore", )
                .build().toString();
    }

}
