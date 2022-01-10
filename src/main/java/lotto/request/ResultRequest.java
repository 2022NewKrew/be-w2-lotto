package lotto.request;

import lotto.domain.Lotto;
import lotto.vo.LottoVO;

import java.util.List;

public class ResultRequest {

    private List<LottoVO> lottos;

    private List<Integer> lastWeekLottoNumbers;

    private int bonusBall;

    public ResultRequest(List<LottoVO> lottos, List<Integer> lastWeekLottoNumbers, int bonusBall) {
        this.lottos = lottos;
        this.lastWeekLottoNumbers = lastWeekLottoNumbers;
        this.bonusBall = bonusBall;
    }

    public List<LottoVO> getLottos() {
        return lottos;
    }


    public List<Integer> getLastWeekLottoNumbers() {
        return lastWeekLottoNumbers;
    }


    public int getBonusBall() {
        return bonusBall;
    }

    public void setBonusBall(int bonusBall) {
        this.bonusBall = bonusBall;
    }
}
