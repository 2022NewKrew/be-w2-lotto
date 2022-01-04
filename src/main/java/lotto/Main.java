package lotto;

import lotto.domain.LottoPack;
import lotto.dto.LottoResults;
import lotto.dto.MatchNum;
import lotto.view.IO;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        IO io = new IO();
        int itemCnt = io.start();

        LottoPack lottoPack = new LottoPack(itemCnt);
        List<List<Integer>> lottoNums = lottoPack.getNumList();

        io.printPurchasedLottos(lottoNums);

        MatchNum matchNum = io.enterMatchNums();
        LottoResults lottoResults = lottoPack.getResults(matchNum); // -> 추후 test, earnRate, prevNum
        io.showResults(lottoResults);

    }
}
