package com.xemo.service;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class KanyeService {

    private int userNumber;
    private final Set<String> kanyeQuotes = new HashSet<String>();

    public KanyeService(int userNumber) {
        this.userNumber = userNumber;
    }

    public void getKanyeQuote() throws JSONException {

        StringBuilder json = new StringBuilder();
        try {
            URI url = new URI("https://api.kanye.rest/");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.toURL().openStream(), StandardCharsets.UTF_8));
            String line;
            while ((line = in.readLine()) != null) {
                json.append(line);
            }
            JSONObject jsonObject = new JSONObject(json.toString());
            String formattedJSON = jsonObject.getString("quote");
            kanyeQuotes.add(formattedJSON);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder quotes = new StringBuilder();
        int i = 0;
        for (String s : kanyeQuotes) {
            i += 1;
            quotes.append("Quoute ").append(i).append(" : ").append(s).append("\n");
        }

        return quotes.toString();
    }

    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }

    public Set<String> getKanyeQuotes() {
        return kanyeQuotes;
    }
}
