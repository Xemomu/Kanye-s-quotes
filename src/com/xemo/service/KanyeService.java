package com.xemo.service;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Set;

public class KanyeService {

    private Set<String> kanyeQuotes;
    private int userNumber = 0;

    public KanyeService(int userNumber) {
        this.userNumber = userNumber;
    }

    public String getKanyeQuote(){
        StringBuilder json = new StringBuilder();
        String formattedJSON = "";
        for(int i = 0; i < userNumber; i++) {
            try {

                URL url = new URL("https://api.kanye.rest/");

                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));
                String line;
                while ((line = in.readLine()) != null) {
                    json.append(line);

                    JSONObject jsonObject = new JSONObject(json);
//                    formattedJSON += "Quote " + i + ": " + jsonObject.getJSONObject("quote") + "\n";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(json);
        return json.toString();
    }
}
