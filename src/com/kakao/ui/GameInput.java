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
            System.out.println("구입금액을 입력해 주세요. (로또는 1장에 1000원 입니다.)");
            int money = Integer.parseInt(sc.nextLine());
            checkGameInput.checkNegativeNumber(money);
            return money;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return inputMoney();
        }
    }

    public WinningLotto inputWinningLotto() {
        try {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            String[] input = sc.nextLine().split(",");
            List<Integer> winningLotto = checkGameInput.checkLottoInput(input);
            int bonusNumber = inputBonusNumber(winningLotto);
            return new WinningLotto(winningLotto, bonusNumber);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return inputWinningLotto();
        }
    }

    private int inputBonusNumber(List<Integer> winningLotto) {
        try {
            System.out.println("보너스 볼을 입력해 주세요.");
            int bonusNumber = Integer.parseInt(sc.nextLine());
            checkGameInput.checkNumberValidation(bonusNumber);
            checkGameInput.checkBonusNumber(winningLotto, bonusNumber);
            return bonusNumber;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber(winningLotto);
        }
    }

    private int inputCustomLottoCount(int totalLottoCount) {
        try {
            System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
            int customLottoCount = Integer.parseInt(sc.nextLine());
            checkGameInput.checkLottoCount(totalLottoCount, customLottoCount);
            return customLottoCount;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return inputCustomLottoCount(totalLottoCount);
        }
    }

    public List<Lotto> buyLottos(int money) {
        int totalLottoCount = money / 1000;
        int customLottoCount = inputCustomLottoCount(totalLottoCount);
        int autoLottoCount = totalLottoCount - customLottoCount;
        buyCustomLotto(customLottoCount);
        buyAutoLotto(autoLottoCount);
        return lottos;
    }

    private void buyCustomLotto(int lottoCount) {

    }

    private void buyAutoLotto(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto());
        }
    }
}
