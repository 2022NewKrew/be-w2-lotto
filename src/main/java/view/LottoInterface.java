package view;

import domain.Lotto;
import domain.Prize;
import domain.Result;
import domain.Winning;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class LottoInterface {
    private static final Scanner scanner = new Scanner(System.in);

    public int inputNumber() {
        return Integer.parseInt(scanner.nextLine());
    }

    public List<Integer> inputNumbers() {
        return Arrays.stream(scanner.nextLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableList());
    }

    public void printBoughtAmount(int amountManual, int amountAuto) {
        System.out.printf("수동으로 %d장, 자동으로 %d장 구매했습니다.%n", amountManual, amountAuto);
    }

    public void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(LottoToString(lotto)));
    }

    public void printGuide(Guide guide) {
        System.out.println(guide);
    }

    public Winning inputWinningNumbers() {
        printGuide(Guide.INPUT_WINNING_NUMS);
        List<Integer> winningNumbers = inputNumbers();

        printGuide(Guide.INPUT_WINNING_BONUS);
        int bonusNumber = Integer.parseInt(scanner.nextLine());
        return new Winning(winningNumbers, bonusNumber);
    }

    public void printResults(List<Result> results) {
        final String outFormat = "%s- %d개";
        results.forEach(result -> System.out.printf((outFormat) + "%n", PrizeToString(result.getPrize()), result.getCount()));
    }

    public void printEarningRate(int cost, List<Result> results) {
        long prizeMoneySum = results.stream().mapToInt(Result::getPrizeMoney).sum();
        int earningRate = (int) Math.floor((double) (prizeMoneySum - cost) / cost * 100);

        System.out.printf("총 수익률은 %d%%입니다.%n", earningRate);
    }

    private String LottoToString(Lotto lotto) {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");

        lotto.getNumbers().forEach(num -> joiner.add(num.toString()));
        return joiner.toString();
    }

    private String PrizeToString(Prize prize) {
        if (prize == Prize.SECOND_BONUS)
            return String.format("%d개 일치, 보너스 볼 일 (%d원)", prize.getMatchCount(), prize.getMoney());

        return String.format("%d개 일치 (%d원)", prize.getMatchCount(), prize.getMoney());
    }
}
