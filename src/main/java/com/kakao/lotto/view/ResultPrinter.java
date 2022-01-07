package com.kakao.lotto.view;

import com.kakao.lotto.model.ConstLottoConfig;
import com.kakao.lotto.model.LottoNumber;
import com.kakao.lotto.model.LottoResultState;
import com.kakao.lotto.model.SystemLotto;
import com.kakao.lotto.model.UserLotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * author    : brody.moon
 * version   : 1.1
 * 결과 출력을 위한 클래스입니다.
 * print 관련 함수들의 집합입니다.
 */
public class ResultPrinter {
    /**
     * 결과 출력을 위해 사용자가 가진 로또들과 당첨 로또의 정보를 받아 저장합니다.
     */
    private final List<LottoNumber> buyLottoNumbers;
    private final int numOfCustomLotto;
    private final LottoNumber winningLottoNumber;
    private final int winningLottoBonusNumber;

    public ResultPrinter(UserLotto userLotto, SystemLotto systemLotto) {
        this.buyLottoNumbers = userLotto.getLottoNumbers();
        this.numOfCustomLotto = userLotto.getNumOfCustomLotto();
        this.winningLottoNumber = systemLotto.getWinningLottoNumbers();
        this.winningLottoBonusNumber = systemLotto.getBonus();
    }

    /**
     * 유저가 가지고 있는 로또 번호들을 전체 출력해주는 메서드입니다.
     */
    public void printBuyLottoNumbers() {
        System.out.println(String.format(ConstStringSpace.NUMBERS_OF_CUSTOM_AND_AUTO_LOTTOS, numOfCustomLotto, buyLottoNumbers.size() - numOfCustomLotto));

        for (LottoNumber buyLottoNumber : buyLottoNumbers) {
            System.out.println(buyLottoNumber.getAll().stream().sorted().collect(Collectors.toList()));
        }
    }

    /**
     * 로또 당첨 번호를 출력해주는 메서드입니다.
     */
    public void printWinningLottoNumber() {
        System.out.println(ConstStringSpace.INPUT_PREVIOUS_NUMBERS);

        System.out.println(winningLottoNumber);

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

        for (Map.Entry<LottoResultState, Integer> entry : result.entrySet()) {
            String additionString = entry.getKey() == LottoResultState.SECOND ? ConstStringSpace.SECOND_PRICE_ADDITION_STRING : " ";

            String printString = String.format(ConstStringSpace.RESULT_STRING, entry.getKey().getNumOfMatchs(), additionString, entry.getKey().getPrice(), entry.getValue());

            System.out.println(printString);

            sum += entry.getKey().getPrice() * entry.getValue();
        }

        printProfitRate(sum, buyLottoNumbers.size() * ConstLottoConfig.LOTTO_PRICE);
    }

    public Map<Integer, String> createResultHashMap(Map<LottoResultState, Integer> result) {
        Map<Integer, String> tempMap = new HashMap<>();

        int i = 0;
        for (Map.Entry<LottoResultState, Integer> entry : result.entrySet()) {
            String additionString = entry.getKey() == LottoResultState.SECOND ? ConstStringSpace.SECOND_PRICE_ADDITION_STRING : " ";

            String printString = String.format(ConstStringSpace.RESULT_STRING, entry.getKey().getNumOfMatchs(), additionString, entry.getKey().getPrice(), entry.getValue());

            tempMap.put(i++, printString);
        }

        return tempMap;
    }

    public int createProfitRate(Map<LottoResultState, Integer> result) {
        int sum = 0;

        for (LottoResultState state : result.keySet()) {
            sum += state.getPrice() * result.get(state);
        }

        if(buyLottoNumbers.size() == 0)
            return 0;
        return (int) ((sum - buyLottoNumbers.size() * ConstLottoConfig.LOTTO_PRICE) / (double) (buyLottoNumbers.size() * ConstLottoConfig.LOTTO_PRICE) * 100);
    }

    /**
     * 수익률을 출력하는 메서드입니다.
     * 로또를 하나도 구매하지 않았을 경우 0으로 나누는 Exception 을 따로 처리하기 위해 작성하였습니다.
     *
     * @param sumProfitPrice        총 당첨 금액
     * @param sumPerchaseLottoPrice 총 구매 금액
     */
    private void printProfitRate(int sumProfitPrice, int sumPerchaseLottoPrice) {
        if (sumPerchaseLottoPrice == 0) {
            System.out.println(String.format(ConstStringSpace.PROFIT_RATE, 0));
            return;
        }

        System.out.println(String.format(ConstStringSpace.PROFIT_RATE, (int) ((sumProfitPrice - sumPerchaseLottoPrice) / (double) sumPerchaseLottoPrice * 100)));
    }
}
