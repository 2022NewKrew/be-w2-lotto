package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.userinput.PurchasedInfoDto;
import lotto.domain.userinput.WinningLottoDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoWebInput {
    public PurchasedInfoDto convertToPurchasedInfoDto(String inputMoneyStr, String manualNumberStr){
        int inputMoney = convertToInt(inputMoneyStr);
        List<Lotto> manualLottoBundle = convertToManualLotto(manualNumberStr);
        return new PurchasedInfoDto(inputMoney, manualLottoBundle.size(), manualLottoBundle);
    }

    public WinningLottoDto convertToWinningLottoDto(String winningNumberStr, String bonusNumberStr){
        Lotto winningNumber = convertToLotto(winningNumberStr);
        int bonusNumber = convertToInt(bonusNumberStr);
        return new WinningLottoDto(winningNumber, bonusNumber);
    }

    private List<Lotto> convertToManualLotto(String manualNumberStr){
        return Stream.of(manualNumberStr.split("\r?\n"))
                .map(this::convertToLotto)
                .collect(Collectors.toList());
    }

    private int convertToInt(String str){
        return Integer.parseInt(str);
    }

    private Lotto convertToLotto(String numberStr){
        return new Lotto(Arrays.stream(numberStr.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }
}
