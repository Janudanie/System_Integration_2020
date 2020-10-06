package main;

import org.glassfish.jersey.server.JSONP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {

//58e0088b0aac31001185ed09
//https://cat-fact.herokuapp.com/facts/58e0088b0aac31001185ed09

        URL url = new URL("http://localhost:8080/SystemIntegration_war_exploded/webapi/myresource/fact/58e0088b0aac31001185ed09");
        //URL url = new URL("https://cat-fact.herokuapp.com/facts/58e0088b0aac31001185ed09");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        System.out.println(content);
    }
}
