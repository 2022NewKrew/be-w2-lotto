package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.view.LottoViewInput;
import lotto.view.LottoViewOutput;

import java.util.ArrayList;

import static lotto.domain.LottoSetting.LOTTO_PRICE;

public class Main {
    public static void main(String[] args){
        Lotto lottoObject = new Lotto(); //로또 객체 생성
        lottoObject.addRandomLottos(LottoViewInput.lottoInputPayment() / LOTTO_PRICE); //구매 비용을 통해 자동으로 가격에 맞춰 로또를 생성

        LottoViewOutput lottoViewOutput = new LottoViewOutput(lottoObject); //view객체에 domain객체를 연결
        lottoViewOutput.printLottoCount(); //구매한 로또 개수를 출력
        lottoViewOutput.printAllLottos(); //구매한 로또 정보를 출력

        lottoObject.setLottoResult(new LottoNumber(LottoViewInput.lottoInputResult()), LottoViewInput.lottoInputResultBonus()); //로또 결과 입력

        lottoObject.makeTotal(); //당첨 통계 집계
        lottoViewOutput.printWinner(); //당첨 통계 출력
    }
}
