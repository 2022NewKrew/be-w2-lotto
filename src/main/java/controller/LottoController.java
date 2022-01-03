package controller;

import domain.Lotto;
import domain.LottoResult;
import view.LottoView;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {
    public static final int LOTTO_PRICE = 1000;
    public static final List<Integer> LOTTO_AVAILABLE_NUMBERS = IntStream.range(1, 45).boxed().collect(Collectors.toList());

    private int purchasePrice;
    private int purchaseAmount;
    private List<Lotto> lottoList;
    private LottoResult lottoResult;
    private LottoView lottoView;

    public LottoController(int purchasePrice) {
        this.purchasePrice = purchasePrice;
        this.purchaseAmount = purchasePrice / LOTTO_PRICE;
        this.lottoList = generateLottoList();
        this.lottoView = new LottoView();
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

        return new Lotto(new ArrayList<>(lottoNumbers));
    }

    public void generateLottoResult() {
        Map<Integer, Integer> countOfMatches = new HashMap<>();

        for (Lotto lotto : lottoList) {
            int countNumber = countNumberOfMatches(lotto);

            if (!countOfMatches.containsKey(countNumber)) {
                countOfMatches.put(countNumber, 0);
            }

            countOfMatches.put(countNumber, countOfMatches.get(countNumber) + 1);
        }

        lottoResult.setCountOfMatches(countOfMatches);
    }

    public int countNumberOfMatches(Lotto lotto) {
        int matches = 0;

        for (Integer target : lottoResult.getNumbers()) {
            if (lotto.getNumbers().contains(target)) {
                matches += 1;
            }
        }

        return matches;
    }

    public void setLottoResult(List<Integer> numbers) {
        lottoResult = new LottoResult(numbers);
    }

    public void printPurchaseAmount() {
        lottoView.printPurchaseAmount(purchaseAmount);
    }

    public void printResult() {
        lottoView.printLottoStatistics(lottoResult);
    }
}
