package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoPack {
    private static final List<Lotto> lottoList = new ArrayList<>();
    public LottoPack(){

    }
    public void add(Lotto lotto){
        lottoList.add(lotto);
    }


    public void printLottoPack() {
        lottoList.stream().forEach(e -> System.out.print(e+"\n"));
    }

    public RankingPack makeRankingPack(Lotto prize){
        return new RankingPack(lottoList.stream().map(lotto -> lotto.makeLottoRank(prize)).collect(Collectors.toList()));
    }


}
