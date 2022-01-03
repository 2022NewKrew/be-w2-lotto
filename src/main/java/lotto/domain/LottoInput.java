package lotto.domain;

import java.util.List;

public class LottoInput {
    private static int inputPrice;

    public static int prePurchase(){
        PriceInput pi = new PriceInput();
        inputPrice = pi.getInput();
        return pi.getNumOfPaper();
    }

    public static List<Integer> postPurchase(){
        WinningInput wi = new WinningInput();
        System.out.println();
        return wi.getInput();
    }

    public static int getInputPrice(){
        return inputPrice;
    }
}
