package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.view.LottoViewInput;
import lotto.view.LottoViewOutput;

import java.util.ArrayList;

import static lotto.domain.LottoSetting.LOTTO_PRICE;

public class Main {
    public static void main(String[] args){
        Lotto lottoObject = new Lotto(LottoViewInput.lottoInitialInput()); //로또 객체 생성
        lottoObject.setLottoResult(new LottoNumber(LottoViewInput.lottoInputResult())); //로또 결과 입력
        lottoObject.makeTotal(); //결과 만들기

        LottoViewOutput lottoViewOutput = new LottoViewOutput(lottoObject);
        lottoViewOutput.printLottoCount();
        lottoViewOutput.printAllLottos();
        lottoViewOutput.printWinner();
    }
}
