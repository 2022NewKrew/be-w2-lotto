package service;

import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class WinningLottoInputService {
    public String getWinningLottoString() {
        printLabel(String.format("\n지난 주 당첨 번호를 입력해 주세요."));
        return InputView.getWinningLottoString();
    }

    public int getBonusNumber() {
        printLabel(String.format("보너스 볼을 입력해 주세요."));
        return InputView.getBonusNumber();
    }

    private void printLabel(String label) {
        OutputView.printLabel(label);
    }


}
