package presentation.view.output;

<<<<<<< HEAD
import dto.output.RewardResultDto;

public class ResultOutputView implements OutputView{
    private final RewardResultDto rewardResultDto;

    public ResultOutputView(RewardResultDto rewardResultDto) {
        this.rewardResultDto = rewardResultDto;
=======
import dto.output.ResultOutputDto;

public class ResultOutputView implements OutputView{
    private final ResultOutputDto resultOutputDto;

    public ResultOutputView(ResultOutputDto resultOutputDto) {
        this.resultOutputDto = resultOutputDto;
>>>>>>> a030324 (refactor : 구조개선)
    }

    @Override
    public void print() {
<<<<<<< HEAD
        System.out.println(this.rewardResultDto);
=======
        System.out.println(this.resultOutputDto);
>>>>>>> a030324 (refactor : 구조개선)
    }
}
