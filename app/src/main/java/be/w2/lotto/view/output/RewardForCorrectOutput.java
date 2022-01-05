package be.w2.lotto.view.output;

import be.w2.lotto.exceptions.NonValidRewardForCorrect;
import be.w2.lotto.messages.ErrorMessage;
import be.w2.lotto.result.RewardForCorrect;

final class RewardForCorrectOutput extends ClassOutput<RewardForCorrect> {

    RewardForCorrectOutput() {
    }

    @Override
    String getOutput(RewardForCorrect rewardForCorrect) {
        return new StringBuilder()
                .append(getDescriptionOf(rewardForCorrect))
                .append("(")
                .append(rewardForCorrect.getReward())
                .append(")- ")
                .toString();
    }

    private String getDescriptionOf(RewardForCorrect rewardForCorrect) {
        switch (rewardForCorrect) {
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
                throw new NonValidRewardForCorrect(ErrorMessage.REWARD_FOR_CORRECT_NOT_FOUNDED);
        }
    }
}
