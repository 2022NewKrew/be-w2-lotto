package presentation.view;

import dto.ResultDto;

public class LottoResultOutputView implements OutputView{
    private final ResultDto resultDto;

    public LottoResultOutputView(ResultDto resultDto) {
        this.resultDto = resultDto;
    }

    @Override
    public void print() {
        System.out.println(this.resultDto);
    }
}
