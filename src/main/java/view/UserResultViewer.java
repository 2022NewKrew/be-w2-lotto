package view;

import constants.RankInfo;
import parameters.LottoResult;

public class UserResultViewer {
    public UserResultViewer() { }

    public static void viewResult(LottoResult lottoResult){
        System.out.println("당첨 통계\n---------");
        RankInfo.valuesStream()
                .map(rankInfo -> rankInfo.getViewFormat(lottoResult.getResult(rankInfo)))
                .forEach(System.out::println);
    }
}