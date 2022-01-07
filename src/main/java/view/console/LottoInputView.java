package view.console;

import domain.lottonumber.BasicNumber;
import domain.lottonumber.BonusNumber;
import domain.lottonumber.LottoNumber;
import exception.NegativeException;
import view.console.dto.lottoticket.LottoTicketInputDto;
import view.console.dto.lottoticket.LottoTicketsInputDto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoInputView {

    private final Scanner sc = new Scanner(System.in);

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(sc.nextLine());
        if (money <= 0) {
            throw new NegativeException("금액을 정확히 입력해 주세요.");
        }
        return money;
    }

    public List<LottoNumber> inputWinningNumbers() {
        List<LottoNumber> winningNumbers = inputWinningBasicNumbers();
        winningNumbers.add(inputWinningBonusNumber());
        return winningNumbers;
    }

    private List<LottoNumber> inputWinningBasicNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Arrays.stream(sc.nextLine().split(","))
                .map(Integer::parseInt)
                .map(BasicNumber::new)
                .collect(Collectors.toList());
    }

    private LottoNumber inputWinningBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new BonusNumber(Integer.parseInt(sc.nextLine()));
    }

    public int inputNumberOfManualLottoTicket() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int numberOfManualLottoTicket = Integer.parseInt(sc.nextLine());
        if (numberOfManualLottoTicket < 0) {
            throw new NegativeException("음수는 입력하실수 없습니다.");
        }
        return numberOfManualLottoTicket;
    }

    public Optional<LottoTicketsInputDto> inputManualLottoTickets(int numberOfManualLottoTicket) {
        if (numberOfManualLottoTicket <= 0) {
            return Optional.empty();
        }

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return Optional.of(new LottoTicketsInputDto(IntStream.range(0, numberOfManualLottoTicket)
                .mapToObj(this::inputManualLottoTicket)
                .collect(Collectors.toUnmodifiableList())));
    }

    public LottoTicketInputDto inputManualLottoTicket(int numberOfManualLottoTicket) {
        List<String> splitManualLottoNumbers = List.of(sc.nextLine().split(","));
        List<LottoNumber> lottoNumbers = splitManualLottoNumbers.stream()
                .map(Integer::parseInt)
                .map(BasicNumber::new)
                .collect(Collectors.toUnmodifiableList());

        return new LottoTicketInputDto(lottoNumbers);
    }
}
