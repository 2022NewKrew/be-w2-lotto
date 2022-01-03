package util;

import lotto.util.CustomScanner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class CustomScannerTests {
    static InputStream sysInBackup = System.in;

    @AfterAll
    static void afterAll() {
        System.setIn(sysInBackup);
    }

    @Test
    void getMoneyTest() {
        ByteArrayInputStream in = new ByteArrayInputStream("14000".getBytes());
        System.setIn(in);

        CustomScanner customScanner = new CustomScanner();

        customScanner.getMoney();
    }

    @Test
    void getWinningNumbersTest() {
        ByteArrayInputStream in = new ByteArrayInputStream("1, 2, 3, 4, 5, 6".getBytes());
        System.setIn(in);

        CustomScanner customScanner = new CustomScanner();

        customScanner.getWinningNumbers();
    }
}
