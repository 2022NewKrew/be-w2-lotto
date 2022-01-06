package lotto.step2.dto.request;

import lotto.step1.dto.request.ConfirmTheWinDTO;

import java.util.List;

public class ConfirmTheWinAddBonusBallDTO extends ConfirmTheWinDTO {
    private final int bonusBall;

    public ConfirmTheWinAddBonusBallDTO(List<Integer> lastWeekWinningNumbers, int bonusBall) {
        super(lastWeekWinningNumbers);
        this.bonusBall = bonusBall;
    }

    public int getBonusBall() {
        return bonusBall;
    }
}
