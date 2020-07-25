/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.services;

import com.app.commons.Constant;
import com.app.entity.Result;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONObject;

/**
 *
 * @author ahza0
 */
public class BaseService {

    String baseUrl;

    public Result get(String search, int page, int pageSize, String sort, boolean asc) throws MalformedURLException, IOException {
        Result result = null;
        String pathUrl = Constant.BASE_URL + baseUrl;
        pathUrl += "?search=" + search;
        pathUrl += "&page=" + page;
        pathUrl += "&pageSize=" + pageSize;
        pathUrl += "&sort=" + sort;
        pathUrl += "&asc=" + asc;
        URL url = new URL(pathUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int status = con.getResponseCode();
        if (status == 200) {
            JSONObject json = createJsonFromInputSTream(con.getInputStream());
            result = new Result(json);
        }
        return result;
    }

    public Result get(Object id) throws MalformedURLException, IOException, Exception {
        Result result = null;
        String pathUrl = Constant.BASE_URL + baseUrl + "/" + id.toString();
        URL url = new URL(pathUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int status = con.getResponseCode();
        if (status == 200) {
            JSONObject json = createJsonFromInputSTream(con.getInputStream());
            result = new Result(json);
        }
        return result;
    }

    public Result post(JSONObject entity) throws MalformedURLException, IOException {
        String pathUrl = Constant.BASE_URL + baseUrl;
        URL url = new URL(pathUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con = writeData(con, entity);
        int status = con.getResponseCode();
        Result result = null;
        if (status == 200) {
            JSONObject json = createJsonFromInputSTream(con.getInputStream());
            result = new Result(json);
        }
        return result;
    }

    public Result put(JSONObject entity) throws MalformedURLException, IOException {
        String pathUrl = Constant.BASE_URL + baseUrl;
        URL url = new URL(pathUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("PUT");        
        con = writeData(con, entity);
        int status = con.getResponseCode();
        Result result = null;
        if (status == 200) {
            JSONObject json = createJsonFromInputSTream(con.getInputStream());
            result = new Result(json);
        }
        return result;
    }

    public Result delete(Object id) throws MalformedURLException, IOException {
        Result result = null;
        String pathUrl = Constant.BASE_URL + baseUrl + "/" + id.toString();
        URL url = new URL(pathUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("DELETE");
        int status = con.getResponseCode();
        if (status == 200) {
            JSONObject json = createJsonFromInputSTream(con.getInputStream());
            result = new Result(json);
        }
        return result;
    }

    private JSONObject createJsonFromInputSTream(InputStream stream) throws IOException {
        JSONObject result = new JSONObject();
        BufferedReader br;
        try (InputStreamReader in = new InputStreamReader(stream)) {
            br = new BufferedReader(in);
            String line = "";
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            result = new JSONObject(sb.toString());
        }
        br.close();
        return result;
    }
    
    private HttpURLConnection writeData(HttpURLConnection con, JSONObject entity) throws IOException{
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.write(entity.toString().getBytes());
        return con;
    }

}
