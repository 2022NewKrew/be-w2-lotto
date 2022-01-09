package domain;

import domain.Generator.AutoLottoGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoBundle {
    private final List<Lotto> lottoList;

    public LottoBundle(List<Lotto> lottoList) {
        this.lottoList = Collections.unmodifiableList(lottoList);
    }

    public LottoBundle(int autoCount) {
        List<Lotto> lottoListTemp = new ArrayList<>();
        AutoLottoGenerator autoLottoGenerator = new AutoLottoGenerator();
        for (int i = 0; i < autoCount; i++) {
            lottoListTemp.add(autoLottoGenerator.generateLotto());
        }
        lottoList = Collections.unmodifiableList(lottoListTemp);
    }

    public int getCount() {
        return lottoList.size();
    }

    public LottoBundle concat(LottoBundle other) {
        return new LottoBundle(Stream.concat(this.lottoList.stream(), other.lottoList.stream()).collect(Collectors.toList()));
    }

    public String printBundle() {
        StringBuilder stringBuilder = new StringBuilder();
        lottoList.forEach(e ->
                stringBuilder.append(e).append("\n")
        );
        return stringBuilder.toString();
    }

    public List<Ranking> makeRankingPack(Lotto winningLottoTicket, int bonus) {
        return lottoList.stream().map(lotto -> Match.makeLottoRank(lotto, winningLottoTicket, bonus)).collect(Collectors.toList());
    }
}
