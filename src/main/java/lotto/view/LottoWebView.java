package lotto.view;

import static spark.Spark.get;
import static spark.Spark.staticFiles;

public class LottoWebView implements LottoView{


    public void start(){
        staticFiles.location("/templates");
        get("/hello", (req, res) -> "Hello World!");
    }
}
