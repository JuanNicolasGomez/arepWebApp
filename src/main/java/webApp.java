import org.apache.log4j.BasicConfigurator;
import spark.Request;
import spark.Response;
import logic.ListOperator;

import java.util.List;

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
                "<h1>Parcial Arep</h1>\n" +
                "<p>Web application to make operations over a list of n\n" +
                "real numbers.</p>\n" +
                "\n" +
                "<form action=\"/results\">\n" +
                "  Enter the numbers separated by commas:<br>\n" +
                "\n" +
                "  <input type=\"text\" name=\"numbers\" value=\"213,234,34,21,5546,657\"><br>\n" +
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
        ListOperator operador = new ListOperator();

        List<Integer> lista = operador.stringToList(req.queryParams("numbers"));
        int maxValue = operador.maximumValue(lista);
        int minValue = operador.minimumValue(lista);
        int sum = operador.summatory(lista);
        int mult = operador.multiplication(lista);

        return "{numeros: " + req.queryParams("numbers") + ", " +
                "maximo: " + maxValue + ", " + "minimo: " + minValue + ", " + "sumatoria: " + sum
                + ", " + "multiplicatoria: " + mult + "}";
    }

}
