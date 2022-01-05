package lotto.domain;

import lotto.constant.Lotto;
import lotto.constant.Rank;
import lotto.dto.LottoGameDto;
import lotto.dto.LottoPurchaseDto;
import lotto.util.LottoGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {

    public LottoPurchaseDto autoBuy(int money) {
        int purchaseGameCnt = money / Lotto.PRICE.getValue();
        List<LottoGameDto> lottoGames = new ArrayList<>();

        for(int i = 0; i < purchaseGameCnt; i++) {
            lottoGames.add(new LottoGameDto(LottoGenerator.getNumbers()));
        }
        return new LottoPurchaseDto(money, purchaseGameCnt, lottoGames);
    }

    public Map<Integer, Integer> checkRank(LottoPurchaseDto lotto, List<Integer> winningNumber) {
        Map<Integer, Integer> ranks = new HashMap<>();
        for (Rank value : Rank.values()) {
            ranks.put(value.getCountOfMatch(), 0);
        }

        for (LottoGameDto lottoGame : lotto.getLottoGames()) {
            int countOfSameNumbers = getCountOfSameNumbers(lottoGame.getPickedList(), winningNumber);
            if (countOfSameNumbers >= 3) {
                ranks.put(countOfSameNumbers, ranks.get(countOfSameNumbers) + 1);
            }
        }
        return ranks;
    }

    private int getCountOfSameNumbers(List<Integer> lotto, List<Integer> winningNumber){
        return (int) lotto.stream().filter(winningNumber::contains).count();
    }

    public Long getTotalWinningMoney(Map<Integer, Integer> ranks) {
        Long totalWinningMoney = 0l;
        for (Map.Entry<Integer, Integer> entry : ranks.entrySet()) {
            totalWinningMoney += (Rank.valueOf(entry.getKey()).getWinningMoney() * entry.getValue());
        }
        return totalWinningMoney;
    }
}
