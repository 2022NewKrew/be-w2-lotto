package domain.lottery;

import domain.lotto.Lotto;
import java.util.List;
import java.util.Objects;

/**
 * LotteryMachine 에 의해서 당첨된 로또, 당청 로또 번호와 보너스 넘버로 이루어 져있다. --> 내부에 Lotto 객체를 따로 가지는 것 보다는 Lotto 클래스를
 * 상속해서 구현. --> WinningLotto = Lotto + bonusNumber
 *
 * @author leo.jung
 * @since 1.1
 */
public class WinningLotto extends Lotto {

  private final BonusNumber bonusNumber;

  private WinningLotto(List<Integer> winningLottoNumbers, BonusNumber bonusNumber) {
    super(winningLottoNumbers);
    this.bonusNumber = Objects.requireNonNull(bonusNumber, "bonusNumber 값이 null 입니다.");
    if (isBonusMatched(bonusNumber)) {
      throw new IllegalArgumentException(
          "bonusNumber 값은 로또 값과 중복될 수 없습니다."
              + "[bonusNumber : " + bonusNumber
              + " / 로또 번호" + winningLottoNumbers + "]"
      );
    }
  }


  public static WinningLotto of(List<Integer> winningLottoNumbers, BonusNumber bonusNumber) {
    return new WinningLotto(winningLottoNumbers, bonusNumber);
  }


  public BonusNumber getBonusNumber() {
    return bonusNumber;
  }

}
