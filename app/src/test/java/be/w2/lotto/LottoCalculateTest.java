package be.w2.lotto;

import be.w2.lotto.Domain.*;
import be.w2.lotto.View.UserInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoCalculateTest {

    UserInterface userInterface;
    static final String ANSWER_INPUT = "1, 2, 3, 4, 5, 6";

    @BeforeEach
    void setUp() {
        userInterface = new UserInterface();
    }

    List<String> setTestCase1() {
        List<String> testCase = new ArrayList<>();
        testCase.add("8, 21, 23, 41, 42, 43");
        testCase.add("3, 5, 11, 16, 32, 38");
        testCase.add("7, 11, 16, 35, 36, 44");
        testCase.add("1, 8, 11, 31, 41, 42");
        testCase.add("13, 14, 16, 38, 42, 45");
        testCase.add("7, 11, 30, 40, 42, 43");
        testCase.add("2, 13, 22, 32, 38, 45");
        testCase.add("23, 25, 33, 36, 39, 41");
        testCase.add("1, 3, 5, 14, 22, 45");
        testCase.add("5, 9, 38, 41, 43, 44");
        testCase.add("2, 8, 9, 18, 19, 21");
        testCase.add("13, 14, 18, 21, 23, 35");
        testCase.add("17, 21, 29, 37, 42, 45");
        testCase.add("3, 8, 27, 30, 35, 44");
        return testCase;
    }

    @Test
    @DisplayName("로또_연산_결과_수익_테스트")
    void test_benefit() {
        List<String> testCase1 = setTestCase1();
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        for (String str : testCase1)
            lottoTicketList.add(new LottoTicket(LottoNumbers.getInstanceByIntList(userInterface.strToIntList(str))));
        LottoTickets lottoTickets = new LottoTickets(lottoTicketList);
        LottoCalculator lottoCalculator = new LottoCalculator(userInterface.strToIntList(ANSWER_INPUT));
        int benefit = lottoCalculator.calculateResult(lottoTickets);
        assertThat(benefit).isEqualTo(5000);
    }

    @Test
    @DisplayName("로또_연산_결과_수익률_테스트")
    void test_earningResult() {
        List<String> testCase1 = setTestCase1();
        Money money = new Money(LottoTicket.PRICE * testCase1.size());
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        for (String str : testCase1)
            lottoTicketList.add(new LottoTicket(LottoNumbers.getInstanceByIntList(userInterface.strToIntList(str))));
        LottoTickets lottoTickets = new LottoTickets(lottoTicketList);
        LottoCalculator lottoCalculator = new LottoCalculator(userInterface.strToIntList("1, 2, 3, 4, 5, 6"));
        int benefit = lottoCalculator.calculateResult(lottoTickets);
        assertThat(money.calEarningRate(benefit)).isEqualTo(35);
    }

}
