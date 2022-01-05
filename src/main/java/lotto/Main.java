package lotto;

import lotto.view.LottoView;
import static spark.Spark.*;

public class Main {

    public static void main(String[] args) {
//        LottoView view = new LottoView();
//        view.start();
        get("/hello", (req, res) -> "Hello World!");
    }
}
