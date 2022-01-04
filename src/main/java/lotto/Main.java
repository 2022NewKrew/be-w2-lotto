package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.view.LottoViewInput;
import lotto.view.LottoViewOutput;

import java.util.ArrayList;

import static lotto.domain.LottoSetting.LOTTO_PRICE;

public class Main {
    public static void main(String[] args){
        LottoController lottoController = new LottoController();
        lottoController.lottoRun();
    }
}
