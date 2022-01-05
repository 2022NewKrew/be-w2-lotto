import domain.Lotto;
import domain.LottoList;
import domain.LottoResult;
import view.LottoView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoController {
    private final Scanner sc = new Scanner(System.in);

    public void startLotto(){
        LottoView lottoView = new LottoView();

        LottoList lottoList = createLottoList();
        lottoView.printLottoList(lottoList);

        LottoResult lottoResult = createLottoResult(lottoList);

        lottoView.printLottoResult(lottoResult);
    }

    private LottoList createLottoList(){
        LottoList lottoList = new LottoList();
        int price = inputPrice();

        lottoList.createManualLottoList(inputManualLotto());
        lottoList.createAutoLottoList(price - lottoList.getLottoPrice());
        return lottoList;
    }

    private LottoResult createLottoResult(LottoList lottoList){
        Lotto resultLottoNumber = inputResultLotto();
        int resultBonusNumber = inputResultBonusLotto();

        return new LottoResult(lottoList, resultLottoNumber, resultBonusNumber);
    }


    private int inputPrice(){
        System.out.println("구입 금액을 입력해주세요.");
        return Integer.parseInt(sc.nextLine());
    }

    private int inputManualCount(){
        System.out.println("수동으로 구매할 로또 수를 입력하세요.");
        return Integer.parseInt(sc.nextLine());
    }

    private List<Lotto> inputManualLotto(){
        int manualCount = inputManualCount();
        List<Lotto> manualLotto = new ArrayList<>();

        System.out.println("수동으로 구매할 번호를 입력하세요.");
        for(int i=0; i<manualCount; i++){
            Lotto lotto = new Lotto(Arrays.stream(sc.nextLine().split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList())
            );

            manualLotto.add(lotto);
        }

        return manualLotto;
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
