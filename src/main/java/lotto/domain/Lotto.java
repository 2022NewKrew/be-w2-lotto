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

    public void lottoBuy(Integer payment){
        Integer userMakeCount = LottoViewInput.lottoInputUserMakeCount();

        //validation check logic 후 오류안나게 개선을 할까? 아니면 그냥 exception을 던질까? 뭐가 좋을까요?
        userMakeCount = LottoValidationCheck.userMakeCountValidation(payment, userMakeCount);

        Integer autoMakecount = (payment / LOTTO_PRICE) - userMakeCount;

        if(userMakeCount > 0){
            addLottos(userMakeCount, Lotto::addUserMakeLottos);
        }

        if(autoMakecount > 0){
            addLottos(autoMakecount, Lotto::addRandomLottos);
        }
    }

    public void setLottoResult(LottoNumber lottoNumber, Integer bonusNumber) {
        lottoResult.setLottoNumber(lottoNumber);
        lottoResult.setBonusNumber(bonusNumber);

        LottoValidationCheck.bonusNumberCheck(lottoNumber, bonusNumber);
    }

    public void addLottos(Integer lottoCount, LottoCreate lottoCreate){
        for(int i = 0 ; i < lottoCount ; i++){
            lottos.add(lottoCreate.create(i == 0));
        }
    }

    static private LottoNumber addRandomLottos(boolean isPrinting){
        return LottoNumber.createRandomLotto(isPrinting); //랜덤으로 로또를 생성
    }

    static private LottoNumber addUserMakeLottos(boolean isPrinting){
        return LottoNumber.createUserMakeLotto(isPrinting); //사용자가 로또를 입력하여 생성
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
