package view.input;

import dto.LastWeekWinningNumberDTO;

import java.util.List;

public interface InputView {
    Long inputPrice();

    LastWeekWinningNumberDTO inputWinningNumbers();

}
