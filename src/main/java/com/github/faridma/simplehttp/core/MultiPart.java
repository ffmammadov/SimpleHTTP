package com.github.faridma.simplehttp.core;

import com.github.faridma.simplehttp.MediaType;
import com.github.faridma.simplehttp.util.Extractor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

/**
 * Creates String representation of multipart/form-data request
 *
 * @author Farid F. Mammadov
 */
public class MultiPart {

    public static final String NEW_LINE = "\r\n";
    public static final String TWO_HYPHENS = "--";
    private final String boundary;
    private StringBuilder sb;
    private final HttpURLConnection connection;

    /**
     * Creates instance of MultiPart.
     *
     * @param connection HTTP connection
     */
    public MultiPart(HttpURLConnection connection) {
        sb = new StringBuilder();
        boundary = "xX" + System.currentTimeMillis() + "Xx";
        this.connection = connection;
    }

    /**
     * Configures connection by setting Content-Type multipart/form-data and
     * adds boundary
     */
    public void init() {
        connection.setRequestProperty("Content-Type", MediaType.MULTIPART_FORM_DATA + "; boundary=" + boundary);
    }

    /**
     * Adds File to multipart/form-data request.
     *
     * @param fieldName multipart/form-data fieldName
     * @param file File to add
     * @param mimeType file mimetype
     * @throws IOException
     */
    public void addFilePart(String fieldName, File file, String mimeType) throws IOException {
        String fileName = file.getName();
        sb.append(TWO_HYPHENS).append(boundary).append(NEW_LINE);
        sb.append("Content-Disposition: form-data; name=\"").append(fieldName).append("\"; filename=\"").append(fileName).append("\"").append(NEW_LINE);
        sb.append("Content-Type: ").append(mimeType).append(NEW_LINE);
        sb.append("Content-Transfer-Encoding: binary").append(NEW_LINE);
        sb.append(NEW_LINE);

        try (FileInputStream fis = new FileInputStream(file); InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr)) {
            sb.append(Extractor.getStringValue(br)).append(NEW_LINE);
        }
    }

    /**
     * Adds multipart/form-data field
     *
     * @param fieldName multipart/form-data field name
     * @param value value for field
     */
    public void addFieldPart(String fieldName, String value) {
        sb.append(TWO_HYPHENS).append(boundary).append(NEW_LINE);
        sb.append("Content-Disposition: form-data; name=\"").append(fieldName).append("\"").append(NEW_LINE);
        sb.append(NEW_LINE);
        sb.append(value).append(NEW_LINE);
    }

    /**
     * Finishes request building.
     * @return Builded multipart/form-data request
     */
    public String finish() {
        return sb.append("--").append(boundary).append("--").toString();
    }

}
