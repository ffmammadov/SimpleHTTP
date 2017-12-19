/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.faridma.simplehttp.core;

import com.github.faridma.simplehttp.HttpMethod;
import com.github.faridma.simplehttp.util.Extractor;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author Farid F. Mammadov
 */
public class HttpConnection {

    /**
     * Creates HTTP connection with basic settings. If request method is "POST",
     * doOutput is true.
     *
     * @param connectionURL endpoint URL string
     * @param method name of HTTP method [GET/POST]
     * @return HTTP connection with basic configuration
     * @throws IOException
     */
    public static HttpURLConnection getConnection(String connectionURL, String method) throws IOException {
        URL url = new URL(connectionURL);
        HttpURLConnection c = (HttpURLConnection) url.openConnection();
        c.setRequestMethod(method);
        if (method.equals(HttpMethod.POST)) {
            c.setDoOutput(true);
        }
        return c;
    }

    /**
     * Creates HTTPS connection with basic settings. If request method is
     * "POST", doOutput is true.
     *
     * @param connectionURL endpoint URL string
     * @param method name of HTTP method [GET/POST]
     * @return HTTPS connection with basic configuration
     * @throws IOException
     */
    public static HttpsURLConnection getSecureConnection(String connectionURL, String method) throws IOException {
        URL url = new URL(connectionURL);
        HttpsURLConnection c = (HttpsURLConnection) url.openConnection();
        c.setRequestMethod(method);
        if (method.equals(HttpMethod.POST)) {
            c.setDoOutput(true);
        }
        return c;
    }

    /**
     * Adds request header to given connection. If header already exists, value
     * overrides.
     *
     * @param c HTTP connection
     * @param headerName HTTP request header name
     * @param value value to set header
     */
    public static void addRequestHeader(HttpURLConnection c, String headerName, String value) {
        c.setRequestProperty(headerName, value);
    }

    /**
     * Adds Authorization header to header
     *
     * @param c HTTP connection
     * @param username Basic authorization login
     * @param password Basic authorization password
     */
    public static void addBasicAuthorization(HttpURLConnection c, String username, String password) {
        String authorizationString = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
        addRequestHeader(c, "Authorization", "Basic " + authorizationString);
    }

    /**
     * Sends HTTP POST request to HTTP connection
     *
     * @param c HTTP connection
     * @param content String representation of request body
     * @throws IOException
     */
    public static void sendPost(HttpURLConnection c, String content) throws IOException {
        try (DataOutputStream outputStream = new DataOutputStream(c.getOutputStream())) {
            outputStream.write(content.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
        }
    }

    /**
     * Converts HTTP response to String
     *
     * @param c HTTP connection
     * @param responseCode HTTP response code
     * @param charset Charset value
     * @return String representation of HTTP response body
     * @throws IOException
     */
    public static String getResponse(HttpURLConnection c, int responseCode, Charset charset) throws IOException {
        StringBuilder response = new StringBuilder();
        try (InputStream is = ((responseCode >= 200) && (responseCode <= 299)) ? c.getInputStream() : c.getErrorStream();
                InputStreamReader isr = new InputStreamReader(is, charset);
                BufferedReader br = new BufferedReader(isr)) {
            response.append(Extractor.getStringValue(br));
        }
        c.disconnect();
        return response.toString();
    }


}
