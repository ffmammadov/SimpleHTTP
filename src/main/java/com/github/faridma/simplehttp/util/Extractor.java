/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.faridma.simplehttp.util;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author mrfar
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
