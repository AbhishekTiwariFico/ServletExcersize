package com.main;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;

public class ApplicationCall {
    public static void main(String[] args) throws IOException {
        String data;

        URL url =new URL("http://localhost:8080/Information/");
        URLConnection urlConnection = url.openConnection();
//        HttpURLConnection httpURLConnection =(HttpURLConnection) url.openConnection();
//        String method = httpURLConnection.getRequestMethod();
//        String content = httpURLConnection.getHeaderField("Accept");
//        InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
//        int char = inputStreamReader.read();
//
//        byte[] data =new byte[1024];
//        inputStream.read(data);
        urlConnection.setDoOutput(true);
        BufferedReader br =new BufferedReader(new InputStreamReader(url.openStream()));
        OutputStream outputStream = urlConnection.getOutputStream();
        PrintWriter writer = new PrintWriter(outputStream);

        data = br.readLine();
       while(data!=null)
       {
           writer.println(data);
           data = br.readLine();
       }

       byte[] outData = new byte[1024];
       outputStream.write(outData);


    }
}
