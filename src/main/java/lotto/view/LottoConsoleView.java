package lotto.view;

import lotto.VO.Rank;
import lotto.domain.Lottos;
import lotto.domain.LottoResult;

public class LottoConsoleView implements LottoView {

    @Override
    public String printLottos(Lottos lottos) {
        System.out.println(lottos);
        return lottos.toString();
    }

    @Override
    public String printLottoResult(LottoResult lottoResult, float totalRateOfReturn) {
        StringBuilder builder = new StringBuilder();
        builder.append("당첨 통계\n");
        builder.append("---------\n");
        for (Rank rank : Rank.values()) {
            builder.append(rank.toString());
            builder.append(" - ");
            builder.append(lottoResult.getCountOf(rank));
            builder.append("개");
        }
        builder.append(String.format("총 수익률은 %.2f%% 입니다.", totalRateOfReturn));

        System.out.println(builder);
        return builder.toString();
    }

    @Override
    public String printError(String message) {
        System.out.println(message);
        return message;
    }

}
