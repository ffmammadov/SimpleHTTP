package com.github.ffmammadov.simplehttp;

import java.util.Map;

public class HttpRequest {
    /**
     * Sends HTTP <code>GET</code> request
     *
     * @param url     URL address of resource
     * @param headers HTTPHeaders
     * @return response body as {@link String}
     */
    public String get(String url, Map<String, String> headers) {
        throw new UnsupportedOperationException();
    }

    /**
     * Sends HTTP <code>POST</code> request
     *
     * @param url     URL address of resource
     * @param headers HTTPHeaders
     * @param body    The request body
     * @return response body as {@link String}
     */
    public String post(String url, Map<String, String> headers, String body) {
        throw new UnsupportedOperationException();
    }


    /**
     * Sends HTTP <code>GET</code> request with proxy
     *
     * @param url     URL address of resource
     * @param headers HTTPHeaders
     * @param proxy   The {@link HttpProxy} address
     * @return response body as {@link String}
     */
    public String get(String url, Map<String, String> headers, HttpProxy proxy) {
        throw new UnsupportedOperationException();
    }

    /**
     * Sends HTTP <code>POST</code> request
     *
     * @param url     URL address of resource
     * @param headers HTTPHeaders
     * @param body    The request body
     * @param proxy   The {@link HttpProxy} address
     * @return response body as {@link String}
     */
    public String post(String url, Map<String, String> headers, String body, HttpProxy proxy) {
        throw new UnsupportedOperationException();
    }
}
