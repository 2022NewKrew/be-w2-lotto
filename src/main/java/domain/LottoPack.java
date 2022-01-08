package domain;

import domain.Generator.AutoLottoGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoPack {
    private static final List<Lotto> lottoList = new ArrayList<>();
    private static final int LottoPrice = 1000;

    public int getBuyPrice() {
        return buyPrice;
    }

    private final int buyPrice;

    public LottoPack(int buyPrice) {
        this.buyPrice = buyPrice;
        makeLottoList();
    }

    public void makeLottoList() {
        int numberOfLotto = buyPrice / LottoPrice;
        AutoLottoGenerator autoLottoGenerator = new AutoLottoGenerator();
        for (int i = 0; i < numberOfLotto; i++) {
            lottoList.add(autoLottoGenerator.generateLotto());
        }
        Collections.unmodifiableList(lottoList);
    }


    public String printLottoPack() {
        StringBuilder stringBuilder = new StringBuilder();
        lottoList.forEach(e ->
                stringBuilder.append(e + "\n")
        );
        return stringBuilder.toString();
    }

    public RankingPack makeRankingPack(Lotto prize,int bonus) {
        return new RankingPack(lottoList.stream().map(lotto -> Match.makeLottoRank(lotto, prize, bonus)).collect(Collectors.toList()));
    }


}
