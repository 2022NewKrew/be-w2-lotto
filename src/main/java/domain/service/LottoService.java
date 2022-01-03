package domain.service;

import domain.buyer.Buyer;
import domain.lotto.Lotto;
import domain.lotto.Number;
import domain.result.Result;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static domain.result.Winning.FIRST_WINNING;
import static domain.result.Winning.FOURTH_WINNING;

public class LottoService {
    //로또
    private final List<Integer> hittingTable; //index를 맞힌 갯수, value를 해당 횟수
    private Buyer buyer;
    private Result result;

    //입출력
    private final InputView inputView;
    private final OutputView outputView;

    //상수
    private static final int LOTTO_PER_PRICE = 1000;
    private static int MIN_HITTING_CNT = FOURTH_WINNING.getHittingCnt();
    private static int MAX_HITTING_CNT = FIRST_WINNING.getHittingCnt();

    public LottoService() {
        hittingTable = new ArrayList<>(Collections.nCopies(MAX_HITTING_CNT + 1, 0));
        inputView = InputView.getInstance();
        outputView = OutputView.getInstance();
    }

    public void start() {
        buyingLotto();
        inputLastWinningNumber();
        calculateHittingLotto();

        outputView.showTotalHitting(hittingTable, MIN_HITTING_CNT, MAX_HITTING_CNT, buyer.getYield());
    }

    //구매자의 로또 정보를 바탕으로 맞힌 정보 및 수익 셋팅
    private void calculateHittingLotto() {
        List<Lotto> buyingLottos = buyer.getBuyingLottos();
        for (Lotto buyingLotto : buyingLottos) {
            int hittingCnt = result.calculateHittingCnt(buyingLotto);
            Integer curCnt = hittingTable.get(hittingCnt);

            hittingTable.set(hittingCnt, curCnt + 1);
        }
        buyer.calculateEarningInfo(hittingTable, MIN_HITTING_CNT, MAX_HITTING_CNT);
    }

    private void buyingLotto() {
        int buyingPrice = inputView.inputPrice();
        int buyingCnt = getBuyingCnt(buyingPrice);

        buyer = new Buyer(buyingPrice);
        buyer.buyingManyByRandom(buyingCnt);

        outputView.completeBuying(buyingCnt);
        outputView.showLottoNumbers(buyer.getBuyingLottos());
    }

    private void inputLastWinningNumber() {
        List<Integer> winningNumbers = inputView.inputLastWinningNumbers();

        List<Number> winningLottoNumber = winningNumbers.stream()
                .map(Number::new)
                .collect(Collectors.toList());

        result = new Result(winningLottoNumber);
    }

    private int getBuyingCnt(int buyingPrice) {
        return buyingPrice / LOTTO_PER_PRICE;
    }
}
