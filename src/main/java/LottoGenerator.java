import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private final List<Integer> lottoNumbers;

    public LottoGenerator() {
        lottoNumbers = IntStream.range(1, 46).boxed().collect(Collectors.toList());
    }

    public Lotto createLotto(){
        Collections.shuffle(lottoNumbers);
        List<Integer> randomLottoNumber = new ArrayList<>(lottoNumbers.subList(0, 6));
        Collections.sort(randomLottoNumber);

        return new Lotto(randomLottoNumber);
    }
}
