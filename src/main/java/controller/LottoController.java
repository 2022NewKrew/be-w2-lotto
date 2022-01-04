package controller;

import domain.*;
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
        Map<LottoRank, Integer> countOfMatches = new HashMap<>();

        for (Lotto lotto : lottoList) {
            LottoRank lottoRank = calculateLottoRank(lotto);

            if (lottoRank == null) {
                continue;
            }

            if (!countOfMatches.containsKey(lottoRank)) {
                countOfMatches.put(lottoRank, 0);
            }

            countOfMatches.put(lottoRank, countOfMatches.get(lottoRank) + 1);
        }

        setCountOfMatches(countOfMatches);
    }

    public LottoRank calculateLottoRank(Lotto lotto) {
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

    public LottoRank selectLottoMatch(int matches, boolean bonus) {
        switch (matches) {
            case 3:
                return LottoRank.ETC;
            case 4:
                return LottoRank.FOURTH;
            case 5:
                if (bonus) {
                    return LottoRank.SECOND;
                }

                return LottoRank.THIRD;
            case 6:
                return LottoRank.FIRST;
            default:
                return null;
        }
    }

    public boolean isBonusRank(List<Integer> numbers, int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public double calculateProfitRate() {
        long sum = sumLottoPrice();

        return (double) (sum - purchasePrice) / purchasePrice * 100;
    }

    public long sumLottoPrice() {
        long sum = 0;

        Set<LottoRank> lottoRankSet = lottoResult.getCountOfMatches().keySet();

        for (LottoRank lottoRank : lottoRankSet) {
            sum += lottoResult.getCountOfMatches().get(lottoRank);
        }

        return sum;
    }

    public void setWinningLottoNumbers(List<Integer> numbers) {
        winningLotto.setNumbers(numbers);
    }

    public void setCountOfMatches(Map<LottoRank, Integer> countOfMatches) {
        lottoResult.setCountOfMatches(countOfMatches);
    }

    public void setBonusNumber(int bonusNumber) {
        winningLotto.setBonusNumber(bonusNumber);
    }

    public void setProfitRate() {
        lottoResult.setProfitRate(calculateProfitRate());
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
