package lotto.domain;

import lotto.view.LottoView;

import java.util.*;

public class LottoResult {
    private List<Integer> winningLottoNumbers = new ArrayList<>();
    private HashMap<Rank, Integer> matchMap = new HashMap<>();
    private LottoCheck lc;
    private int value;
    private int profitRate;
    private int bonusNum;

    LottoResult() {
        initMatchMap();
    }

    private void initMatchMap() {
        for (Rank rank : Rank.values()) {
            matchMap.put(rank, 0);
        }
    }

    public void inputWinningLottoNumbers(final int COUNT_OF_LOTTO_NUMBER, final int MAX_OF_LOTTO_NUMBER) {
        try {
            askWinningLottoNumbers();
            winningLottoNumbers = readWinningLottoNumbers();
            askBonusWinningLottoNumber();
            bonusNum = readBonusWinningLottoNumber();
            lc = new LottoCheck(winningLottoNumbers, bonusNum, COUNT_OF_LOTTO_NUMBER, MAX_OF_LOTTO_NUMBER);
            lc.checkWinningLottoNumbers();
        } catch (Exception e) {
            System.out.println("잘못된 당첨 번호입니다! 다시 입력해주세요.");
            inputWinningLottoNumbers(COUNT_OF_LOTTO_NUMBER, MAX_OF_LOTTO_NUMBER);
        }
    }

    private void askWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    private List<Integer> readWinningLottoNumbers() throws RuntimeException{
        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split(",");
        Integer[] intArr = new Integer[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i].trim());
        }
        List<Integer> winningLottoNumbers = new ArrayList<>(Arrays.asList(intArr));
        return winningLottoNumbers;
    }



    private void askBonusWinningLottoNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    private int readBonusWinningLottoNumber() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public void evaluateResult(List<LottoNumbers> lottos, int moneyAmount) {
        int cntOfMatch;
        Rank rank;
        for (LottoNumbers ln : lottos) {
            cntOfMatch = countMatchingNumbers(ln);
            rank = evaluateRank(cntOfMatch, ln.getLottoNumbers().contains(bonusNum));
            increaseCntOfMatch(rank);
        }
        calculateProfit(moneyAmount);
    }

    private void increaseCntOfMatch(Rank rank) {
        try {
            matchMap.put(rank, matchMap.get(rank) + 1);
        } catch (Exception e) {
            return;
        }
    }

    private Rank evaluateRank(int cntOfMatch, boolean isBonus) {
        if (cntOfMatch == Rank.FIFTH.getCntOfMatch()) return Rank.FIFTH;
        if (cntOfMatch == Rank.FOURTH.getCntOfMatch()) return Rank.FOURTH;
        if (cntOfMatch == Rank.THIRD.getCntOfMatch()) return isBonus ? Rank.SECOND : Rank.THIRD;
        if (cntOfMatch == Rank.FIRST.getCntOfMatch()) return Rank.FIRST;
        return Rank.NONE;
    }

    private int countMatchingNumbers(LottoNumbers ln) {
        int cnt = 0;
        for (int index = 0; index < ln.getLottoNumbers().size(); index++) {
            cnt += ln.getLottoNumbers().contains(winningLottoNumbers.get(index)) ? 1 : 0;
        }
        return cnt;
    }

    private void calculateProfit(int moneyAmount) {
        for (Rank rank : Rank.values()) {
            value += matchMap.get(rank) * rank.getWinningMoney();
        }
        profitRate = 100*(value - moneyAmount)/moneyAmount;
    }

    public void printResult() {
        LottoView lv = new LottoView();
        lv.printResult(matchMap, profitRate);
    }
}
