package step5;

import step5.controller.LottoController;

public class Main {
    public static void main(String[] args) {
        LottoController lottoController = LottoController.getInstance();
        lottoController.startService();
    }
}