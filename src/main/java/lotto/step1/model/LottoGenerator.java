package lotto.step1.model;

import lotto.step1.dto.request.LottoPurchaseSheetDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    protected final List<Integer> totalLottoNumbers;

    public LottoGenerator() {
        final int minNumber = 1;
        final int maxNumber = 45;

        this.totalLottoNumbers = IntStream.rangeClosed(minNumber, maxNumber)
                .boxed()
                .collect(Collectors.toList());
    }

    public Lotto generate(LottoPurchaseSheetDTO lottoPurchaseSheetDTO) {
        final List<LottoNumbers> purchasedLottoNumbersList = generateLottoNumbersList(lottoPurchaseSheetDTO);
        return new Lotto(purchasedLottoNumbersList);
    }

    protected List<LottoNumbers> generateLottoNumbersList(LottoPurchaseSheetDTO lottoPurchaseSheetDTO) {
        final int PRICE = 1000;
        final int count = lottoPurchaseSheetDTO.getPurchaseAmount() / PRICE;

        return IntStream.range(0, count)
                .mapToObj(i -> generateLottoNumbers())
                .collect(Collectors.toList());
    }

    protected LottoNumbers generateLottoNumbers() {
        final List<Integer> randomNumbers = generateRandomNumbers();
        return new LottoNumbers(randomNumbers);
    }

    protected List<Integer> generateRandomNumbers() {
        final int maxNumbers = 6;

        Collections.shuffle(totalLottoNumbers);
        return new ArrayList<>(totalLottoNumbers.subList(0, maxNumbers));
    }
}