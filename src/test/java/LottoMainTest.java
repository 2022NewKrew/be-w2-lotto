import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class LottoMainTest {
    @Test
    void map() {
        IntStream.range(3,7).forEach(i -> System.out.println(i));
    }

}