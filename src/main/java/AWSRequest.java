
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class AWSRequest {
    public String getRequest(String value) throws IOException {

        String url = "https://0bmh54g028.execute-api.us-east-1.amazonaws.com/Beta?value=" + URLEncoder.encode(value, "UTF-8");
        
        URL server = new URL(url);
        String inputLine = "Something wrong has happened, please try again";
        try (BufferedReader reader
                       = new BufferedReader(new InputStreamReader(server.openStream()))) {
            
            while ((inputLine = reader.readLine()) != null) {
                return (inputLine); 
            }
        } catch (IOException x) {
            System.err.println(x);
        }
        return inputLine;
        
    }
}
