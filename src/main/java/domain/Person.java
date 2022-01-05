package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Person {
    private static final int LOTTO_PRICE = 1000;

    private final int spendPrice;
    private final int autoLottoCount;
    private int incomeRate;

    private final List<Lotto> lottoList;

    public Person(int inputPrice) {
        checkInputPrice(inputPrice);

        this.spendPrice = inputPrice;
        this.autoLottoCount = inputPrice / LOTTO_PRICE;
        this.lottoList = createLottoList();
    }

    public Person(int inputPrice, List<String> manualInput) {
        this.spendPrice = inputPrice;
        this.autoLottoCount = inputPrice / LOTTO_PRICE - manualInput.size();

        checkValidManualLottoCount(inputPrice, manualInput);
        this.lottoList = createLottoList();

        List<Lotto> manualLottoList = manualInput.stream().map(Lotto::new).collect(Collectors.toList());
        this.lottoList.addAll(manualLottoList);
    }

    private void checkInputPrice(int inputPrice) {
        System.out.println(inputPrice);
        if (inputPrice < LOTTO_PRICE) {
            throw new IllegalArgumentException("구입금액은 1000원 이상이여야 합니다.");
        }
    }

    private void checkValidManualLottoCount(int inputPrice, List<String> manualInput) {
        int manualLottoCount = manualInput.size();
        int maxLottoCount = inputPrice / LOTTO_PRICE;
        if (manualLottoCount > maxLottoCount) {
            throw new IllegalArgumentException("수동 복권 구매는 " + maxLottoCount + "개 이상 할 수 없습니다.");
        }
    }

    private List<Lotto> createLottoList() {
        return IntStream.range(0, autoLottoCount).mapToObj(s -> new Lotto()).collect(Collectors.toList());
    }

    public void setLottoResult() {
        lottoList.forEach(Lotto::compareLottoNumbers);
        calcIncomeRate();
    }

    public void calcIncomeRate() {
        this.incomeRate = (int) ((double) (Rank.getIncome() - spendPrice) / (double) spendPrice * 100);
    }

    public int getIncomeRate() {
        return incomeRate;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int getAutoLottoCount() {
        return autoLottoCount;
    }
}
