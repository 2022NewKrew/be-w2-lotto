package lotto;

import lotto.collections.LottoLine;
import lotto.domain.LottoPack;
import lotto.collections.AnsLottoLine;
import lotto.dto.InputLottoConfig;
import lotto.dto.LottoResults;
import lotto.view.Printer;
import lotto.view.Reader;

import java.util.List;

import static lotto.view.Reader.enterManualInfo;


public class Main {
    private static int purchase(){
        int amount = Reader.enterPurchaseAmount();
        int totalCnt = Printer.printAndGetAmount(amount);
        return totalCnt;
    }

    public static void main(String[] args) {

        int totalLottoCnt = purchase();
        InputLottoConfig inputLottoConfig = enterManualInfo(totalLottoCnt);
        LottoPack lottoPack = new LottoPack(inputLottoConfig);

        Printer.printPurchasedLottos(inputLottoConfig, lottoPack.getLottos());

        AnsLottoLine matchNum = Reader.enterMatchNums();
        LottoResults lottoResults = lottoPack.getResults(matchNum);
        Printer.showResults(lottoResults);

    }
}
