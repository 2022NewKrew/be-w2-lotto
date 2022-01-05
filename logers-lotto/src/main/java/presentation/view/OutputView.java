package presentation.view;

import dto.ResultDto;

public class OutputView {
    private ResultDto resultDto;

    public OutputView(ResultDto resultDto) {
        this.resultDto = resultDto;
    }

    public void showResult() {
        System.out.println(this.resultDto);
    }
}
