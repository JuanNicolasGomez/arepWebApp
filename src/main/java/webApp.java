import java.io.IOException;
import org.apache.log4j.BasicConfigurator;
import spark.Request;
import spark.Response;



import static spark.Spark.*;

public class webApp {

    public static void main(String[] args) {
        BasicConfigurator.configure();
        port(getPort());


        get("/", (req, res) -> "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title>Page Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<h1>Square Number</h1>\n" +
                "<p>Web application to calculate the square of a number using AWS Lambda Function and APIGateway </p>\n" +
                "\n" +
                "<form action=\"/results\">\n" +
                "  Enter the number:<br>\n" +
                "\n" +
                "  <input type=\"text\" name=\"number\" value=\"12\"><br>\n" +
                "\n" +
                "  <input type=\"submit\" value=\"Submit\">\n" +
                "</form>\n" +
                "\n" +
                "</body>\n" +
                "</html>");
        get("/results", (req, res) -> resultsPage(req, res));
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

    private static String resultsPage(Request req, Response res) {
        
        AWSRequest reqst = new AWSRequest();
        String result = "not working";
        try{     
            result = reqst.getRequest(req.queryParams("number"));
        }catch(IOException e){
            e.printStackTrace();
        }

        return result;
    }

}
