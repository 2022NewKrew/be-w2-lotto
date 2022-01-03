package lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.dto.LottoDTO;

public class LottoGameView {

    private static final String LOTTO_BLOCK_START = "[";
    private static final String LOTTO_BLOCK_END = "]";
    private static final String LOTTO_TICKET_DELIMITER = ", ";

    private static final Scanner scanner = new Scanner(System.in);

    public int inputPurchasePrice() {
        System.out.println("구매금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public void printLottoTickets(List<LottoDTO> lottoTickets) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(lottoTickets.size()).append("개를 구매했습니다.")
            .append(System.lineSeparator());

        lottoTickets.forEach(ticket -> stringBuilder.append(convertLottoDTOToString(ticket))
            .append(System.lineSeparator()));

        System.out.println(stringBuilder);
    }

    private String convertLottoDTOToString(LottoDTO lottoTicket) {
        return LOTTO_BLOCK_START + lottoTicket.getLottoNumbers().stream()
            .map(String::valueOf)
            .collect(Collectors.joining(LOTTO_TICKET_DELIMITER))
            + LOTTO_BLOCK_END;
    }
}
