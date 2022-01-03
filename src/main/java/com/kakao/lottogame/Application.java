package com.kakao.lottogame;

public class Application {

    public static void main(String[] args) {
        try {
            LottoGame lottoGame = new LottoGame();
            lottoGame.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
