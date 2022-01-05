package lotto.domain;

import lotto.dto.OutputDTO;
import lotto.view.LottoViewInput;
import lotto.view.LottoViewOutput;

import java.text.CollationElementIterator;
import java.util.*;

import static lotto.domain.LottoSetting.*;

public class Lotto {
    private LottoResult lottoResult;
    private List<LottoNumber> lottos;
    private Map<Rank, List<LottoNumber>> lottoWinner;

    public Lotto(){
        lottos = new ArrayList<>();
        lottoResult = new LottoResult();

        //initialize Hashmap to lottoWinner.
        initLottoWinner();
    }

    //getter
    public List<LottoNumber> getLottos() {
        return lottos;
    }

    public Map<Rank, List<LottoNumber>> getLottoWinner() {
        return lottoWinner;
    }

    public void setLottoResult(LottoNumber lottoNumber, Integer bonusNumber) {
        lottoResult.setLottoNumber(lottoNumber);
        lottoResult.setBonusNumber(bonusNumber);
    }

    public void addRandomLottos(Integer lottoCount){
        for(int i = 0 ; i < lottoCount ; i++){
            lottos.add(LottoNumber.createRandomLotto()); //lottoCount만큼 랜덤으로 로또를 생성
        }
    }



    private void initLottoWinner(){
        //init lottoWinner Objects
        lottoWinner = new HashMap<>();
        for(Rank rank : List.of(Rank.values())){
            lottoWinner.put(rank, new ArrayList<LottoNumber>());
        }
    }

    public void makeTotal(){

        //add win numbers to lottoWinner
        for(int i = 0 ; i < lottos.size() ; i++){
            LottoNumber curLotto = lottos.get(i);
            Rank lottoRank = Rank.getRankByCount(curLotto.calculateMatchCount(lottoResult.getLottoNumber()), curLotto.num.contains(lottoResult.getBonusNumber()));
            lottoWinner.get(lottoRank).add(curLotto);
        }
    }

    public OutputDTO getOutputDTO(){
       return new OutputDTO(lottos, lottoResult, lottoWinner);
    }

}
