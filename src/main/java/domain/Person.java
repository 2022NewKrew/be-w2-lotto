package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Person {
    private static final int LOTTO_PRICE = 1000;

    private final int spendPrice;
    private final int lottoCount;
    private int incomeRate;

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
        lottoList.forEach(Lotto::compareLottoNumbers);
        calcIncomeRate();
    }

    public void calcIncomeRate() {
        this.incomeRate = (int)((double)(Rank.getIncome() - spendPrice)/(double)spendPrice * 100);
    }

    public int getIncomeRate() {
        return incomeRate;
    }

    public List<Lotto> getLottoList(){
        return lottoList;
    }
}
