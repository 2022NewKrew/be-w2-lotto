package lotto.view;

import lotto.collections.AnsLottoLine;
import lotto.collections.LottoLine;
import lotto.collections.LottoNumber;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Reader {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String qPrice = "구입 금액을 입력해주세요.";
    private static final String qPrevNums = "지난 주 당첨 번호을 입력해주세요. -- 띄어쓰기로 구별 ex) 1 2 3 4 5 6";
    private static final String qBonusNum = "보너스 볼을 입력해 주세요.";

    public static int start(){
        int amount = enterPurchaseAmount();
        int cnt = Printer.printAndGetAmount(amount);
        return cnt;
    }

    public static AnsLottoLine enterMatchNums(){
        LottoLine prevNums = enterPrevNums();
        LottoNumber bonusNum = enterBonusNum();
        return new AnsLottoLine(prevNums, bonusNum);
    }

    private static int enterPurchaseAmount(){
        System.out.println(qPrice);
        return scanner.nextInt();
    }

    private static LottoNumber enterBonusNum(){
        System.out.println(qBonusNum);
        int num = scanner.nextInt();
        return new LottoNumber(num);
    }

    public static LottoLine enterPrevNums(){
        System.out.println(qPrevNums);
        Set<LottoNumber> temp = new HashSet<>();

        while (temp.size()<6 && scanner.hasNextInt()){
            temp.add(new LottoNumber(scanner.nextInt()));
        }

        return new LottoLine(temp);
    }
}
