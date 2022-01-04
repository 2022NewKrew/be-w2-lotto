package view.output;

import domain.LottoResult;
import domain.LottoSheet;
import domain.PrizeType;

import java.util.Map;

public class ConsoleOutputPrinter implements OutputPrinter{
    @Override
    public void printLottoSheet(LottoSheet lottoSheet) {
        StringBuilder sb = new StringBuilder();
        lottoSheet.getLottoList().forEach(lotto ->
        {
            sb.append(lotto.getNumbers());
            sb.append('\n');
        });
        System.out.println(sb);

    }

    @Override
    public void printLottoResult(Map<Integer, Integer> userResult) {
        StringBuilder sb = new StringBuilder();
        PrizeType.PRIZE_MAP.keySet().stream()
                .forEach(prizeNum -> {
                    int result = userResult.get(prizeNum) == null ? 0 : userResult.get(prizeNum);
                    sb.append(
                        prizeNum + "개 일치 ("
                        + PrizeType.of(prizeNum).getWinningPrize() + "원)- "
                        + result + "개\n");
                });

        System.out.println(sb);

    }
}
