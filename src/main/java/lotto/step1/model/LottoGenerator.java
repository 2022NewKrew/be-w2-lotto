package lotto.step1.model;

import lotto.step1.dto.request.LottoPurchaseSheetDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private final List<Integer> totalLottoNumbers;

    public LottoGenerator() {
        final int minNumber = 1;
        final int maxNumber = 45;

        this.totalLottoNumbers = IntStream.rangeClosed(minNumber, maxNumber)
                .boxed()
                .collect(Collectors.toList());
    }

    public Lotto generate(LottoPurchaseSheetDTO lottoPurchaseSheetDTO) {
        final int PRICE = 1000;
        final int count = lottoPurchaseSheetDTO.getPurchaseAmount() / PRICE;

        final List<LottoNumbers> purchasedLottoNumbersList = IntStream.range(0, count)
                .mapToObj(i -> generateNumbers())
                .collect(Collectors.toList());

        return new Lotto(purchasedLottoNumbersList);
    }

    private LottoNumbers generateNumbers() {
        final int maxNumbers = 6;

        Collections.shuffle(totalLottoNumbers);
        final List<Integer> pickedLottoNumbers = new ArrayList<>(totalLottoNumbers.subList(0, maxNumbers));

        return new LottoNumbers(pickedLottoNumbers);
    }
}