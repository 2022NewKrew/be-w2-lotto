package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoPack {
    private static final List<Lotto> lottoList = new ArrayList<>();

    public int getBuyPrice() {
        return buyPrice;
    }

    private final int buyPrice;

    public LottoPack(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    public void add(Lotto lotto) {
        lottoList.add(lotto);
    }


    public void printLottoPack() {
        lottoList.forEach(e -> System.out.print(e + "\n"));
    }

    public RankingPack makeRankingPack(Lotto prize,int bonus) {
        return new RankingPack(lottoList.stream().map(lotto -> Match.makeLottoRank(lotto, prize, bonus)).collect(Collectors.toList()));
    }


}
