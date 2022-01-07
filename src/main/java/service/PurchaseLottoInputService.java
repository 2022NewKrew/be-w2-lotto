package service;

import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class PurchaseLottoInputService {
    public int getMoney() {
        printLabel(String.format("구입금액을 입력해 주세요."));
        return InputView.getMoney();
    }

    public int getManualAmount() {
        printLabel(String.format("\n수동으로 구매할 로또 수를 입력해 주세요."));
        return InputView.getManualAmount();
    }

    public List<String> getManualLottoStringList(int manualAmount) {
        printLabel(String.format("\n수동으로 구매할 번호를 입력해 주세요."));
        List<String> manualLottoStringList = new ArrayList<>();
        for (int i = 0 ; i < manualAmount ; i++) {
            manualLottoStringList.add(InputView.getManualLottoString());
        }
        return manualLottoStringList;
    }

    private void printLabel(String label) {
        OutputView.printLabel(label);
    }
}
