package lotto.request;

import lotto.domain.Lotto;
import lotto.vo.LottoVO;

import java.util.List;

public class ResultRequest {

    private List<LottoVO> lottos;

    private List<Integer> lastWeekLottoNumbers;

    private int bonusBall;

    public List<LottoVO> getLottos() {
        return lottos;
    }

    public void setLottos(List<LottoVO> lottos) {
        this.lottos = lottos;
    }

    public List<Integer> getLastWeekLottoNumbers() {
        return lastWeekLottoNumbers;
    }

    public void setLastWeekLottoNumbers(List<Integer> lastWeekLottoNumbers) {
        this.lastWeekLottoNumbers = lastWeekLottoNumbers;
    }

    public int getBonusBall() {
        return bonusBall;
    }

    public void setBonusBall(int bonusBall) {
        this.bonusBall = bonusBall;
    }
}
