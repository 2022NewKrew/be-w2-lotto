package com.kakao.ui;

import com.kakao.domain.Lotto;
import com.kakao.domain.WinningLotto;
import com.kakao.validation.CheckGameInput;

import java.util.*;

public class GameInput {

    private final CheckGameInput checkGameInput = new CheckGameInput();
    private final Scanner sc = new Scanner(System.in);
    private final List<Lotto> lottos = new ArrayList<>();

    public int inputMoney() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            int money = Integer.parseInt(sc.nextLine());
            return money;
        } catch (RuntimeException e) {
            return inputMoney();
        }
    }

    public WinningLotto inputWinningLotto() {
        try {
            System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
            String[] input = sc.nextLine().split(",");
            List<Integer> winningLotto = checkGameInput.checkLottoInput(input);
            int bonusNum = inputBonusNum(winningLotto);
            return new WinningLotto(winningLotto, bonusNum);
        } catch (RuntimeException e) {
            return inputWinningLotto();
        }
    }

    private int inputBonusNum(List<Integer> winningLotto) {
        try {
            System.out.println("보너스 볼을 입력해 주세요.");
            int bonusNum = Integer.parseInt(sc.nextLine());
            checkGameInput.checkNumValidation(bonusNum);
            checkGameInput.checkBonusNum(winningLotto, bonusNum);
            return bonusNum;
        } catch (RuntimeException e) {
            return inputBonusNum(winningLotto);
        }
    }

    private int inputCustomLottoCnt(int totalLottoCnt) {
        try {
            System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
            int customLottoCnt = Integer.parseInt(sc.nextLine());
            checkGameInput.checkLottoCnt(totalLottoCnt, customLottoCnt);
            return customLottoCnt;
        } catch (RuntimeException e) {
            return inputCustomLottoCnt(totalLottoCnt);
        }
    }

    public List<Lotto> buyLottos(int money) {
        int totalLottoCnt = money / 1000;
        int customLottoCnt = inputCustomLottoCnt(totalLottoCnt);
        int autoLottoCnt = totalLottoCnt - customLottoCnt;
        buyCustomLotto(customLottoCnt);
        buyAutoLotto(autoLottoCnt);
        return lottos;
    }

    private void buyCustomLotto(int lottoCnt) {

    }

    private void buyAutoLotto(int lottoCnt) {
        for (int i = 0; i < lottoCnt; i++) {
            lottos.add(new Lotto());
        }
    }
}
