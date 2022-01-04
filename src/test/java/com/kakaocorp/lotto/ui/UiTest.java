package com.kakaocorp.lotto.ui;

import com.kakaocorp.lotto.domain.LottoDispenser;
import com.kakaocorp.lotto.domain.ProfitCalculator;
import com.kakaocorp.lotto.domain.ResultCounter;
import com.kakaocorp.lotto.model.Rule;
import com.kakaocorp.lotto.test.StringInputStream;
import com.kakaocorp.lotto.test.StringPrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UiTest {

    private static final long RANDOM_SEED = 1234L;

    private LottoDispenser dispenser;
    private ProfitCalculator calculator;
    private ResultCounter counter;
    private PrintStream out;
    private LottoPresenter presenter;

    @BeforeEach
    void setUp() {
        Random random = new Random(RANDOM_SEED);
        Rule rule = new Rule.Builder()
                .minNumber(1)
                .maxNumber(45)
                .numberCount(6)
                .price(1000)
                .random(random)
                .build();
        dispenser = new LottoDispenser(rule);
        calculator = new ProfitCalculator();
        counter = new ResultCounter();
    }

    @Test
    void onStart() {
        initialize("5000\n1, 5,7, 12, 26,27\n7");

        presenter.onStart();

        String expected = "구입금액을 입력해 주세요.\n" +
                "5개를 구매했습니다.\n" +
                "[17, 18, 22, 30, 31, 41]\n" +
                "[2, 3, 6, 14, 22, 29]\n" +
                "[1, 5, 7, 12, 26, 27]\n" +
                "[3, 4, 12, 18, 35, 40]\n" +
                "[4, 7, 17, 25, 26, 43]\n" +
                "지난 주 당첨 번호를 입력해 주세요.\n" +
                "보너스 볼을 입력해 주세요.\n" +
                "당첨 통계\n" +
                "---------\n" +
                "3개 일치 (5000원)- 0개\n" +
                "4개 일치 (50000원)- 0개\n" +
                "5개 일치 (1500000원)- 0개\n" +
                "5개 일치, 보너스 볼 일치 (30000000원)- 0개\n" +
                "6개 일치 (2000000000원)- 1개\n" +
                "총 수익률은 40000000%입니다.\n";
        assertEquals(expected, out.toString());
    }

    private void initialize(@SuppressWarnings("SameParameterValue") String input) {
        InputStream in = new StringInputStream(input.getBytes(StandardCharsets.UTF_8));
        out = new StringPrintStream();
        LottoView view = new StreamLottoView(in, out);
        presenter = new LottoPresenter(view, dispenser, counter, calculator);
    }
}
