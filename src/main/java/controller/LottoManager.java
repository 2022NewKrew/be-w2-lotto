package controller;

import model.Lottos;
import view.InputManager;
import view.PrintManager;

import java.util.List;

public class LottoManager {
    public static void run() {
        // 시작 정보 입력 받음
        int buyPrice = InputManager.inputBuyPrice();

        // 로또 생성
        Lottos lottos = new Lottos(buyPrice);

        // 로또 번호 출력
        PrintManager.printLottos(lottos.toString());

        // 당첨 로또 번호 입력 받음
        List<Integer> winningNumber = InputManager.inputWinningNumber();
        // 보너스 볼 입력 받음
        int bonusNumber = InputManager.inputBonusNumber();

        // 로또 결과 확인
        PrintManager.printResult(lottos.checkResult(winningNumber, bonusNumber));
        // 로또 수익률 확인
        PrintManager.printWinRate(lottos.checkWinRate(lottos.checkResult(winningNumber, bonusNumber)));
    }
}
