package com.github.faridma.simplehttp.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.nio.file.Files;

/**
 *
 * @author Farid F. Mammadov
 */
public class Extractor {

    public static String getStringValue(BufferedReader br) throws IOException {
        String inputLine;
        StringBuilder b = new StringBuilder();
        while ((inputLine = br.readLine()) != null) {
            b.append(inputLine);
        }
        return b.toString();
    }

    /**
     * This method designed to extract file from response and save it
     * 
     * @param c HTTP(S) connection
     * @param f destination file, to save received file
     * @throws IOException 
     */
    public static void saveFileFromOctetStream(HttpURLConnection c, File f) throws IOException {
        try (InputStream is = c.getInputStream()) {
            Files.copy(is, f.toPath());
        }
    }
}
