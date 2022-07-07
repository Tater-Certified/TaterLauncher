package com.github.tatercertified.auth;

import com.github.tatercertified.util.DataCompressor;
import com.github.tatercertified.util.HttpUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class MSAuth {

    public static DataCompressor initGet() {
        try {
            URI liveLogin = new URI("https://login.live.com/oauth20_authorize.srf?client_id=000000004C12AE6F&redirect_uri=https://login.live.com/oauth20_desktop.srf&scope=service::user.auth.xboxlive.com::MBI_SSL&display=touch&response_type=token&locale=en");

            Map<String, String> headers = new HashMap<>();

            String response = HttpUtils.get(liveLogin, headers);
            String urlPost = "";
            String value = "";

            System.out.println("Response: " + response);
            String[] cutResponse = response.split("<");
            for (String cut : cutResponse) {
                if (cut.contains("urlPost")) {
                    urlPost = cut;
                }
                if (cut.contains("value")) {
                    value = cut;
                }
            }

            while (urlPost.indexOf(",urlPost:") < urlPost.indexOf("',at:true")) {
                urlPost = urlPost.substring(urlPost.indexOf(",urlPost:") + 10, urlPost.indexOf("',at:true"));
            }
            while (value.indexOf("value=\"") < value.indexOf("\"/>',")) {
                value = value.substring(value.indexOf("value=\"") + 7, value.indexOf("\"/>',"));
            }
            System.out.println("Param 1: " + urlPost);
            System.out.println("Param 2: " + value);

            return new DataCompressor(urlPost, value);

        } catch (URISyntaxException e) {
            e.printStackTrace();

            return new DataCompressor();
        }
    }


    public static void loginMicrosoft() {
        DataCompressor urlPostPlusValue = initGet();
        String urlPost = urlPostPlusValue.getKey();
        String value = urlPostPlusValue.getValue();
        String accountEmail = "email";
        String accountPassword = "password";
        try {
            Map<String, String> headers = new HashMap<>();
            Map<String,String> data = new HashMap<>();
            data.put("login", accountEmail);
            data.put("loginfmt", accountEmail);
            data.put("passwd", accountPassword);
            data.put("PPFT", value);
            String response = HttpUtils.post(new URI(urlPost), headers, String.valueOf(data));
            System.out.println(response);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


    public static void loginMSApi() {
    }
}
