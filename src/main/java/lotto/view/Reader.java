package lotto.view;

import lotto.collections.AnsLottoLine;
import lotto.collections.LottoLine;
import lotto.collections.LottoNumber;
import lotto.domain.LottoPack;
import lotto.dto.InputLottoConfig;

import java.util.*;

public class Reader {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String qPrice = "구입 금액을 입력해주세요.";
    private static final String qPrevNums = "지난 주 당첨 번호을 입력해주세요. -- 띄어쓰기로 구별 ex) 1 2 3 4 5 6";
    private static final String qBonusNum = "보너스 볼을 입력해 주세요.";
    private static final String qManualNumCnt = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String qManualNums = "수동으로 구매할 번호를 입력해 주세요.";


    public static InputLottoConfig enterManualInfo(int totalCnt) throws InputMismatchException{
        int manualCnt = enterManualLottoCnt();
        if(manualCnt> totalCnt){
            throw new InputMismatchException("수동 로또 개수가 전체 구매한 로또 개수보다 클 수 없습니다.");
        }
        List<LottoLine> lottoLines = enterManualNums(manualCnt);
        return new InputLottoConfig(manualCnt, totalCnt, lottoLines);
    }

    public static AnsLottoLine enterMatchNums() throws IllegalArgumentException{
        LottoLine prevNums = enterPrevNums();
        LottoNumber bonusNum = enterBonusNum();
        if (prevNums.contains(bonusNum)){
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        return new AnsLottoLine(prevNums, bonusNum);
    }

    public static int enterPurchaseAmount() throws InputMismatchException{
        System.out.println(qPrice);
        int purchaseAmount =  scanner.nextInt();
        if ( purchaseAmount <= LottoPack.LOTTO_PRICE) {
            throw new InputMismatchException(String.format("구매 최소 금액은 %d원 입니다.", LottoPack.LOTTO_PRICE ));
        }
        return purchaseAmount;
    }

    private static LottoNumber enterBonusNum(){
        System.out.println(qBonusNum);
        int num = scanner.nextInt();
        return new LottoNumber(num);
    }

    private static LottoLine enterLottoLine() throws InputMismatchException{
        List<LottoNumber> temp = new ArrayList<>();
        String[] inputNums =  scanner.nextLine().split(" ");

        for(String n: inputNums){
            temp.add(new LottoNumber(Integer.parseInt(n)));
        }
        if (temp.size()!=6){
            throw new InputMismatchException("수동 로또 번호는 6개를 입력해야 합니다.");
        }

        return new LottoLine(new HashSet<>(temp));

    }

    public static LottoLine enterPrevNums(){
        System.out.println(qPrevNums);
        return enterLottoLine();
    }

    // 수동 로또의 개수 입력
    public static int enterManualLottoCnt() throws InputMismatchException {
        System.out.println(qManualNumCnt);
        int manualCnt = scanner.nextInt();
        if (manualCnt < 0){
            throw new InputMismatchException("로또 수는 1 이상 이여야 합니다.");
        }
        return manualCnt;
    }

    // 수동 로또 번호 입력
    public static List<LottoLine> enterManualNums(int manualCnt){
        System.out.println(qManualNums);
        List<LottoLine> lines = new ArrayList<>(manualCnt);
        scanner.nextLine();

        for(int i=0;i<manualCnt;i++){
            LottoLine lottoLine = enterLottoLine();
            lines.add(lottoLine);
        }

        return lines;
    }
}
