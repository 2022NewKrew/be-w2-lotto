package lotto.view;

import static lotto.domain.game.LottoRank.FIFTH;
import static lotto.domain.game.LottoRank.FIRST;
import static lotto.domain.game.LottoRank.FOURTH;
import static lotto.domain.game.LottoRank.SECOND;
import static lotto.domain.game.LottoRank.THIRD;

import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.dto.LottoDTO;
import lotto.dto.LottoNumberDTO;
import lotto.dto.LottoResultDTO;
import lotto.dto.LottoTicketsDTO;

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

    public static LottoGameView create() {
        return new LottoGameView();
    }

    private LottoGameView() {
    }

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
            FIFTH.getPrizeMoney(), lottoResultDTO.getLottoRankCountDTO().getCountByRank(FIFTH),
            FOURTH.getPrizeMoney(), lottoResultDTO.getLottoRankCountDTO().getCountByRank(FOURTH),
            THIRD.getPrizeMoney(), lottoResultDTO.getLottoRankCountDTO().getCountByRank(THIRD),
            SECOND.getPrizeMoney(), lottoResultDTO.getLottoRankCountDTO().getCountByRank(SECOND),
            FIRST.getPrizeMoney(), lottoResultDTO.getLottoRankCountDTO().getCountByRank(FIRST),
            lottoResultDTO.getLottoProfitRateDTO().getProfitRate());
    }

    public void printLottoTickets(LottoTicketsDTO lottoTicketsDTO) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(lottoTicketsDTO.lottoTicketSize())
            .append(PRINT_PURCHASE_COUNT)
            .append(System.lineSeparator());

        lottoTicketsDTO.getLottoDTOs()
            .forEach(lottoDTO -> stringBuilder.append(printLottoTicket(lottoDTO))
                .append(System.lineSeparator()));

        System.out.println(stringBuilder);
    }

    private String printLottoTicket(LottoDTO lottoDTO) {
        return LOTTO_PRINT_START
            + lottoDTO.getLottoNumbers().stream()
            .map(LottoNumberDTO::getNumber)
            .map(String::valueOf)
            .collect(Collectors.joining(LOTTO_DELIMITER))
            + LOTTO_PRINT_END;
    }
}
