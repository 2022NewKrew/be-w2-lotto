package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import valid.ConditionCheck;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AutoLottoGeneratorTest {

    private final LottoGenerator lottoGenerator = new AutoLottoGenerator();
    private AssertionError exc = null;

    private class MyThread extends Thread {
        @Override
        public void run() {
            for (int j = 0; j < 1000; j++) {
                List<Integer> lottoNumbers = lottoGenerator.getLottoTicket().getLottoNumbers();

                try {
                    assertThat(ConditionCheck.isValidLottoNumber(lottoNumbers)).isTrue();
                } catch (AssertionError e) {
                    exc = e;
                }
            }
        }
    }

    @DisplayName("Auto 로또 생성 멀티쓰레드 안정성 확인")
    @Test
    void getLottoTicket() throws InterruptedException {
        //given
        List<MyThread> threads = new ArrayList<>();
        //when
        for (int i = 0; i < 100; i++) {
            threads.add(new MyThread());
            threads.get(i).start();
        }

        for (int i = 0; i < 100; i++) {
            threads.get(i).join();
        }

        //then
        if(exc != null)
            throw exc;
    }
}