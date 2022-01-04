package presentation.view.output;

import dto.output.ResultOutputDto;

public class ResultOutputView implements OutputView{
    private final ResultOutputDto resultOutputDto;

    public ResultOutputView(ResultOutputDto resultOutputDto) {
        this.resultOutputDto = resultOutputDto;
    }

    @Override
    public void print() {
        System.out.println(this.resultOutputDto);
    }
}
