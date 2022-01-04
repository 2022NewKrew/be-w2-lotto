package com.kakao.model;

import com.kakao.data.LottoData;
import com.kakao.exception.MoneyRangeException;
import com.kakao.exception.PickedNumbersFormatException;

import java.util.ArrayList;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import java.util.Collections;
>>>>>>> edb2074 (1일차 중간 PR)
=======
>>>>>>> 4f43f8b (1차 Commit)
import java.util.List;

public class Lottos {

    private List<Lotto> lottoList;

    // 생성자
    public Lottos(final int moneyToBuyLottos) throws MoneyRangeException {
        checkMoneyRange(moneyToBuyLottos);

        int numberOfLotto = moneyToBuyLottos/LottoData.PRICE_OF_LOTTO;
        this.lottoList = getNewLottos(numberOfLotto);
    }

    // 유효성 검사
    private void checkMoneyRange(final int moneyToBuyLottos) throws MoneyRangeException {
<<<<<<< HEAD
<<<<<<< HEAD
        if(moneyToBuyLottos < LottoData.PRICE_OF_LOTTO ) {
=======
        if(moneyToBuyLottos < LottoData.MIN_PRICE_RANGE ) {
>>>>>>> edb2074 (1일차 중간 PR)
=======
        if(moneyToBuyLottos < LottoData.PRICE_OF_LOTTO ) {
>>>>>>> 231c634 (1차 PR 리뷰 개선)
            throw new MoneyRangeException();
        }
    }

    // 로또용지들 생성함수
    private List<Lotto> getNewLottos(int numberOfLottos) {
        List<Lotto> lottoList = new ArrayList<>();
        for(int i=0; i<numberOfLottos; i++){
            lottoList.add(getNewLotto());
        }
        return lottoList;
    }
    private Lotto getNewLotto() {
        Lotto newLotto = null;
        while(newLotto == null) {
            newLotto = generateLotto();
        }
        return newLotto;
    }

    // 로또 생성
    private Lotto generateLotto() {
        Lotto newLotto = null;
        try {
            newLotto = new Lotto(LottoData.generatePickedNumber());
        } catch (PickedNumbersFormatException e) {
            e.printStackTrace();
        } finally {
            return newLotto;
<<<<<<< HEAD
<<<<<<< HEAD
        }
    }

    // 로또의 당첨 등수 확인
    public List<Integer> matchLottosAreWinning(LottoWinning lottoWinning) {
        List<Integer> countOfWinningLottos = new ArrayList<>();
        for(int i=0; i<=LottoData.NUMBER_OF_PICK; i++) {
            countOfWinningLottos.add(0);
        }
        for(Lotto lotto: this.lottoList) {
            int winningNumber = lotto.matchNumberIsWinning(lottoWinning);
            updateCountOfWinningLottos(countOfWinningLottos, winningNumber);
        }
        return countOfWinningLottos;
    }
    private void updateCountOfWinningLottos(List<Integer> countOfWinningLottos, int winningNumber) {
        int countOfWinningNumber = countOfWinningLottos.get(winningNumber);
        countOfWinningLottos.set(winningNumber, countOfWinningNumber+1);
    }
=======
        }}

>>>>>>> edb2074 (1일차 중간 PR)
=======
        }
    }

    // 로또의 당첨 등수 확인
    public List<Integer> matchLottosAreWinning(LottoWinning lottoWinning) {
        List<Integer> countOfWinningLottos = new ArrayList<>();
        for(int i=0; i<=LottoData.NUMBER_OF_PICK; i++) {
            countOfWinningLottos.add(0);
        }
        for(Lotto lotto: this.lottoList) {
            int winningNumber = lotto.matchNumberIsWinning(lottoWinning);
            updateCountOfWinningLottos(countOfWinningLottos, winningNumber);
        }
        return countOfWinningLottos;
    }
    private void updateCountOfWinningLottos(List<Integer> countOfWinningLottos, int winningNumber) {
        int countOfWinningNumber = countOfWinningLottos.get(winningNumber);
        countOfWinningLottos.set(winningNumber, countOfWinningNumber+1);
    }
>>>>>>> 4f43f8b (1차 Commit)

    // getter
    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
