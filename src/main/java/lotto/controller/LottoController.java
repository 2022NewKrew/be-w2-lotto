package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.dto.OutputDTO;
import lotto.view.LottoViewInput;
import lotto.view.LottoViewOutput;

import static lotto.domain.LottoSetting.*;

public class LottoController {
    Lotto lottoObject;

    public LottoController(){}

    public void lottoRun(){
        lottoObject = new Lotto(); //로또 객체 생성
        lottoObject.addRandomLottos(LottoViewInput.lottoInputPayment() / LOTTO_PRICE); //구매 비용을 통해 자동으로 가격에 맞춰 로또를 생성

        OutputDTO outputDTO = lottoObject.getOutputDTO(); //출력을 위한 DTO를 받음
        LottoViewOutput lottoViewOutput = new LottoViewOutput();
        lottoViewOutput.printLottoCount(outputDTO); //구매한 로또 개수를 출력
        lottoViewOutput.printAllLottos(outputDTO); //구매한 로또 정보를 출력

        lottoObject.setLottoResult(new LottoNumber(LottoViewInput.lottoInputResult()), LottoViewInput.lottoInputResultBonus()); //로또 결과 입력

        lottoObject.makeTotal(); //당첨 통계 집계
        lottoViewOutput.printWinner(outputDTO); //당첨 통계 출력
    }
}
