package lotto.domain;

import input.Validator;
import lotto.LottoConfig;

import java.util.List;

public class WinningLotto extends Lotto{
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
        checkBonusNum();
    }

    @Override
    protected void checkLottoNum(List<Integer> numbers) {
        Validator.checkLottoNum(numbers);
    }

    private void checkBonusNum() {
        System.out.println(bonusNumber);
        Validator.numberValidity(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    /**
     * 로또 티켓과 비교해서 lottoTicket의 result에 값 세팅. WinningLotto 만 할 수 있게 하기 위해 LottoTicket의 setResult는 protected 입니다.
     */
    public void compareAndSetResult(LottoTicket ticket) {
        int count = (int) numbers.stream()
                                .filter(targetNum -> ticket.getNumbers().contains(targetNum)).count();
        ticket.setResult(LottoResult.getResult(count));
    }
}
