import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoController {
    private final Scanner sc = new Scanner(System.in);


    public void startLotto(){
        LottoList lottoList = new LottoList();
        lottoList.createLottoList(inputPrice());

        LottoResult lottoResult = new LottoResult(lottoList);
        LottoView lottoView = new LottoView(lottoList, lottoResult);

        lottoView.printLottoList();
        lottoView.printLottoResult(inputResultLotto());
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
}
