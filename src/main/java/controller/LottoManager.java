package controller;

import model.Lotto;
import model.Lottos;
import view.InputManager;
import view.PrintManager;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoManager {
    public static void run() {
        // 구입금액 입력 받음
        int buyPrice = InputManager.inputBuyPrice();

        // 수동으로 구매할 로또 수 입력 받음
        int manualCount = InputManager.inputManualCount(buyPrice);

        // 위에서 입력한 갯수만큼 수동으로 로또 생성
        Lottos manualLottos = new Lottos(IntStream
                .range(0,manualCount)
                .mapToObj((i)->new Lotto(InputManager.inputManualNumber()))
                .collect(Collectors.toList()));

        // 수동(기존) + 자동 로또 생성
        Lottos lottos = new Lottos(manualLottos, buyPrice);

        // 로또 번호 출력
        PrintManager.printLottos(lottos.toString());

        // 당첨 로또 번호 입력 받음
        List<Integer> winningNumber = InputManager.inputWinningNumber();
        // 보너스 볼 입력 받음
        int bonusNumber = InputManager.inputBonusNumber(winningNumber);

        // 로또 결과 확인
        PrintManager.printResult(lottos.checkResult(winningNumber, bonusNumber));
        // 로또 수익률 확인
        PrintManager.printWinRate(lottos.checkWinRate(lottos.checkResult(winningNumber, bonusNumber)));
    }
}
