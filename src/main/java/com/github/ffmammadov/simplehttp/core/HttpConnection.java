package com.github.ffmammadov.simplehttp.core;

import com.github.ffmammadov.simplehttp.HttpMethod;
import com.github.ffmammadov.simplehttp.util.Extractor;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import javax.net.ssl.HttpsURLConnection;
import javax.xml.bind.DatatypeConverter;

/**
 * @author Farid F. Mammadov
 */
public class HttpConnection {

    /**
     * Creates HTTP connection with basic settings. If request method is "POST",
     * doOutput is true.
     *
     * @param connectionURL endpoint URL string
     * @param method        name of HTTP method [GET/POST]
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
     * Creates HTTP connection with basic settings. If request method is "POST",
     * doOutput is true.
     *
     * @param connectionURL endpoint URL string
     * @param method        name of HTTP method [GET/POST]
     * @param proxyHost     proxy hostname
     * @param proxyPort     proxy IP address
     * @return HTTP connection with basic configuration
     * @throws IOException
     */
    public static HttpURLConnection getConnection(String connectionURL, String method, String proxyHost, int proxyPort) throws IOException {
        URL url = new URL(connectionURL);
        SocketAddress proxyAddr = new InetSocketAddress(proxyHost, proxyPort);
        Proxy proxy = new Proxy(Proxy.Type.HTTP, proxyAddr);
        HttpURLConnection c = (HttpURLConnection) url.openConnection(proxy);
        c.setRequestMethod(method);
        if (method.equals(HttpMethod.POST)) {
            c.setDoOutput(true);
        }
        return c;
    }

    /**
     * Creates HTTP connection with basic settings. If request method is "POST",
     * doOutput is true.
     *
     * @param url    endpoint URL
     * @param method name of HTTP method [GET/POST]
     * @return HTTP connection with basic configuration
     * @throws IOException
     */
    public static HttpURLConnection getConnection(URL url, String method) throws IOException {
        HttpURLConnection c = (HttpURLConnection) url.openConnection();
        c.setRequestMethod(method);
        if (method.equals(HttpMethod.POST)) {
            c.setDoOutput(true);
        }
        return c;
    }

    /**
     * Creates HTTP connection with basic settings. If request method is "POST",
     * doOutput is true.
     *
     * @param url       endpoint URL string
     * @param method    name of HTTP method [GET/POST]
     * @param proxyHost proxy hostname
     * @param proxyPort proxy IP address
     * @return HTTP connection with basic configuration
     * @throws IOException
     */
    public static HttpURLConnection getConnection(URL url, String method, String proxyHost, int proxyPort) throws IOException {
        SocketAddress proxyAddr = new InetSocketAddress(proxyHost, proxyPort);
        Proxy proxy = new Proxy(Proxy.Type.HTTP, proxyAddr);
        HttpURLConnection c = (HttpURLConnection) url.openConnection(proxy);
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
     * @param url    endpoint URL
     * @param method name of HTTP method [GET/POST]
     * @return HTTPS connection with basic configuration
     * @throws IOException
     */
    public static HttpsURLConnection getSecureConnection(URL url, String method) throws IOException {
        HttpsURLConnection c = (HttpsURLConnection) url.openConnection();
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
     * @param method        name of HTTP method [GET/POST]
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
     * Creates HTTPS connection with basic settings. If request method is
     * "POST", doOutput is true.
     *
     * @param connectionURL endpoint URL string
     * @param method        name of HTTP method [GET/POST]
     * @param proxyHost     proxy hostname
     * @param proxyPort     proxy IP address
     * @return HTTPS connection with basic configuration
     * @throws IOException
     */
    public static HttpsURLConnection getSecureConnection(String connectionURL, String method, String proxyHost, int proxyPort) throws IOException {
        URL url = new URL(connectionURL);
        SocketAddress proxyAddr = new InetSocketAddress(proxyHost, proxyPort);
        Proxy proxy = new Proxy(Proxy.Type.HTTP, proxyAddr);
        HttpsURLConnection c = (HttpsURLConnection) url.openConnection(proxy);
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
     * @param connectionURL endpoint URL
     * @param method        name of HTTP method [GET/POST]
     * @param proxyHost     proxy hostname
     * @param proxyPort     proxy IP address
     * @return HTTPS connection with basic configuration
     * @throws IOException
     */
    public static HttpsURLConnection getSecureConnection(URL connectionURL, String method, String proxyHost, int proxyPort) throws IOException {
        SocketAddress proxyAddr = new InetSocketAddress(proxyHost, proxyPort);
        Proxy proxy = new Proxy(Proxy.Type.HTTP, proxyAddr);
        HttpsURLConnection c = (HttpsURLConnection) connectionURL.openConnection(proxy);
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
     * @param c          HTTP connection
     * @param headerName HTTP request header name
     * @param value      value to set header
     */
    public static void addRequestHeader(HttpURLConnection c, String headerName, String value) {
        c.setRequestProperty(headerName, value);
    }

    /**
     * Adds Authorization header to header
     *
     * @param c        HTTP connection
     * @param username Basic authorization login
     * @param password Basic authorization password
     */
    public static void addBasicAuthorization(HttpURLConnection c, String username, String password) {
        String authorizationString = DatatypeConverter.printBase64Binary((username + ":" + password).getBytes());
        addRequestHeader(c, "Authorization", "Basic " + authorizationString);
    }

    /**
     * Sends HTTP POST request to HTTP connection
     *
     * @param c       HTTP connection
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
     * @param c       HTTP(S) connection
     * @param charset Charset value
     * @return String representation of HTTP response body
     * @throws IOException
     */
    public static String getResponse(HttpURLConnection c, Charset charset) throws IOException {
        int responseCode = c.getResponseCode();
        StringBuilder response = new StringBuilder();
        try (InputStream is = c.getInputStream() == null ? c.getErrorStream() : c.getInputStream();
             InputStreamReader isr = new InputStreamReader(is, charset);
             BufferedReader br = new BufferedReader(isr)) {
            response.append(Extractor.getStringValue(br));
        }
        c.disconnect();
        return response.toString();
    }

}
