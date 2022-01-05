package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoAutoGenerator implements LottoGenerable {

    @Override
    public Lotto generate() {
        List<Integer> clonedNumbers = new ArrayList<>(numbers);
        Collections.shuffle(clonedNumbers);
        return new Lotto(clonedNumbers.stream().limit(NUMBER_COUNT).collect(Collectors.toList()));
    }
}
