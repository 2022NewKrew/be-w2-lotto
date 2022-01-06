package view.console.input;

import dto.LastWeekWinningNumber;

public interface InputView {
    Long inputPrice();

    LastWeekWinningNumber inputWinningNumbers();
}
