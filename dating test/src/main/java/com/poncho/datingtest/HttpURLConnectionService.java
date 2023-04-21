package com.poncho.datingtest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

class HttpURLConnectionService extends Thread {

    static int responseCode;

    @Override
    public void run()
    {
        URL myUrl = null;
        try {
            myUrl = new URL("url"); // keitaro http 404
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("error");

        }
        HttpURLConnection myUrlCon =
                null;
        try {
            myUrlCon = (java.net.HttpURLConnection) myUrl.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error");
        }

        System.out.println("Method request: " +
                myUrlCon.getRequestMethod());

        try {
            responseCode = myUrlCon.getResponseCode();
            System.out.println("Code request: " +
                    responseCode);
        } catch (IOException e) {
            System.out.println("error");
            e.printStackTrace();
            System.out.println("error");
            responseCode = 404;
        }
    }

    public int getResponseCodeConnection ()
    {
        return responseCode;
    }

}