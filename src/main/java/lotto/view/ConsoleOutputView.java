package lotto.view;

import lotto.domain.*;

import java.util.Map;
import java.util.Set;

public class ConsoleOutputView implements OutputView {
    private static final String LOTTO_TICKET_START_DELIMITER = "[";
    private static final String LOTTO_TICKET_END_DELIMITER = "]";
    private static final String LOTTO_NUMBER_SPLIT_DELIMITER = ", ";
    private static final String LOTTO_STATISTICS_TITLE = "당첨 통계";
    private static final String TITLE_END_DELIMITER = "---------";

    public void printLottoTicketCount(int inputPrice) {
        int lottoTicketCount = inputPrice / LottoMachine.TICKET_PRICE;
        System.out.println(lottoTicketCount + "개를 구매했습니다.");
    }

    public void printLottoTickets(LottoTickets lottoTickets) {
        for (LottoTicket ticket : lottoTickets) {
            printLottoNumbers(ticket.getLottoNumbers());
        }
        System.out.println();
    }

    // TODO: 로또 번호 오름차순 출력
    private void printLottoNumbers(LottoNumbers lottoNumbers) {
        StringBuilder stringBuilder = new StringBuilder(LOTTO_TICKET_START_DELIMITER);

        Set<LottoNumber> numbers = lottoNumbers.getLottoNumbers();
        for (LottoNumber number : numbers) {
            stringBuilder.append(number.getNumber())
                    .append(LOTTO_NUMBER_SPLIT_DELIMITER);
        }
        stringBuilder.append(LOTTO_TICKET_END_DELIMITER);

        System.out.println(stringBuilder);
    }

    public void printLottoStatistics(Money inputMoney, LottoStatistics lottoStatistics) {
        StringBuilder stringBuilder = new StringBuilder(System.lineSeparator());
        stringBuilder.append(LOTTO_STATISTICS_TITLE)
                .append(System.lineSeparator())
                .append(TITLE_END_DELIMITER)
                .append(System.lineSeparator());


        Map<LottoResult, Integer> resultMap = lottoStatistics.getResultMap();
        for (Map.Entry<LottoResult, Integer> resultEntry : resultMap.entrySet()) {
            LottoResult lottoResult = resultEntry.getKey();
            int matchCount = lottoResult.getMatchCount();
            int reward = lottoResult.getReward();
            int count = resultEntry.getValue();
            stringBuilder.append(String.format("%d개 일치 (%d)원- %d개\n", matchCount, reward, count));
        }

        int revenueRate = lottoStatistics.calculateRevenueRate(inputMoney);
        stringBuilder.append(String.format("총 수익률은 %d%%입니다.\n", revenueRate));

        System.out.println(stringBuilder);
    }
}
