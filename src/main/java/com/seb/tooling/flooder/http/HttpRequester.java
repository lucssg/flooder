package com.seb.tooling.flooder.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

/**
 * Created by caskdor on 03/07/16.
 */
public class HttpRequester {

    private static final Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("gateway.seb.zscaler.net", 9480));

    public String request(String requestUrl) {
        HttpURLConnection connection = null;
        URL url;
        StringBuilder response = null;
        try {
            url = new URL(requestUrl);
            connection = (HttpURLConnection) url.openConnection(proxy);

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            response = new StringBuilder();
            String line;
            while (null != (line= br.readLine())) {
                response.append(line);
                response.append("\n");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        return response.toString();
    }

}
