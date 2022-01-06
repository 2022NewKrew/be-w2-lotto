package be.w2.lotto.view.output;

import be.w2.lotto.exceptions.NonValidWinningsException;
import be.w2.lotto.messages.ErrorMessage;
import be.w2.lotto.result.Winnings;

final class WinningsOutput implements ClassOutput<Winnings> {

    WinningsOutput() {
    }

    @Override
    public String getOutput(Winnings winnings) {
        return new StringBuilder()
                .append(getDescriptionOf(winnings))
                .append("(")
                .append(winnings.getReward())
                .append(")- ")
                .toString();
    }

    private String getDescriptionOf(Winnings winnings) {
        switch (winnings) {
            case THREE:
                return "3개 일치";
            case FOUR:
                return "4개 일치";
            case FIVE:
                return "5개 일치";
            case FIVE_AND_BONUS:
                return "5개 일치, 보너스 볼 일치";
            case SIX:
                return "6개 일치";
            default:
                throw new NonValidWinningsException(ErrorMessage.REWARD_FOR_CORRECT_NOT_FOUNDED);
        }
    }
}
