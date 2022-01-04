import domain.Lotto;
import domain.LottoList;
import domain.LottoResult;
import view.LottoView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoController {
    private final Scanner sc = new Scanner(System.in);

    public void startLotto(){
        LottoList lottoList = new LottoList();
        LottoView lottoView = new LottoView();

        lottoList.createLottoList(inputPrice());
        lottoView.printLottoList(lottoList);

        Lotto resultLottoNumber = inputResultLotto();
        int resultBonusNumber = inputResultBonusLotto();
        LottoResult lottoResult = new LottoResult(lottoList, resultLottoNumber, resultBonusNumber);

        lottoView.printLottoResult(lottoResult);
    }

    private int inputPrice(){
        System.out.println("구입 금액을 입력해주세요.");
        return Integer.parseInt(sc.nextLine());
    }

    private Lotto inputResultLotto(){
        System.out.println("지난 주 당첨 번호를 입력해주세요.");

        List<Integer> lottoNumber = Arrays.stream(sc.nextLine().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new Lotto(lottoNumber);
    }

    private int inputResultBonusLotto(){
        System.out.println("보너스 볼을 입력해주세요.");

        return Integer.parseInt(sc.nextLine());
    }
}
