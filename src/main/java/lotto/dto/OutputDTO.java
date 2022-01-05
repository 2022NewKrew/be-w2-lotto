package lotto.dto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

import static lotto.domain.LottoSetting.LOTTO_PRICE;

public class OutputDTO {
    final private List<LottoNumber> lottos;
    final private LottoResult lottoResult;
    final private Map<Rank, List<LottoNumber>> lottoWinner;

    public OutputDTO(List<LottoNumber> lottos, LottoResult lottoResult, Map<Rank, List<LottoNumber>> lottoWinner){
        this.lottos = lottos;
        this.lottoResult = lottoResult;
        this.lottoWinner = lottoWinner;
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }

    public List<LottoNumber> getLottos() {
        return lottos;
    }

    public Map<Rank, List<LottoNumber>> getLottoWinner() {
        return lottoWinner;
    }


    public Long getPayment(){
        return Long.valueOf(lottos.size() * LOTTO_PRICE) ;
    }

    public Long getEarning(){
        Long totalEarning = Long.valueOf(0);

        for(Rank rank : List.of(Rank.values())){
            totalEarning += rank.getWinningMoney() * lottoWinner.get(rank).size();
        }

        return totalEarning;
    }
}
