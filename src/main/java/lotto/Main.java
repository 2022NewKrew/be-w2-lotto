package lotto;

import lotto.collections.LottoLine;
import lotto.domain.LottoPack;
import lotto.collections.AnsLottoLine;
import lotto.dto.LottoResults;
import lotto.view.Printer;
import lotto.view.Reader;

import java.util.List;



public class Main {
    public static void main(String[] args) {

        int itemCnt = Reader.start();

        LottoPack lottoPack = new LottoPack(itemCnt);
        List<LottoLine> lottoNums = lottoPack.getNumList();

        Printer.printPurchasedLottos(lottoNums);

        AnsLottoLine matchNum = Reader.enterMatchNums();
        LottoResults lottoResults = lottoPack.getResults(matchNum);
        Printer.showResults(lottoResults);

    }
}
