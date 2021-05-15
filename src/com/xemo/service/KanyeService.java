package com.xemo.service;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class KanyeService {

    private Set<String> kanyeQuotes = new HashSet<>(19);
    private int userNumber = 0;

    public KanyeService(int userNumber) {
        this.userNumber = userNumber;
    }

    public String getKanyeQuote(){
        StringBuilder json = new StringBuilder();
        String formattedJSON = "";
        while(kanyeQuotes.size() <= userNumber) {
            try {
                URI url = new URI("https://api.kanye.rest/");
                BufferedReader in = new BufferedReader(new InputStreamReader(url.toURL().openStream(), StandardCharsets.UTF_8));
                String line;
                while ((line = in.readLine()) != null) {
                    json.append(line);

                    JSONObject jsonObject = new JSONObject(json);
                    formattedJSON += jsonObject.get("quote");
                    kanyeQuotes.add(formattedJSON);
                }
            } catch (IOException | JSONException | URISyntaxException e) {
                e.printStackTrace();
            }
        }
        System.out.println(json);
        return json.toString();
    }
}
