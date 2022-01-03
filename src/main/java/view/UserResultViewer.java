package view;

import constants.LottoRule;
import parameters.LottoResult;

public class UserResultViewer {
    public UserResultViewer() { }

    public void viewResult(LottoResult lottoResult){
        System.out.println("당첨 통계\n---------");
        for(int rank = LottoRule.FAIL + 1; rank <= LottoRule.FIRST; rank++){
            System.out.println(lottoResult.getViewFormat(rank));
        }
    }
}