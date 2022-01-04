package lotto.view;

import static lotto.domain.LottoRank.FIFTH;
import static lotto.domain.LottoRank.FIRST;
import static lotto.domain.LottoRank.FOURTH;
import static lotto.domain.LottoRank.SECOND;
import static lotto.domain.LottoRank.THIRD;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.dto.LottoDTO;
import lotto.dto.LottoResultDTO;

public class LottoGameView {

    private static final String PRINT_PURCHASE_COUNT = "개를 구매했습니다.";
    private static final String PRINT_RESULT_FORMAT = "%n당첨 통계%n"
        + "---------%n"
        + "3개 일치 (%d원) - %d개%n"
        + "4개 일치 (%d원) - %d개%n"
        + "5개 일치 (%d원) - %d개%n"
        + "5개 일치, 보너스 볼 일치 (%d원) - %d개%n"
        + "6개 일치 (%d원) - %d개%n"
        + "총 수익률은 %.2f%%입니다.%n";

    private static final String LOTTO_PRINT_START = "[";
    private static final String LOTTO_PRINT_END = "]";
    private static final String LOTTO_DELIMITER = ", ";

    private static final Scanner scanner = new Scanner(System.in);

    public String inputPurchasePrice() {
        System.out.println("구매금액을 입력해주세요.");
        return scanner.nextLine();
    }

    public String[] inputWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine().split(LOTTO_DELIMITER);
    }

    public String inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }

    public void printLottoResult(LottoResultDTO lottoResultDTO) {
        System.out.printf(PRINT_RESULT_FORMAT,
            FIFTH.getPrizeMoney(), lottoResultDTO.getLottoRankCount().getOrDefault(FIFTH, 0L),
            FOURTH.getPrizeMoney(), lottoResultDTO.getLottoRankCount().getOrDefault(FOURTH, 0L),
            THIRD.getPrizeMoney(), lottoResultDTO.getLottoRankCount().getOrDefault(THIRD, 0L),
            SECOND.getPrizeMoney(), lottoResultDTO.getLottoRankCount().getOrDefault(SECOND, 0L),
            FIRST.getPrizeMoney(), lottoResultDTO.getLottoRankCount().getOrDefault(FIRST, 0L),
            lottoResultDTO.getProfitRate());
    }

    public void printLottoTickets(List<LottoDTO> lottoDTOS) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(lottoDTOS.size())
            .append(PRINT_PURCHASE_COUNT)
            .append(System.lineSeparator());

        lottoDTOS.forEach(lottoDTO -> stringBuilder.append(printLottoTicket(lottoDTO))
            .append(System.lineSeparator()));

        System.out.println(stringBuilder);
    }

    private String printLottoTicket(LottoDTO lottoDTO) {
        return LOTTO_PRINT_START
            + lottoDTO.getLottoNumbers().stream()
            .map(String::valueOf)
            .collect(Collectors.joining(LOTTO_DELIMITER))
            + LOTTO_PRINT_END;
    }
}
