package lotto;

import lotto.step1.Step1LottoGame;
import lotto.step2.Step2LottoGame;
import lotto.step3.Step3LottoGame;
import lotto.step4.LottoGameWebApplication;
import lotto.step5.LottoGameWebUsingDBApplication;

public class Main {
    public static void main(String[] args) {
//        Step1LottoGame step1LottoGame = new Step1LottoGame();
//        step1LottoGame.run();

//        Step2LottoGame step2LottoGame = new Step2LottoGame();
//        step2LottoGame.run();

//        Step3LottoGame step3LottoGame = new Step3LottoGame();
//        step3LottoGame.run();

//        LottoGameWebApplication lottoGameWebApplication = new LottoGameWebApplication();
//        lottoGameWebApplication.run();

        LottoGameWebUsingDBApplication lottoGameWebUsingDBApplication = new LottoGameWebUsingDBApplication();
        lottoGameWebUsingDBApplication.run();
    }
}
