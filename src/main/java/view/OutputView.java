package view;

import domain.buyer.Yield;
import domain.lotto.Lotto;
import domain.lotto.Number;
import domain.result.Result;
import domain.result.Winning;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static class LazyHolder {
        public static final OutputView INSTANCE = new OutputView();
    }

    private OutputView() {
    }

    public static OutputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void showLottoNumbers(List<Lotto> lottos) {
        lottos.stream()
                .map(this::convertLottoNumber)
                .forEach(System.out::println);
    }

    public String convertLottoNumber(Lotto lotto) {
        return lotto.getLottoNumbers()
                .stream()
                .map(Number::getNumber)
                .map(n -> Integer.toString(n))
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public void showTotalHitting(List<Integer> hittingTable, int startIdx, int endIdx, Yield yield) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        for (int i = startIdx; i <= endIdx; i++) {
            System.out.print(i + "개 일치 ");
            System.out.print("(" + Winning.priceOfHitting(i) + "원)");
            System.out.println("- " + hittingTable.get(i) + "개");
        }
        showYield(yield);
    }

    public void showYield(Yield yield) {
        System.out.println("총 수익률은 " + yield.getYield() + "%입니다.");
    }

    public void completeBuying(int cnt) {
        System.out.println(cnt + "개를 구매했습니다.");
    }
}
