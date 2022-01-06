package lotto.domain;

public class WinningNumbers {
    private final LottoNumbers winningNumbers;
    private final LottoNumber bonusNumber;

    private WinningNumbers(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 볼은 당첨 번호와 중복될 수 없습니다.");
        }
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers from(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        return new WinningNumbers(winningNumbers, bonusNumber);
    }


    public LottoResult result(LottoTicket ticket) {
        int matchCount = getMatchCount(ticket);
        boolean matchBonus = isMatchedBonus(ticket);
        return LottoResult.valueOf(matchCount, matchBonus);
    }

    private int getMatchCount(LottoTicket ticket) {
        int matchCount = 0;

        for (LottoNumber number : winningNumbers.getLottoNumbers()) {
            matchCount += ticket.contains(number) ? 1 : 0;
        }

        return matchCount;
    }

    private boolean isMatchedBonus(LottoTicket ticket) {
        return ticket.contains(bonusNumber);
    }
}
