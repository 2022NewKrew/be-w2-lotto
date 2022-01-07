package lotto.domain;

import java.util.List;

/**
 *  로또 당첨 번호 정보를 담고있는 클래스입니다.
 *  Lotto를 상속받아 bonusBall 필드를 추가했습니다.
 */
public class LottoWinningNumber extends Lotto {
    private final LottoNumber bonusBall;

    public LottoWinningNumber(List<LottoNumber> lottoNumbers, LottoNumber bonusBall) {
        super(lottoNumbers);
        checkBonusBallNotNull(bonusBall);
        checkBonusBallDuplicate(bonusBall);
        this.bonusBall = bonusBall;
    }

    /**
     *  lotto가 당첨 번호와 몇 개 숫자만큼 일치하는지 확인해서 반환
     *
     * @param lotto : 당첨여부 확인하고 싶은 로또 정보
     * @return LottoPrize : 당첨 등수 반환
     */
    public final LottoPrize match(Lotto lotto) {
        int count = 0;
        boolean bonus = false;

        for (LottoNumber number : lottoNumbers)
            count += lotto.contains(number) ? 1 : 0;

        if (lotto.contains(bonusBall))
            bonus = true;

        return LottoPrize.from(count, bonus);
    }

    private void checkBonusBallNotNull(LottoNumber bonusBall) {
        if (bonusBall == null)
            throw new IllegalArgumentException();
    }

    private void checkBonusBallDuplicate(LottoNumber bonusBall) {
        if (super.lottoNumbers.contains(bonusBall))
            throw new IllegalArgumentException("Duplicate bonusBall number");
    }
}
