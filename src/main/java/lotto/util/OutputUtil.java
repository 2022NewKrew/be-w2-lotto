package lotto.util;

import lotto.dto.LottoGameDto;

import java.util.List;

public class OutputUtil {

    public void PrintPurchaseGameCnt(int purchaseGameCnt) {
        System.out.println(String.format("%d개를 구매했습니다.", purchaseGameCnt));
    }

    public void printPurchaseGames(List<LottoGameDto> lottoGames) {
        for (LottoGameDto lottoGame : lottoGames) {
            System.out.println(lottoGame);
        }
    }
}
