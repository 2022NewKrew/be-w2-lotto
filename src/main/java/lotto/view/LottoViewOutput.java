package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class LottoViewOutput {
    Lotto lottoObject;
    public LottoViewOutput(Lotto lottoObject){
        this.lottoObject = lottoObject;
    }

    public void printLottoCount(){
        System.out.println(lottoObject.getLottos().size() + "개를 구매했습니다.");
    }

    private void printLotto(LottoNumber singleLotto){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0 ; i < singleLotto.num.size() ; i++){
            sb.append( singleLotto.num.get(i) + (i + 1 < singleLotto.num.size() ? ", " : "")  );
        }
        sb.append("]");
        System.out.println(sb);
    }

    public void printAllLottos(){
        for(int i = 0 ; i < lottoObject.getLottos().size() ; i++){
            printLotto(lottoObject.getLottos().get(i));
        }
    }
}
