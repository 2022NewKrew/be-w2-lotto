import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ticket {
    private static final int NUM_OF_LOTTO_NUMBERS = 6;
    private static final List<Integer> LOTTO_NUMBERS = IntStream.range(1, 45).boxed().collect(Collectors.toList());
    protected List<Integer> selectedNumbers = new ArrayList<>();

    Ticket() {
        List<Integer> lottoNumbers = LOTTO_NUMBERS;
        Collections.shuffle(lottoNumbers);
        for (int i = 0; i < NUM_OF_LOTTO_NUMBERS; i++) {
            this.selectedNumbers.add(lottoNumbers.get(i));
            Collections.sort(this.selectedNumbers);
        }
    }



    public List<Integer> getSelectedNumbers() {
        return this.selectedNumbers;
    }
    public static int getLength() { return NUM_OF_LOTTO_NUMBERS; }
}
