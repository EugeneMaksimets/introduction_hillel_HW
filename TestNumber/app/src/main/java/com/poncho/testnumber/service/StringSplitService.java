package com.poncho.testnumber.service;

public class StringSplitService {
    public static int splitString(String response) {
        String[] words = response.split(" ");
        int result = 0;
        try {
            result = Integer.parseInt(words[0]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return result;
    }
}
