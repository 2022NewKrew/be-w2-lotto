package domain;

import domain.Generator.AutoLottoGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoPack {
    private final List<Lotto> lottoList;
    private static final int LottoPrice = 1000;

    public int getBuyPrice() {
        return buyPrice;
    }

    private final int buyPrice;

    public LottoPack(int buyPrice) {
        this.buyPrice = buyPrice;
        List<Lotto> lottoListTemp = new ArrayList<>();
        int numberOfLotto = buyPrice / LottoPrice;
        AutoLottoGenerator autoLottoGenerator = new AutoLottoGenerator();
        for (int i = 0; i < numberOfLotto; i++) {
            lottoListTemp.add(autoLottoGenerator.generateLotto());
        }
        lottoList = Collections.unmodifiableList(lottoListTemp);
    }


    public String printLottoPack() {
        StringBuilder stringBuilder = new StringBuilder();
        lottoList.forEach(e ->
                stringBuilder.append(e).append("\n")
        );
        return stringBuilder.toString();
    }

    public RankingPack makeRankingPack(Lotto winningLottoTicket,int bonus) {
        return new RankingPack(lottoList.stream().map(lotto -> Match.makeLottoRank(lotto, winningLottoTicket, bonus)).collect(Collectors.toList()));
    }


}
