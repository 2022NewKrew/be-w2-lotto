package com.kakao.ui;

import com.kakao.domain.Lotto;
import com.kakao.domain.WinningLotto;
import com.kakao.validation.CheckGameInput;

import java.util.*;

public class GameInput {

    private final CheckGameInput checkGameInput = new CheckGameInput();
    private final Scanner sc = new Scanner(System.in);
    private final List<Lotto> lottos = new ArrayList<>();

    private int money;
    private int totalLottoCnt;

    public int getMoney() { return money; }

    public List<Lotto> inputMoney() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            money = Integer.parseInt(sc.nextLine());
            totalLottoCnt = money / 1000;
            buyLottos(totalLottoCnt);
            return lottos;
        } catch (RuntimeException e) {
            return inputMoney();
        }
    }

    public WinningLotto inputWinningLotto() {
        try {
            System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
            String[] input = sc.nextLine().split(",");
            List<Integer> winningLotto = checkGameInput.checkLottoInput(input);
            return new WinningLotto(winningLotto);
        } catch (RuntimeException e) {
            return inputWinningLotto();
        }
    }

    private void buyLottos(int totalLottoCnt) {
        try {
            System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
            int customLottoCnt = Integer.parseInt(sc.nextLine());
            int autoLottoCnt = totalLottoCnt - customLottoCnt;
            checkGameInput.checkLottoCnt(totalLottoCnt, customLottoCnt);
            buyCustomLotto();
            buyAutoLotto(autoLottoCnt);
        } catch (RuntimeException e) {
            buyLottos(totalLottoCnt);
        }
    }

    private void buyCustomLotto() {

    }

    private void buyAutoLotto(int lottoCnt) {
        for (int i = 0; i < lottoCnt; i++) {
            lottos.add(new Lotto());
        }
    }
}
