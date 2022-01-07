package step4.service.domain;

import step4.util.Validator;

import java.util.List;

public class WinningLotto extends Lotto {
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
        checkBonusNum();
    }

    private void checkBonusNum() {
        Validator.checkBonus(bonusNumber, numbers);
    }

    /**
     * 로또 티켓과 비교해서 lottoTicket의 result에 값 세팅. WinningLotto 만 할 수 있게 하기 위해 LottoTicket의 setResult는 protected 입니다.
     */
    public void compareAndSetResult(LottoTicket ticket) {
        int score = (int) numbers.stream()
                .filter(targetNum -> ticket.getNumbers().contains(targetNum)).count();

        if (score == 6) score++;
        if (score == 5 && isSecondPlace(ticket)) score++;
        ticket.setResult(LottoResult.getResult(score));
    }

    private boolean isSecondPlace(LottoTicket lottoTicket) {
        return lottoTicket.getNumbers().contains(bonusNumber);
    }
}
