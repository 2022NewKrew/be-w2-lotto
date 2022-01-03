import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int NUM_OF_LOTTO_NUMBERS = 6;
    private static final List<Integer> LOTTO_NUMBERS = IntStream.range(1, 45).boxed().collect(Collectors.toList());
    private List<Integer> lotto = new ArrayList<>();

    Lotto() {
        List<Integer> lottoNumbers = LOTTO_NUMBERS;
        Collections.shuffle(lottoNumbers);
        for (int i = 0; i < NUM_OF_LOTTO_NUMBERS; i++) {
            this.lotto.add(lottoNumbers.get(i));
            Collections.sort(this.lotto);
        }
    }

    Lotto(String inputString) {
        List<String> winningLottoStrings = Arrays.asList(inputString.split(", "));
        List<Integer> winningLotto = winningLottoStrings.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        this.lotto = winningLotto;
    }

    public List<Integer> getLotto() {
        return this.lotto;
    }
    public static int getLength() { return NUM_OF_LOTTO_NUMBERS; }
}
