package domain.buyer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BuyerTest {
    Buyer buyer;
    int testPrice;

    @BeforeEach
    void init() {
        testPrice = 5000;
        buyer = new Buyer(testPrice);
    }

    @Test
    @DisplayName("로또로 얻게된 수익 테스트")
    void calculateEarningPriceTest() {
        //given
        int targetRank = 5;
        int highestRank = 1;
        int lowestRank = 6;

        List<Integer> testTable = new ArrayList<>();
        for (int i = 0; i <= lowestRank; i++) {
            testTable.add(0);
        }
        testTable.set(targetRank, 1); //5 당첨 (5000원 획득)

        //when
        buyer.calculateEarningPrice(testTable, highestRank, lowestRank);

        //then
        Assertions.assertEquals(5000, buyer.getEarningPrice().getValue());
    }

    @Test
    @DisplayName("로또로 얻게된 수익률 테스트")
    void calculateYieldTest() {
        //given
        int targetRank = 5;
        int highestRank = 1;
        int lowestRank = 6;

        List<Integer> testTable = new ArrayList<>();
        for (int i = 0; i <= lowestRank; i++) {
            testTable.add(0);
        }
        testTable.set(targetRank, 1); //5 당첨 (5000원 획득)

        //when
        buyer.calculateEarningPrice(testTable, highestRank, lowestRank);
        buyer.calculateYied();

        //then
        Assertions.assertEquals(100, buyer.getYield().getPercent());
    }

    @Test
    @DisplayName("로또 구매 테스트")
    void buyingManyByRandomTest() {
        //given
        int buyingCnt = 3;

        //when
        buyer.buyingManyByRandom(buyingCnt);

        //then
        Assertions.assertEquals(buyingCnt, buyer.getBuyingLottos().size());
    }

}