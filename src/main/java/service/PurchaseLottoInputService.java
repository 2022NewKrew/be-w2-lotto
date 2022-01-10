package service;

import constant.LottoConstants;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class PurchaseLottoInputService {
    public int getMoney() {
        printLabel(String.format("구입금액을 입력해 주세요."));
        int money = InputView.getMoney();
        if (money < 0) {
            throw new IllegalArgumentException("0원 이상의 값만 입력할 수 있습니다.");
        }
        return money;
    }

    public int getManualAmount(int money) {
        printLabel(String.format("\n수동으로 구매할 로또 수를 입력해 주세요."));
        int manualAmount = InputView.getManualAmount();
        int availableAmount = money / LottoConstants.LOTTO_PRICE;
        if (manualAmount > availableAmount) {
            throw new IllegalArgumentException("현재 살 수 있는 로또 개수를 넘었습니다. (최대: " + availableAmount + "개)");
        }
        if (manualAmount < 0) {
            throw new IllegalArgumentException("0개 이상의 값만 입력할 수 있습니다.");
        }
        return manualAmount;
    }

    public List<String> getManualLottoStringList(int manualAmount) throws IllegalArgumentException {
        printLabel(String.format("\n수동으로 구매할 번호를 입력해 주세요."));
        List<String> manualLottoStringList = new ArrayList<>();
        for (int i = 0 ; i < manualAmount ; i++) {
            int retry = 0;
            while (retry++ < LottoConstants.MAX_RETRIES) {
                try {
                    String manualLottoString = getManualLottoString();
                    System.out.println(manualLottoString);
                    manualLottoStringList.add(manualLottoString);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage() + " (현재 시도 횟수: " + retry + "/"+ LottoConstants.MAX_RETRIES + "회)" );
                }
            }
            throw new IllegalArgumentException("ManualLottoString 값 입력 최대 시도 횟수를 초과하였습니다.");
        }
        return manualLottoStringList;
    }

    private String getManualLottoString() {
        String manualLottoString = InputView.getManualLottoString();
        List<String> manualLottoNumbersString = Arrays.asList(manualLottoString.split(","));
        if (!hasSixNumber(manualLottoNumbersString)) {
            throw new IllegalArgumentException("6개의 숫자가 들어오지 않았습니다. 6개의 숫자를 콤마(,)로 구분하여 입력해 주세요.");
        }
        if (!allElementIsNumber(manualLottoNumbersString)) {
            throw new IllegalArgumentException("숫자가 아닌 입력값이 있습니다. 6개의 숫자를 콤마(,)로 구분하여 입력해 주세요.");
        }
        return manualLottoString;
    }

    private boolean hasSixNumber(List<String> manualLottoNumbersString) {
        if (manualLottoNumbersString.size() == 6) {
            return true;
        }
        return false;
    }

    private boolean allElementIsNumber(List<String> manualLottoNumbersString) {
        for (String manualLottoNumberString : manualLottoNumbersString) {
            if (!isInteger(manualLottoNumberString)) return false;
        }
        return true;
    }

    private boolean isInteger(String NumberString) {
        for (char digit : NumberString.toCharArray()) {
            if (!Character.isDigit(digit)) return false;
        }
        return true;
    }

    private void printLabel(String label) {
        OutputView.printLabel(label);
    }
}
