package lotto.view;

import lotto.collections.AnsLottoLine;
import lotto.collections.LottoLine;
import lotto.collections.LottoNumber;
import lotto.dto.InputLottoConfig;

import java.util.*;

public class Reader {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String qPrice = "구입 금액을 입력해주세요.";
    private static final String qPrevNums = "지난 주 당첨 번호을 입력해주세요. -- 띄어쓰기로 구별 ex) 1 2 3 4 5 6";
    private static final String qBonusNum = "보너스 볼을 입력해 주세요.";
    private static final String qManualNumCnt = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String qManualNums = "수동으로 구매할 번호를 입력해 주세요.";


    public static InputLottoConfig enterManualInfo(int totalCnt){
        int manualCnt = enterManualLottoCnt();
        List<LottoLine> lottoLines = enterManualNums(manualCnt);
        return new InputLottoConfig(manualCnt, totalCnt, lottoLines);
    }

    public static AnsLottoLine enterMatchNums(){
        LottoLine prevNums = enterPrevNums();
        LottoNumber bonusNum = enterBonusNum();
        return new AnsLottoLine(prevNums, bonusNum);
    }

    public static int enterPurchaseAmount(){
        System.out.println(qPrice);
        return scanner.nextInt();
    }

    private static LottoNumber enterBonusNum(){
        System.out.println(qBonusNum);
        int num = scanner.nextInt();
        return new LottoNumber(num);
    }

    private static LottoLine enterLottoLine(){
        Set<LottoNumber> temp = new HashSet<>();

        while (temp.size()<6 && scanner.hasNextInt()){
            temp.add(new LottoNumber(scanner.nextInt()));
        }

        return new LottoLine(temp);

    }

    public static LottoLine enterPrevNums(){
        System.out.println(qPrevNums);
        return enterLottoLine();
    }

    public static int enterManualLottoCnt() {
        System.out.println(qManualNumCnt);
        return scanner.nextInt();
    }

    public static List<LottoLine> enterManualNums(int manualCnt){
        System.out.println(qManualNums);
        List<LottoLine> lines = new ArrayList<>(manualCnt);

        for(int i=0;i<manualCnt;i++){
            LottoLine lottoLine = enterLottoLine();
            lines.add(lottoLine);
        }

        return lines;
    }
}
