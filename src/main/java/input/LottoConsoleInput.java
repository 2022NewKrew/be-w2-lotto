package input;

import domain.Lotto;
import domain.LottoConst;

import java.util.List;
import java.util.Scanner;

public class LottoConsoleInput extends LottoInput {
    private final Scanner sc = new Scanner(System.in);

    public int inputPrice() throws IllegalArgumentException{
        System.out.println("구입 금액을 입력해주세요.");
        return super.inputPrice(sc.nextLine());
    }

    public int inputManualCount() throws IllegalArgumentException{
        System.out.println("수동으로 구매할 로또 수를 입력하세요.");
        int count = Integer.parseInt(sc.nextLine());
        ec.checkPositiveNumber(count);

        return count;
    }

    public List<Lotto> inputManualLotto(int totalPrice){
        int manualCount = inputManualCount();

        ec.checkOverTotalPrice(manualCount * LottoConst.ONE_LOTTO_PRICE, totalPrice);

        System.out.println("수동으로 구매할 번호를 입력하세요.");
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<manualCount; i++){
            sb.append(sc.nextLine()).append("\n");
        }

        return super.inputManualLotto(sb.toString(), totalPrice);
    }

    public Lotto inputResultLotto(){
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        return super.inputResultLotto(sc.nextLine());
    }

    public int inputResultBonusLotto() throws IllegalArgumentException{
        System.out.println("보너스 볼을 입력해주세요.");
        return super.inputResultBonusLotto(sc.nextLine());
    }
}
