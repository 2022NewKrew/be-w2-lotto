package lotto.io;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WebInputManager implements InputManager<String> {
    @Override
    public int getPurchaseAmount(String string) {
        int purchaseAmount = Integer.parseInt(string);
        ExceptionCheck.checkValidPurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }

    @Override
    public int getManualLottoCount(String string, int totalNumOfPurchase) {
        int manualLottoCount = Integer.parseInt(string);
        ExceptionCheck.checkValidManualLottoCount(manualLottoCount, totalNumOfPurchase);
        return manualLottoCount;
    }

    @Override
    public List<Lotto> getManualLotto(String string, int manualLottoCount) {
        if (string.length() <= 0) {
            return Collections.unmodifiableList(new ArrayList<>());
        }

        List<Lotto> manualLottoList = Arrays.stream(string.split("\r?\n"))
                .map(number ->
                        Arrays.stream(number.replace(" ", "").split(","))
                                .map(Integer::parseInt)
                                .sorted()
                                .collect(Collectors.toList())
                ).map(LottoGenerator::generateManualLotto)
                .collect(Collectors.toList());
        ExceptionCheck.checkValidManualLotto(manualLottoList, manualLottoCount);
        manualLottoList.forEach(lotto -> ExceptionCheck.checkValidNumberList(lotto.getNumbers()));
        return Collections.unmodifiableList(manualLottoList);
    }

    @Override
    public List<Integer> getWinningNumber(String string) {
        List<Integer> winningNumber = Parser.stringTotWinningNumber(string);
        ExceptionCheck.checkValidNumberList(winningNumber);
        return winningNumber;
    }

    @Override
    public int getBonusNumber(String string, List<Integer> winningNumber) {
        int bonusNumber = Integer.parseInt(string);
        ExceptionCheck.checkValidBonusNumber(bonusNumber);
        ExceptionCheck.checkBonusNumberInWinningNumber(bonusNumber, winningNumber);
        return bonusNumber;
    }
}
