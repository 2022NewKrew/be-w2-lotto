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

        lottoObject.lottoBuy(LottoViewInput.lottoInputPayment()); //로또를 구매할 가격을 먼저 입력받음
        //lottoObject.addRandomLottos( / LOTTO_PRICE); //구매 비용을 통해 자동으로 가격에 맞춰 로또를 생성

        OutputDTO outputDTO = lottoObject.getOutputDTO(); //출력을 위한 DTO를 받음
        LottoViewOutput lottoViewOutput = new LottoViewOutput();
        lottoViewOutput.printLottoCount(outputDTO); //구매한 로또 개수를 출력
        lottoViewOutput.printAllLottos(outputDTO); //구매한 로또 정보를 출력

        lottoObject.setLottoResult(new LottoNumber(LottoViewInput.lottoInputResult(() -> {System.out.println("지난 주 당첨 번호를 입력해 주세요.");})), LottoViewInput.lottoInputResultBonus()); //로또 결과 입력

        lottoObject.makeTotal(); //당첨 통계 집계
        lottoViewOutput.printWinner(outputDTO); //당첨 통계 출력
    }
}
