package controller;

import domain.Lotto;
import domain.LottoResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {
    public static final int LOTTO_PRICE = 1000;
    public static final List<Integer> LOTTO_AVAILABLE_NUMBERS = IntStream.range(1, 45).boxed().collect(Collectors.toList());

    private int purchasePrice;
    private int purchaseAmount;
    private List<Lotto> lottoList;
    private LottoResult lottoResult;

    public LottoController(int purchasePrice) {
        this.purchasePrice = purchasePrice;
        this.purchaseAmount = purchasePrice / LOTTO_PRICE;
        this.lottoList = generateLottoList();
    }

    public List<Lotto> generateLottoList() {
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < purchaseAmount; i++) {
            lottoList.add(generateLotto());
        }

        return lottoList;
    }

    public Lotto generateLotto() {
        Collections.shuffle(LOTTO_AVAILABLE_NUMBERS);
        List<Integer> lottoNumbers = LOTTO_AVAILABLE_NUMBERS.subList(0, 6);
        Collections.sort(lottoNumbers);

        return new Lotto(lottoNumbers);
    }

    public void setLottoResult(List<Integer> numbers) {
        lottoResult = new LottoResult(numbers);
    }
}
