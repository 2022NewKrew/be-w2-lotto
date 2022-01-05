package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import valid.ConditionCheck;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AutoLottoGeneratorTest {

    LottoGenerator lottoGenerator = new AutoLottoGenerator();
    AssertionError exc = null;

    public class MyThread extends Thread {
        @Override
        public void run() {
            for (int j = 0; j < 1000; j++) {
                List<Integer> list = lottoGenerator.getLottoTicket().getLottoNumbers();

                try {
                    assertTrue(ConditionCheck.isValidLottoNumber(list));
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
        List<MyThread> list = new ArrayList<>();
        //when
        for (int i = 0; i < 100; i++) {
            list.add(new MyThread());
            list.get(i).start();
        }

        for (int i = 0; i < 100; i++) {
            list.get(i).join();
        }

        //then
        if(exc != null)
            throw exc;
    }
}