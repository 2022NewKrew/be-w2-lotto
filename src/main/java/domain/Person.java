package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Person {
    private static final int LOTTO_PRICE = 1000;
    private static final List<Integer> LOTTO_WINNINGS = Arrays.asList(0, 0, 0, 5000, 50000, 1500000, 30000000, 2000000000);

    private final int spendPrice;
    private final int lottoCount;
    private int incomeRate;
    private int income = 0;

    private List<Integer> correctList;
    private final List<Lotto> lottoList;

    public Person(int inputPrice) {
        this.spendPrice = inputPrice;
        this.lottoCount = inputPrice / LOTTO_PRICE;
        this.lottoList = createLottoList();
    }

    private List<Lotto> createLottoList() {
        return IntStream.range(0, lottoCount).mapToObj(s -> new Lotto()).collect(Collectors.toList());
    }

    public void setLottoResult() {
        correctList = new ArrayList<>();
        IntStream.range(0, LOTTO_WINNINGS.size()).forEach(s -> correctList.add(0));
        lottoList.stream().map(Lotto::compareLottoNumbers).forEach((correctCount) -> correctList.set(correctCount, correctList.get(correctCount) + 1));
        calcIncomeRate();
    }

    public void calcIncomeRate() {
        for (int i = 0; i < LOTTO_WINNINGS.size(); i++) {
            income += LOTTO_WINNINGS.get(i) * correctList.get(i);
        }
        this.incomeRate = (income / spendPrice) * 100;
    }

    public int getIncomeRate() {
        return incomeRate;
    }

    public List<Integer> getCorrectList() {
        return correctList;
    }

    public List<Integer> getLottoWinnings() {
        return LOTTO_WINNINGS;
    }

    public List<Lotto> getLottoList(){
        return lottoList;
    }
}
