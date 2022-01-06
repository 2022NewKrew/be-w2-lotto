package lotto.domain;

import lotto.view.LottoView;

import java.util.*;

import static lotto.domain.LottoConstants.*;

public class LottoManager {
    private int moneyAmount;
    private int numOfLottos;
    private int numOfManualLottos;
    private final List<LottoNumbers> lottos = new ArrayList<>();
    private LottoNumbers winningLottoNumbers;
    private int bonusWinningLottoNumber;
    private final LottoView lv = new LottoView();

    public void start() {
        inputMoneyAmount();
        inputManualNumOfLottos();
        inputManualLottoNumbers();
        generateAutoLottoNumbers();
        printLottos();
        inputWinningLottoNumbers();
        inputBonusWinningLottoNumber();

        LottoResult lr = new LottoResult(moneyAmount, lottos, winningLottoNumbers, bonusWinningLottoNumber);
        printResult(lr.getMatchMap(), lr.getProfitRate());
    }

    private void inputMoneyAmount() {
        lv.askMoneyAmount();
        try {
            moneyAmount = readMoneyAmount();
            numOfLottos = moneyAmount / PRICE_OF_LOTTO;
        } catch (Exception e) {
            lv.warnInvalidMoneyAmount();
            inputMoneyAmount();
        }
    }

    private void inputManualNumOfLottos() {
        lv.askManualNumOfLotto();
        try {
            numOfManualLottos = readManualNumOfLottos();
        } catch (Exception e) {
            lv.warnInvalidManualNumOfLotto();
            inputManualNumOfLottos();
        }
    }

    private void inputManualLottoNumbers() {
        int lottoCnt = 0;
        if (numOfManualLottos != 0) lv.askManualLottoNumbers();
        while (lottoCnt < numOfManualLottos) {
            try {
                lottos.add(readLottoNumbers());
                lottoCnt += 1;
            } catch (Exception e) {
                lv.warnInvalidManualLottoNumbers();
                inputManualLottoNumbers();
            }
        }
    }

    private void inputWinningLottoNumbers() {
        lv.askWinningLottoNumbers();
        try {
            winningLottoNumbers = readLottoNumbers();
        } catch (Exception e) {
            lv.warnInvalidWinningLottoNumbers();
            inputWinningLottoNumbers();
        }
    }

    private void inputBonusWinningLottoNumber() {
        lv.askBonusWinningLottoNumber();
        try {
            bonusWinningLottoNumber = readBonusWinningLottoNumber();
        } catch (Exception e) {
            lv.warnInvalidBonusWinningLottoNumbers();
            inputBonusWinningLottoNumber();
        }
    }

    private int readMoneyAmount() throws RuntimeException {
        Scanner sc = new Scanner(System.in);
        return checkMoneyAmount(sc.nextInt());
    }

    private int readManualNumOfLottos() throws RuntimeException {
        Scanner sc = new Scanner(System.in);
        return checkNumOfManualLottos(sc.nextInt());
    }

    private LottoNumbers readLottoNumbers() throws RuntimeException {
        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split(",");
        Integer[] intArr = new Integer[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i].trim());
        }
        return new LottoNumbers(new ArrayList<>(Arrays.asList(intArr)));
    }

    private int readBonusWinningLottoNumber() throws RuntimeException {
        Scanner sc = new Scanner(System.in);
        return checkBonusWinningLottoNumber(sc.nextInt());
    }

    private int checkMoneyAmount(int money) throws IllegalArgumentException {
        if (money < 0) throw new IllegalArgumentException("소지 금액은 0 이상만 가능합니다!");
        return money;
    }

    private int checkNumOfManualLottos(int num) throws IllegalArgumentException {
        if (num < 0) throw new IllegalArgumentException("수동 로또 개수는 0 이상이어야 합니다!");
        if (num > numOfLottos) throw new IllegalArgumentException("수동 로또 개수는 전체 로또 개수 이하여야 합니다!");
        return num;
    }

    private int checkBonusWinningLottoNumber(int bonusWinningLottoNumber) throws IllegalArgumentException {
        if (winningLottoNumbers.contains(bonusWinningLottoNumber))
            throw new IllegalArgumentException("보너스 당첨 번호가 로또 당첨 번호와 겹치지 않아야 합니다!");
        if (bonusWinningLottoNumber < MIN_OF_LOTTO_NUMBER)
            throw new IllegalArgumentException("로또 당첨 번호는 가능한 최소값 이상이어야 합니다!");
        if (bonusWinningLottoNumber > MAX_OF_LOTTO_NUMBER)
            throw new IllegalArgumentException("로또 당첨 번호는 가능한 최대값 이하여야 합니다!");
        return bonusWinningLottoNumber;
    }

    private void generateAutoLottoNumbers() {
        int numOfAutoLottos = numOfLottos - numOfManualLottos;
        for (int i = 0; i < numOfAutoLottos; i++) {
            lottos.add(new LottoNumbers());
        }
    }

    private void printLottos() {
        lv.printLottos(lottos, numOfManualLottos);
    }

    private void printResult(HashMap<Rank, Integer> matchMap, int profitRate) {
        lv.printResult(matchMap, profitRate);
    }
}
