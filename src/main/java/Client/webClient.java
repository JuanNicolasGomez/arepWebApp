package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;

import static spark.Spark.port;

public class webClient {
    public static void main(String[] args) throws IOException {

        String numeros = "1,3,5,4";
        String url = "https://shielded-mesa-61282.herokuapp.com/results?numbers=" + URLEncoder.encode(numeros, "UTF-8");

        URL server = new URL(url);
        try (BufferedReader reader
                       = new BufferedReader(new InputStreamReader(server.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine); }
        } catch (IOException x) {
            System.err.println(x);
        }

    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}
