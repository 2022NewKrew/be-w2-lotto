package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class WinningInfo {
    private static final String MATCH_COUNT_FORMAT = "%d개 일치(%d원)- %d개%n";
    private static final String MATCH_COUNT_BONUS_FORMAT = "%d개 일치, 보너스 볼 일치(%d원)- %d개%n";

    private final HashMap<Rank, Integer> winCount;
    private final int bonusNumber;
    private int returnAmount;

    public WinningInfo(List<Lotto> lottoList, List<Integer> winningNumber, int bonusNumber) {
        this.winCount = new HashMap<>();
        this.bonusNumber = bonusNumber;
        this.returnAmount = 0;
        initializeWinCount(lottoList, winningNumber);
        initializeReturnAmount();
    }

    public List<String> buildMessage() {
        return Arrays.stream(Rank.values()).map(rank -> {
            String format = setFormat(rank);
            return String.format(format, rank.getMatchCount(), rank.getWinningMoney(), winCount.get(rank));
        }).collect(Collectors.toList());
    }

    private String setFormat(Rank rank) {
        if (rank == Rank.SECOND) {
            return MATCH_COUNT_BONUS_FORMAT;
        }
        return MATCH_COUNT_FORMAT;
    }

    public HashMap<Rank, Integer> getWinCount() { return this.winCount; }

    public int getReturnAmount() {
        return this.returnAmount;
    }

    private void initializeWinCount(List<Lotto> lottoList, List<Integer> winningNumber) {
        for (Rank rank : Rank.values()) {
            if (rank.isWin()) this.winCount.put(rank, 0);
        }
        for (Lotto lotto : lottoList) {
            addWinCount(lotto, winningNumber, bonusNumber);
        }
    }

    private void initializeReturnAmount() {
        for (Rank rank : Rank.values()) {
            if (rank.isWin()) this.returnAmount += rank.getWinningMoney() * this.winCount.get(rank);
        }
    }

    private void addWinCount(Lotto lotto, List<Integer> winningNumber, int bonusNumber) {
        int matchCount = compare(lotto, winningNumber);
        boolean isBonusContained = lotto.getNumbers().contains(bonusNumber);
        Rank result = Rank.valueOf(matchCount, isBonusContained);
        if (result.isWin()) {
            this.winCount.put(result, this.winCount.get(result) + 1);
        }
    }

    private int compare(Lotto lotto, List<Integer> winningNumber) {
        return (int) winningNumber.stream()
                .filter(n -> lotto.getNumbers().contains(n))
                .count();
    }
}
