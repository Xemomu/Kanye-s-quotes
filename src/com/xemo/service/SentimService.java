//package com.xemo.service;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.nio.charset.StandardCharsets;
//import java.util.HashSet;
//import java.util.Set;
//
//public class SentimService {
//    Set<String> kanyeQuotes = new HashSet<String>();
//
//    public SentimService(Set<String> kanyeQuotes){
//        this.kanyeQuotes = kanyeQuotes;
//    }
//
//    public void postToSentim(){
//        try {
//            URL url = new URL("https://sentim-api.herokuapp.com/api/v1/");
//            HttpURLConnection con = (HttpURLConnection)url.openConnection();
//            con.setRequestMethod("POST");
//            con.setRequestProperty("Accept", "application/json");
//            con.setDoOutput(true);
//            String jsonInputString = "{""}";
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public StringBuilder getFromSentim(HttpURLConnection con){
//        StringBuilder response = new StringBuilder();
//        try(BufferedReader br = new BufferedReader(
//            new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
//            String responseLine = null;
//            while ((responseLine = br.readLine()) != null) {
//                response.append(responseLine.trim());
//            }
//            System.out.println(response.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return response;
//    }
//
//    public String convertQuotesToJSON(Set<String> kanyeQuotes){
//
//
//
//        return null;
//    }
//}
