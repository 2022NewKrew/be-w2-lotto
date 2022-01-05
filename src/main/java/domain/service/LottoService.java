package domain.service;

import domain.buyer.Buyer;
import domain.lotto.Lotto;
import domain.lotto.Number;
import domain.result.Result;
import domain.result.Winning;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


import static domain.result.Winning.*;

public class LottoService {
    //index를 맞힌 갯수, value를 해당 횟수로 하는 자료구조
    private final List<Integer> hittingTable;

    //입출력
    private final InputView inputView;
    private final OutputView outputView;

    //상수
    private static final int LOTTO_PER_PRICE = 1000;
    private static int LOWEST_RANK = SIXTH_WINNING.getRank();
    private static int HIGHEST_RANK = FIRST_WINNING.getRank();

    public LottoService() {
        hittingTable = new ArrayList<>(Collections.nCopies(LOWEST_RANK + 1, 0));

        inputView = InputView.getInstance();
        outputView = OutputView.getInstance();
    }

    public void start() {
        try {
            Buyer buyer = buyingLotto();
            Result lastRottoResult = inputLastWinningNumber();
            calculateHittingLotto(buyer, lastRottoResult);

            outputView.showTotalHitting(hittingTable, LOWEST_RANK - 1, HIGHEST_RANK, buyer.getYield());
        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("There is no second chance... bye..");
        }
    }

    //구매자의 로또 정보를 바탕으로 맞힌 정보 및 수익 셋팅
    private void calculateHittingLotto(Buyer buyer, Result result) {
        List<Lotto> buyingLottos = buyer.getBuyingLottos();
        for (Lotto buyingLotto : buyingLottos) {
            int hittingCnt = result.calculateHittingCnt(buyingLotto);
            int bonusCnt = result.calculateBonusCnt(buyingLotto);
            int rank = Winning.rankOfHitting(hittingCnt, bonusCnt);

            Integer curCnt = hittingTable.get(rank);

            hittingTable.set(rank, curCnt + 1);
        }
        buyer.calculateEarningInfo(hittingTable, HIGHEST_RANK, LOWEST_RANK);
    }

    private Buyer buyingLotto() {
        int buyingPrice = inputView.inputPrice();
        int buyingCnt = getBuyingCnt(buyingPrice);
        int inputBuyingCnt = inputView.inputBuyingLottoCnt();

        Buyer buyer = new Buyer(buyingPrice);
        buyingInputLotto(buyer, inputBuyingCnt);
        buyer.buyingManyByRandom(buyingCnt - inputBuyingCnt);

        printCompleteMessage(buyingCnt, inputBuyingCnt, buyer);

        return buyer;
    }

    private void buyingInputLotto(Buyer buyer, int inputBuyingCnt) {
        List<List<Integer>> lottos = inputView.inputBuyingLottoNumbers(inputBuyingCnt);

        for(List<Integer> lotto : lottos) {
            List<Number> lottoNumbers = lotto.stream()
                    .map(Number::new)
                    .collect(Collectors.toList());
            buyer.buyingByInput(lottoNumbers);
        }
    }

    public void printCompleteMessage(int buyingCnt, int inputBuyingCnt, Buyer buyer) {
        outputView.completeBuying(buyingCnt, inputBuyingCnt);
        outputView.showLottoNumbers(buyer.getBuyingLottos());
    }

    private Result inputLastWinningNumber() {
        List<Integer> winningNumbers = inputView.inputLastWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber();

        List<Number> winningLottoNumber = winningNumbers.stream()
                .map(Number::new)
                .collect(Collectors.toList());

        return new Result(winningLottoNumber, new Number(bonusNumber));
    }

    private int getBuyingCnt(int buyingPrice) {
        return buyingPrice / LOTTO_PER_PRICE;
    }
}
