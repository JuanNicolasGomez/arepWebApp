import org.apache.log4j.BasicConfigurator;

import static spark.Spark.*;

public class webApp {

    public static void main(String[] args) {
        BasicConfigurator.configure();
        port(getPort());
        get("/hello", (req, res) -> "Hello Heroku");
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

}
