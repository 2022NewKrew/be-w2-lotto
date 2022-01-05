package lotto.domain;

import java.util.List;

public class LottoInput {
    private final LottoPaper lp;


    public LottoInput(LottoPaper lp) { this.lp = lp; }


    public void prePurchase(){
        PriceInput pi = new PriceInput();
        lp.inputPrice = pi.getInput();
        lp.numOfNumbers = pi.getNumOfNumbers();
    }

    public static int manualPurchase(){
        ManualInput mi = new ManualInput();
        return mi.getInput();
    }

    public static List<LottoNumber> getManualNumbers(int numOfManual){
        ManualNumberInput mni = new ManualNumberInput(numOfManual);
        mni.convertToList();
        return mni.getInput();
    }

    public static List<Integer> postPurchase(){
        WinningInput wi = new WinningInput();
        return wi.getInput();
    }

    public static int getBonusNumber(){
        BonusNumberInput bni = new BonusNumberInput();
        return bni.getInput();
    }

    public LottoPaper getLottoPaper() { return lp; }
}
