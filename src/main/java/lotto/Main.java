package lotto;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args){
//        port(8080);
//
//        get("/hello",(req, res) -> "Hello World");
        LottoGame lg = new LottoGame();
        lg.proceed();
    }
}
