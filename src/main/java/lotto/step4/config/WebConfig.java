package lotto.step4.config;

import static spark.Spark.port;
import static spark.Spark.staticFiles;

public class WebConfig {
    public static void initPort() {
        port(8080);
    }

    public static void metaData() {
        staticFiles.location("/templates");
    }
}
