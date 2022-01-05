package domain.lottery;

import domain.lotto.Lotto;
import java.util.List;

/**
 * LotteryMachine 에 의해서 당첨된 로또,
 * 당청 로또 번호와 보너스 넘버로 이루어 져있다.
 * --> 내부에 Lotto 객체를 따로 가지는 것 보다는 Lotto 클래스를 상속해서 구현.
 * --> WinningLotto = Lotto + bonusNumber
 *
 * @author leo.jung
 * @since 1.1
 */
public class WinningLotto extends Lotto {

  private final Integer bonusNumber;

  private WinningLotto(List<Integer> winningLottoNumbers, Integer bonusNumber) {
    super(winningLottoNumbers);
    this.bonusNumber = bonusNumber;
  }


  public static WinningLotto of(List<Integer> winningLottoNumbers, Integer bonusNumber) {
    return new WinningLotto(winningLottoNumbers, bonusNumber);
  }


  public Integer getBonusNumber() {
    return bonusNumber;
  }

}
