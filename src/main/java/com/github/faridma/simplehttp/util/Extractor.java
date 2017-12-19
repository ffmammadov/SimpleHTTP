package com.github.faridma.simplehttp.util;

import java.io.BufferedReader;
import java.io.IOException;

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
}
