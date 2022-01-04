package view;

import constants.LottoRankInfoList;
import parameters.LottoResult;

public class UserResultViewer {
    public UserResultViewer() { }

    public void viewResult(LottoResult lottoResult){
        System.out.println("당첨 통계\n---------");
        LottoRankInfoList.getInstance()
                .getRankInfoStream()
                .map(lottoResult::getViewFormat)
                .forEach(System.out::println);
    }
}