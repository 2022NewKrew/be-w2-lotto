package view;

import constants.RankInfo;
import parameters.LottoResult;

public class UserResultViewer {
    private UserResultViewer() {
    }

    public static void view(LottoResult lottoResult) {
        System.out.println("당첨 통계\n---------");
        RankInfo.valuesStream()
                .map(rankInfo -> rankInfo.getViewFormat(lottoResult.getResult(rankInfo)))
                .forEach(System.out::println);
    }
}