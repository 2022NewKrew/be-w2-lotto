package com.cold.view;

import com.cold.models.SingleTicket;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static List<SingleTicket> inputManualLottoNumbers(String manualsInput) {
        List<SingleTicket> singleTickets = new ArrayList<>();
        if(manualsInput.isBlank()){
            return singleTickets;
        }

        for(String manualsInputInLine : manualsInput.split("\n")){
            List<Integer> oneLottoLine = parseNumberSet(manualsInputInLine);
            singleTickets.add(new SingleTicket(oneLottoLine));
        }
        return singleTickets;
    }

    public static List<Integer> inputWinningNumber(String winningNumberString) {
        return parseNumberSet(winningNumberString);
    }

    private static List<Integer> parseNumberSet(String numberSetString) {
        List<Integer> numberSet = new ArrayList<>();
        for (String num : numberSetString.split(",")) {
            numberSet.add(Integer.parseInt(num.trim()));
        }
        return numberSet;
    }

    public static int inputManualPurchaseCount(String manualLottosString) {
        return manualLottosString.isBlank() ? 0 : manualLottosString.split("\n").length;
    }
}
