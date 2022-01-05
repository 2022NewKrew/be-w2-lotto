package lottery.web.dto;

import java.util.ArrayList;

public class LotteryWinningNumberWithBonusDto extends LotteryWinningNumberDto{

    private int bonusNumber;

    public int getBonusNumber() {
        return bonusNumber;
    }

    public LotteryWinningNumberWithBonusDto(ArrayList<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }
}
