package com.kakao.lotto.view;

import com.kakao.lotto.model.ConstLottoConfig;
import com.kakao.lotto.model.LottoResultState;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * author    : brody.moon
 * version   : 1.0
 * 결과 출력을 위한 클래스입니다.
 * print 관련 함수들의 집합입니다.
 */
public class PrintResult {
    /**
     * 결과 출력을 위해 사용자가 가진 로또들과 당첨 로또의 정보를 받아 저장합니다.
     */
    private final List<int[]> buyLottoNumbers;
    private final int numOfCustomLotto;
    private final int[] winningLottoNumber;
    private final int winningLottoBonusNumber;

    public PrintResult(List<int[]> buyLottoNumbers, int numOfCustomLotto, int[] winningLottoNumber, int winningLottoBonusNumber) {
        this.buyLottoNumbers = buyLottoNumbers;
        this.numOfCustomLotto = numOfCustomLotto;
        this.winningLottoNumber = winningLottoNumber;
        this.winningLottoBonusNumber = winningLottoBonusNumber;
    }

    /**
     * 유저가 가지고 있는 로또 번호들을 전체 출력해주는 메서드입니다.
     */
    public void printBuyLottoNumbers() {
        System.out.println(String.format(ConstStringSpace.NUMBERS_OF_CUSTOM_AND_AUTO_LOTTOS, numOfCustomLotto, buyLottoNumbers.size() - numOfCustomLotto));

        buyLottoNumbers.stream()
                .forEach(intArray -> System.out.println(Arrays.toString(intArray)));
    }

    /**
     * 로또 당첨 번호를 출력해주는 메서드입니다.
     */
    public void printWinningLottoNumber() {
        System.out.println(ConstStringSpace.INPUT_PREVIOUS_NUMBERS);

        System.out.println(Arrays.toString(winningLottoNumber));

        System.out.println(ConstStringSpace.INPUT_BONUS_NUMBER);

        System.out.println(winningLottoBonusNumber);
    }

    /**
     * 유저 로또들의 당첨 횟수를 모아서 출력해주는 메서드입니다.
     *
     * @param result 로또 등수 관련 Enum 인 LottoResultState 를 key 로 사용하고 각 당첨 횟수를 value 로 가진 EnumMap
     */
    public void printAllLottoResult(Map<LottoResultState, Integer> result) {
        int sum = 0;

        System.out.println(ConstStringSpace.SHOW_STAT);
        System.out.println(ConstStringSpace.HOR_LINE);

        for (LottoResultState state : result.keySet()) {
            String printString = (state == LottoResultState.SECOND) ?
                    String.format(ConstStringSpace.RESULT_STRING, state.getNumOfMatchs(), ConstStringSpace.SECOND_PRICE_ADDITION_STRING, state.getPrice(), result.get(state)) : String.format(ConstStringSpace.RESULT_STRING, state.getNumOfMatchs(), " ", state.getPrice(), result.get(state));

            System.out.println(printString);

            sum += state.getPrice() * result.get(state);
        }

        printProfitRate(sum, buyLottoNumbers.size() * ConstLottoConfig.LOTTO_PRICE);
    }

    /**
     * 수익률을 출력하는 메서드입니다.
     * 로또를 하나도 구매하지 않았을 경우 0으로 나누는 Exception 을 따로 처리하기 위해 작성하였습니다.
     *
     * @param sumProfitPrice        총 당첨 금액
     * @param sumPerchaseLottoPrice 총 구매 금액
     */
    private void printProfitRate(int sumProfitPrice, int sumPerchaseLottoPrice) {
        if (sumProfitPrice == 0) {
            System.out.println(String.format(ConstStringSpace.PROFIT_RATE, 0));
            return;
        }

        System.out.println(String.format(ConstStringSpace.PROFIT_RATE, (int) (sumProfitPrice / (double) sumPerchaseLottoPrice * 100)));
    }
}
