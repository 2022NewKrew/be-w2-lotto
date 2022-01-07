package lotto.domain;

import lotto.constant.Lotto;
import lotto.constant.Rank;
import lotto.dto.LottoGameDto;
import lotto.dto.LottoPurchaseDto;
import lotto.util.LottoGenerator;

import java.util.*;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;

    public LottoPurchaseDto autoBuy(int money) {
        int purchaseGameCnt = money / LOTTO_PRICE;
        List<LottoGameDto> lottoGames = new ArrayList<>();

        for(int i = 0; i < purchaseGameCnt; i++) {
            lottoGames.add(new LottoGameDto(LottoGenerator.getRandomNumbers()));
        }
        return new LottoPurchaseDto(money, purchaseGameCnt, lottoGames);
    }

    public Map<Rank, Integer> checkRank(LottoPurchaseDto lotto, List<Integer> winningNumber, int bonusNumber) {
        Map<Rank, Integer> ranks = new EnumMap<>(Rank.class);
        for (Rank value : Rank.values()) {
            ranks.put(value, 0);
        }

        for (LottoGameDto lottoGame : lotto.getLottoGames()) {
            int countOfSameNumbers = getCountOfSameNumbers(lottoGame.getPickedList(), winningNumber);
            Rank rank = Rank.valueOf(countOfSameNumbers, checkBonusNumber(lottoGame.getPickedList(), bonusNumber));
            if (countOfSameNumbers >= 3) {
                ranks.put(rank, ranks.get(rank) + 1);
            }
        }
        return ranks;
    }

    private boolean checkBonusNumber(List<Integer> pickedList, int bonusNumber) {
        return pickedList.contains(bonusNumber);
    }

    private int getCountOfSameNumbers(List<Integer> lotto, List<Integer> winningNumber){
        return (int) lotto.stream().filter(winningNumber::contains).count();
    }

    public Long getTotalWinningMoney(Map<Rank, Integer> ranks) {
        Long totalWinningMoney = 0l;
        for (Map.Entry<Rank, Integer> entry : ranks.entrySet()) {
            totalWinningMoney += (entry.getKey().getWinningMoney() * entry.getValue());
        }
        return totalWinningMoney;
    }
}
