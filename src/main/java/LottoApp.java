import domain.Lotto;
import domain.lottonumber.BasicNumber;
import domain.lottonumber.BonusNumber;
import domain.lottonumber.LottoNumber;
import domain.LottoShop;
import dto.LottoDto;
import dto.LottoResultsDto;
import service.LottoGenerator;
import view.LottoPrinter;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoApp {

    private static final Scanner sc = new Scanner(System.in);
    private static final LottoShop lottoShop = new LottoShop(new LottoGenerator());
    private static final LottoPrinter lottoPrinter = new LottoPrinter();

    public static void main(String[] args) {
        Lotto lotto = lottoShop.sell(inputMoney());
        lottoPrinter.printLotto(lotto.getLottoTicketsView());
        lotto.checkLottoResult(inputWinningNumbers());
        lottoPrinter.printLottoResults(new LottoResultsDto(lotto.getResult()));
        lottoPrinter.printYield(new LottoDto(lotto));
    }

    private static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(sc.nextLine());
    }

    private static List<LottoNumber> inputWinningNumbers() {
        List<LottoNumber> winningNumbers = inputWinningBasicNumbers();
        winningNumbers.add(inputWinningBonusNumber());
        return winningNumbers;
    }

    private static List<LottoNumber> inputWinningBasicNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Stream.of(sc.nextLine().split(","))
                .map(Integer::parseInt)
                .map(BasicNumber::new)
                .collect(Collectors.toList());
    }

    private static LottoNumber inputWinningBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new BonusNumber(Integer.parseInt(sc.nextLine()));
    }

}
