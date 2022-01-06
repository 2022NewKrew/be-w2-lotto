import domain.Lotto;
import domain.LottoResults;
import domain.LottoTicket;
import domain.lottonumber.BasicNumber;
import domain.lottonumber.BonusNumber;
import domain.lottonumber.LottoNumber;
import domain.LottoShop;
import dto.YieldDto;
import dto.LottoResultsDto;
import service.LottoGenerator;
import view.LottoPrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoApp {

    private static final Scanner sc = new Scanner(System.in);
    private static final LottoShop lottoShop = new LottoShop(new LottoGenerator());
    private static final LottoPrinter lottoPrinter = new LottoPrinter();

    public static void main(String[] args) {
        int money = inputMoney();
        Lotto lotto = lottoShop.sell(inputManualLottoTickets(inputNumberOfManualLottoTicket()), money);
        lottoPrinter.printLotto(lotto.getLottoTicketsView());
        LottoResults lottoResults = lotto.checkLottoResults(inputWinningNumbers());
        lottoPrinter.printLottoResults(new LottoResultsDto(lottoResults));
        lottoPrinter.printYield(new YieldDto(lottoResults.getEarnedMoney(), lotto.getPrice()));
    }

    private static List<LottoTicket> inputManualLottoTickets(int numberOfManualLottoTicket) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<LottoTicket> manualLottoTickets = createManualLottoTickets(numberOfManualLottoTicket);
        return manualLottoTickets;
    }

    private static int inputNumberOfManualLottoTicket() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int numberOfManualLottoTicket = Integer.parseInt(sc.nextLine());
        return numberOfManualLottoTicket;
    }

    private static List<LottoTicket> createManualLottoTickets(int numberOfManualLottoTicket) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < numberOfManualLottoTicket; i++) {
            lottoTickets.add(new LottoTicket(createManualLottoTicket()));
        }
        return lottoTickets;
    }

    private static List<LottoNumber> createManualLottoTicket() {
        List<String> splitManualLottoNumbers = List.of(sc.nextLine().split(","));
        List<LottoNumber> lottoNumbers = splitManualLottoNumbers.stream()
                .map(Integer::parseInt)
                .map(BasicNumber::new)
                .collect(Collectors.toUnmodifiableList());
        return lottoNumbers;
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
