package service;

import domain.Lotto;
import domain.Number;
import domain.WinningLotto;
import domain.WinningLottoManual;
import enums.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ResultServiceTest {
    static ResultService resultService;
    static ArrayList<Number> numberList1;
    static ArrayList<Number> numberList2;
    static ArrayList<Number> numberList3;
    static Lotto lotto1;
    static Lotto lotto2;
    static Lotto lotto3;

    WinningLotto winningLotto;
    ArrayList<Lotto> lottoList;
    @BeforeEach
    void setUp(){
        resultService = new ResultService();
        numberList1 = new ArrayList<>(Arrays.asList(
                new Number(1),new Number(2),
                new Number(3),new Number(4),
                new Number(5),new Number(6)));
        numberList2 = new ArrayList<>(Arrays.asList(
                new Number(11),new Number(12),
                new Number(13),new Number(4),
                new Number(5),new Number(6)));
        numberList3 = new ArrayList<>(Arrays.asList(
                new Number(21),new Number(22),
                new Number(3),new Number(4),
                new Number(5),new Number(6)));
        lotto1 = new Lotto(numberList1);
        lotto2 = new Lotto(numberList2);
        lotto3 = new Lotto(numberList3);
        winningLotto = new WinningLottoManual(lotto3, new Number(13));

        lottoList = new ArrayList<>();
        lottoList.add(lotto1);
        lottoList.add(lotto2);
        
        resultService.generateResult(lottoList, winningLotto);
    }

    @Test
    @DisplayName("로또 결과중 매개변수로 넘긴 Rank가 몇개인지 테스트")
    void getCountRank() {
        Rank rank = Rank.FOURTH;
        assertEquals(resultService.getCountRank(rank), 1);
    }

    @Test
    @DisplayName("enum 클래스(Rank) 비교 함수 equals() 테스트")
    void isSameRank() {
        Rank rank1 = Rank.FIFTH;
        Rank rank2 = Rank.FIRST;
        assertNotEquals(resultService.isSameRank(rank1, rank2), 1);
    }

    @Test
    @DisplayName("수익 테스트")
    void getProfit() {
        assertEquals(resultService.getProfit(), 55000);
    }

    @Test
    @DisplayName("수익률 테스트")
    void getProfitRate() {
        assertEquals(resultService.getProfitRate(),2750);
    }
}