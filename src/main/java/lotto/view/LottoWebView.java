package lotto.view;

import static spark.Spark.get;
import static spark.Spark.staticFiles;

public class LottoWebView extends LottoView {

    public void start() {
        staticFiles.location("/templates");
        get("/buyLotto", (req, res) -> {
            return "Hello World!";
            return render(json, "show.html");
        });
    }

    public
}
