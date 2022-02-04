package database;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoPaper {
    private static LottoPaper lottoPaper = null;
    private final List<LottoNumbers> myLottoPaper;

    private LottoPaper() {
        myLottoPaper = new ArrayList<>();
    }

    public static LottoPaper getLottoPaper() {
        if (lottoPaper == null) {
            lottoPaper = new LottoPaper();
        }
        return lottoPaper;
    }

    public void insert(List<Integer> numbers) {
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);
        myLottoPaper.add(lottoNumbers);
    }

    public List<List<Integer>> findAll() {
        return myLottoPaper.stream()
                .map(LottoNumbers::getNumbers)
                .collect(Collectors.toList());
    }
}
