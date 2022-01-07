package lotto.domain;

import java.util.List;

/**
 * Input.java 의 클래스들을 받아와 패키지 밖에서 활용할 수 있게 하는 클래스
 */
public class LottoInput {
    private final LottoPaper lp;


    public LottoInput(LottoPaper lp) { this.lp = lp; }


    /**
     * 구입금액을 받아와 로또 종이에 구입금액, 로또 줄의 갯수 입력하는 메소드
     */
    public void prePurchase(){
        PriceInput pi = new PriceInput();
        pi.init();
        lp.inputPrice = pi.getInput();
        lp.numOfNumbers = pi.getNumOfNumbers();
    }

    public void prePurchase(String inputMoney){
        PriceInput pi = new PriceInput(Integer.parseInt(inputMoney));
        lp.inputPrice = pi.getInput();
        lp.numOfNumbers = pi.getNumOfNumbers();
    }

    /**
     * 수동으로 입력할 로또 줄의 갯수를 받아오는 메소드
     * @return 수동으로 입력할 로또 줄의 갯수
     */
    public int manualPurchase(){
        ManualInput mi = new ManualInput(lp.numOfNumbers);
        mi.init();
        return mi.getInput();
    }

    /**
     * 수동으로 입력한 로또 번호 줄의 리스트를 가져오는 메소드
     * @param numOfManual 수동으로 입력할 로또 줄의 갯수
     * @return 입력받은 로또 번호 줄 List<LottoNumber>
     */
    public static List<LottoNumbers> getManualNumbers(int numOfManual){
        ManualNumberInput mni = new ManualNumberInput(numOfManual);
        mni.convertToList();
        return mni.getInput();
    }

    public List<LottoNumbers> getManualNumbers(String manualNumbers){
        ManualNumberInput mni = new ManualNumberInput(manualNumbers, lp.numOfNumbers);
        return mni.getInput();
    }

    /**
     * 구매 후, 지난 당첨 결과를 받아오는 메소드
     * @return 지난 당첨 번호들
     */
    public static List<Integer> postPurchase(){
        WinningInput wi = new WinningInput();
        return wi.getInput();
    }
    public static List<Integer> postPurchase(String winningNumber){
        WinningInput wi = new WinningInput(winningNumber);
        return wi.getInput();
    }

    /**
     * 보너스 볼 숫자를 받아오는 메소드
     * @return 보너스 볼 숫자
     */
    public static int getBonusNumber(){
        BonusNumberInput bni = new BonusNumberInput();
        bni.init();
        return bni.getInput();
    }
    public static int getBonusNumber(String bonusNumber){
        BonusNumberInput bni = new BonusNumberInput(Integer.parseInt(bonusNumber));
        return bni.getInput();
    }

    public LottoPaper getLottoPaper() { return lp; }
}
