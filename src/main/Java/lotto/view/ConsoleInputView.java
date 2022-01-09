package lotto.view;

import lotto.exception.IllegalManualLottoInputException;
import lotto.exception.IllegalPurchaseMoneyException;

import java.util.*;

public class ConsoleInputView{
    private static final Scanner sc = new Scanner(System.in);

    public static int getLottoPurchaseMoney (int lottoPrice){
        System.out.println("구입금액을 입력해 주세요.");
        int purchasePrice = sc.nextInt();

        if(purchasePrice%lottoPrice!=0)
            throw new IllegalPurchaseMoneyException(lottoPrice+"의 배수로 입력하지 않았습니다.");
        if(purchasePrice<=0)
            throw new IllegalPurchaseMoneyException("0 이하의 값을 입력했습니다.");

        return purchasePrice;
    }

    public static String getLastWeekLottoNumbers() {
        System.out.println("지난 주 당첨 로또 번호를 입력해주세요.");
        return sc.next();
    }

    public static long getManualCount() throws IllegalManualLottoInputException{
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        String manualCountInput = sc.next();
        long manualCount=0;
        try{
            manualCount = Long.parseLong(manualCountInput.strip());
        }
        catch (NumberFormatException e){
            throw new IllegalManualLottoInputException();
        }
        return manualCount;
    }

    public static String getBonusBall() {
        System.out.println("보너스볼을 입력해주세요.");
        return sc.next();
    }

    public static String getManualLottoNumbers(long manualLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < manualLottoCount; i++) {
             stringBuilder.append(sc.next() + System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}

