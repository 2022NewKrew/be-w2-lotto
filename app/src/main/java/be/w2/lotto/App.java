package be.w2.lotto;

import be.w2.lotto.boot.GameStarter;

public class App {
    public static void main(String[] args) {
        GameStarter.getInstance()
                .start();
    }
}
