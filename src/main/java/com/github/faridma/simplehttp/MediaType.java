/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.faridma.simplehttp;

/**
 *
 * @author Farid F. Mammadov
 */
public interface MediaType {

    /**
     * "*&#47;*"
     */
    public final static String WILDCARD = "*/*";

    /**
     * "application/xml"
     */
    public final static String APPLICATION_XML = "application/xml";

    /**
     * "application/atom+xml"
     */
    public final static String APPLICATION_ATOM_XML = "application/atom+xml";

    /**
     * "application/xhtml+xml"
     */
    public final static String APPLICATION_XHTML_XML = "application/xhtml+xml";

    /**
     * "application/svg+xml"
     */
    public final static String APPLICATION_SVG_XML = "application/svg+xml";
    /**
     * "application/svg+xml"
     */

    public final static String APPLICATION_JSON = "application/json";

    /**
     * "application/x-www-form-urlencoded"
     */
    public final static String APPLICATION_FORM_URLENCODED = "application/x-www-form-urlencoded";

    /**
     * "multipart/form-data"
     */
    public final static String MULTIPART_FORM_DATA = "multipart/form-data";

    /**
     * "application/octet-stream"
     */
    public final static String APPLICATION_OCTET_STREAM = "application/octet-stream";

    /**
     * "text/plain"
     */
    public final static String TEXT_PLAIN = "text/plain";

    /**
     * "text/xml"
     */
    public final static String TEXT_XML = "text/xml";

    /**
     * "text/html"
     */
    public final static String TEXT_HTML = "text/html";

}
