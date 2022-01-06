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

    List<String> setTestCase2() {
        List<String> testCase = new ArrayList<>();
        testCase.add("8, 21, 23, 41, 42, 43");
        return testCase;
    }

    List<String> setTestCase3() {
        List<String> testCase = new ArrayList<>();
        testCase.add("1, 2, 3, 4, 5, 7, 8");
        return testCase;
    }

    List<String> setTestCase4() {
        List<String> testCase = new ArrayList<>();
        testCase.add("1, 2, 3, 4, 5, 8, 9");
        return testCase;
    }

    List<String> setTestCase5() {
        List<String> testCase = new ArrayList<>();
        testCase.add("1, 2, 3, 4, 8, 9, 10");
        return testCase;
    }

    List<String> setTestCase6() {
        List<String> testCase = new ArrayList<>();
        testCase.add("1, 2, 3, 8, 9, 10, 11");
        return testCase;
    }

    List<String> setTestCase7() {
        List<String> testCase = new ArrayList<>();
        testCase.add("1, 2, 3, 8, 9, 10, 11");
        testCase.add("1, 2, 3, 8, 9, 10, 11");
        testCase.add("1, 2, 3, 8, 9, 10, 11");
        return testCase;
    }

    void benefitTestTemplate(String answerInput, int bonusNumberInput, List<String> testCase, int expectedResult) {
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        for (String str : testCase)
            lottoTicketList.add(new LottoTicket(LottoNumbers.getInstanceByIntList(userInterface.stringToIntList(str))));
        LottoTickets lottoTickets = new LottoTickets(lottoTicketList);
        LottoNumbers answers = LottoNumbers.getInstanceByIntList(userInterface.stringToIntList(answerInput));
        LottoNumber bonusNumber = new LottoNumber(answers, bonusNumberInput);
        LottoResult lottoResult = lottoTickets.calculateResult(answers, bonusNumber);
        int benefit = lottoResult.benefit();
        assertThat(benefit).isEqualTo(expectedResult);
    }


    @Test
    @DisplayName("로또_연산_결과_수익_테스트")
    void test_benefit() {
        benefitTestTemplate("1, 2, 3, 4, 5, 6", 7, setTestCase1(), 5000);
    }

    @Test
    @DisplayName("로또_연산_결과_수익_테스트_2")
    void test_benefit_2() {
        benefitTestTemplate("8, 21, 23, 41, 42, 43", 7, setTestCase2(), 2000000000);
    }

    @Test
    @DisplayName("로또_연산_결과_수익_테스트_5개_일치_보너스_볼_일치_1개")
    void test_benefit_3() {
        benefitTestTemplate("1, 2, 3, 4, 5, 6", 7, setTestCase3(), 30000000);
    }

    @Test
    @DisplayName("로또_연산_결과_수익_테스트_5개_일치")
    void test_benefit_4() {
        benefitTestTemplate("1, 2, 3, 4, 5, 6", 7, setTestCase4(), 1500000);
    }

    @Test
    @DisplayName("로또_연산_결과_수익_테스트_4개_일치")
    void test_benefit_5() {
        benefitTestTemplate("1, 2, 3, 4, 5, 6", 7, setTestCase5(), 50000);
    }

    @Test
    @DisplayName("로또_연산_결과_수익_테스트_3개_일치")
    void test_benefit_6() {
        benefitTestTemplate("1, 2, 3, 4, 5, 6", 7, setTestCase6(), 5000);
    }

    @Test
    @DisplayName("로또_연산_결과_수익_테스트_3개_일치_3개")
    void test_benefit_7() {
        benefitTestTemplate("1, 2, 3, 4, 5, 6", 7, setTestCase7(), 15000);
    }


    @Test
    @DisplayName("로또_연산_결과_수익률_테스트")
    void test_earningResult() {
        String ANSWER_INPUT = "1, 2, 3, 4, 5, 6";
        int bonusNumberInput = 7;
        List<String> testCase1 = setTestCase1();
        Money money = new Money(LottoTicket.PRICE * testCase1.size());
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        for (String str : testCase1)
            lottoTicketList.add(new LottoTicket(LottoNumbers.getInstanceByIntList(userInterface.stringToIntList(str))));
        LottoTickets lottoTickets = new LottoTickets(lottoTicketList);
        LottoNumbers answers = LottoNumbers.getInstanceByIntList(userInterface.stringToIntList(ANSWER_INPUT));
        LottoNumber bonusNumber = new LottoNumber(answers, bonusNumberInput);
        LottoResult lottoResult = lottoTickets.calculateResult(answers, bonusNumber);
        int benefit = lottoResult.benefit();
        assertThat(money.earningRate(benefit)).isEqualTo(35);
    }


}
