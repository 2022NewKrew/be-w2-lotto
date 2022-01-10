package domain.lottery;

import static utils.ErrorMessage.INVALID_BONUS_NUMBER_DUPLICATION;
import static utils.ErrorMessage.NULL_PARAMETER;
import static utils.ErrorMessage.format;

import domain.lotto.Lotto;
import domain.lotto.LottoNumber;
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

  private final LottoNumber bonusNumber;

  private WinningLotto(List<LottoNumber> winningLottoNumbers, LottoNumber bonusNumber) {
    super(winningLottoNumbers);
    this.bonusNumber = Objects.requireNonNull(bonusNumber,
        format(NULL_PARAMETER, bonusNumber));
    if (hasNumber(bonusNumber)) {
      throw new IllegalArgumentException(
          format(INVALID_BONUS_NUMBER_DUPLICATION, bonusNumber, winningLottoNumbers));
    }
  }


  public static WinningLotto of(List<LottoNumber> winningLottoNumbers, LottoNumber bonusNumber) {
    return new WinningLotto(winningLottoNumbers, bonusNumber);
  }


  public LottoNumber getBonusNumber() {
    return bonusNumber;
  }

}
