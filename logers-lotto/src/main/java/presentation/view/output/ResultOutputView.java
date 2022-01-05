package presentation.view.output;


import dto.output.RewardResultDto;

public class ResultOutputView implements OutputView{
    private final RewardResultDto rewardResultDto;

    public ResultOutputView(RewardResultDto rewardResultDto) {
        this.rewardResultDto = rewardResultDto;
    }

    @Override
    public void print() {
        System.out.println(this.rewardResultDto);
    }
}
