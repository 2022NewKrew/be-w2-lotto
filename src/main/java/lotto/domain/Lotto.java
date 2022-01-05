package lotto.domain;

import lotto.view.LottoViewInput;
import lotto.view.LottoViewOutput;

import java.text.CollationElementIterator;
import java.util.*;

import static lotto.domain.LottoSetting.*;

public class Lotto {
    private LottoResult lottoResult;
    private List<LottoNumber> lottos;
    private Map<Rank, List<LottoNumber>> lottoWinner;
    private List<Integer> lottoElement;

    public Lotto(){
        lottos = new ArrayList<>();
    }

    //getter
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

    public void setLottoResult(LottoNumber lottoNumber, Integer bonusNumber) {
        lottoResult = new LottoResult();
        lottoResult.setLottoNumber(lottoNumber);
        lottoResult.setBonusNumber(bonusNumber);
    }

    public void addRandomLottos(Integer lottoCount){
        for(int i = 0 ; i < lottoCount ; i++){
            lottos.add(createRandomLotto()); //lottoCount만큼 랜덤으로 로또를 생성
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
        //initialize Hashmap to lottoWinner.
        initLottoWinner();

        //add win numbers to lottoWinner
        for(int i = 0 ; i < lottos.size() ; i++){
            LottoNumber curLotto = lottos.get(i);
            Rank lottoRank = Rank.getRankByCount(curLotto.calculateMatchCount(lottoResult.getLottoNumber()), curLotto.num.contains(lottoResult.getBonusNumber()));
            lottoWinner.get(lottoRank).add(curLotto);
        }
    }

    private void initLottoElement(){
        for(int i = 1 ; i <= LOTTO_NUMBER_RANGE ; i++){
            lottoElement.add(i);
        }
    }

    private LottoNumber createRandomLotto(){
        //initialize only once
        if(lottoElement == null){
            lottoElement = new ArrayList<>();
            initLottoElement();
        }

        Collections.shuffle(lottoElement);
        List<Integer> newLotto = lottoElement.subList(0, LOTTO_LENGTH);
        newLotto.sort(Integer::compareTo);
        return new LottoNumber( newLotto );
    }


}
