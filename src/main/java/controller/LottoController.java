package controller;

import domain.Lotto;
import domain.LottoMatch;
import domain.LottoResult;
import domain.WinningLotto;
import exception.LottoPurchasePriceException;
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
    private WinningLotto winningLotto;
    private LottoResult lottoResult;
    private LottoView lottoView;

    public LottoController(int purchasePrice) {
        validatePurchasePrice(purchasePrice);
        this.purchasePrice = purchasePrice;
        this.purchaseAmount = purchasePrice / LOTTO_PRICE;
        this.lottoList = generateLottoList();
        this.winningLotto = new WinningLotto();
        this.lottoResult = new LottoResult();
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
        Map<LottoMatch, Integer> countOfMatches = new HashMap<>();

        for (Lotto lotto : lottoList) {
            LottoMatch lottoMatch = calculateLottoMatch(lotto);

            if (!countOfMatches.containsKey(lottoMatch)) {
                countOfMatches.put(lottoMatch, 0);
            }

            countOfMatches.put(lottoMatch, countOfMatches.get(lottoMatch) + 1);
        }

        setCountOfMatches(countOfMatches);
    }

    public LottoMatch calculateLottoMatch(Lotto lotto) {
        int matches = 0;
        boolean bonus = false;

        for (Integer target : winningLotto.getNumbers()) {
            if (lotto.getNumbers().contains(target)) {
                matches += 1;
            }
        }

        if (matches == 5) {
            if (isBonusRank(lotto.getNumbers(), winningLotto.getBonusNumber())) {
                bonus = true;
            }
        }

        return selectLottoMatch(matches, bonus);
    }

    public LottoMatch selectLottoMatch(int matches, boolean bonus) {
        switch (matches) {
            case 4:
                return LottoMatch.FOURTH;
            case 5:
                if (bonus) {
                    return LottoMatch.SECOND;
                }

                return LottoMatch.THIRD;
            case 6:
                return LottoMatch.FIRST;
            default:
                return LottoMatch.ETC;
        }
    }


    public boolean isBonusRank(List<Integer> numbers, int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public void setWinningLottoNumbers(List<Integer> numbers) {
        winningLotto.setNumbers(numbers);
    }

    public void setCountOfMatches(Map<LottoMatch, Integer> countOfMatches) {
        lottoResult.setCountOfMatches(countOfMatches);
    }

    public void setBonusNumber(int bonusNumber) {
        winningLotto.setBonusNumber(bonusNumber);
    }

    public void printPurchaseAmount() {
        lottoView.printPurchaseAmount(purchaseAmount);
    }

    public void printLottoNumbers() {
        lottoView.printLottoNumbers(lottoList);
    }

    public void printResult() {
        lottoView.printLottoStatistics(lottoResult);
    }

    public void validatePurchasePrice(int purchasePrice) {
        if (purchasePrice < LOTTO_PRICE) {
            throw new LottoPurchasePriceException("1000원 이상으로 구입하여야 합니다.");
        }
    }
}
