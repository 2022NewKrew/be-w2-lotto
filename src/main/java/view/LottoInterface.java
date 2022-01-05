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

    public int inputLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public void printLottos(List<Lotto> lottos) {
        System.out.printf("%s개 구매했습니다.%n", lottos.size());
        lottos.forEach(lotto -> System.out.println(LottoToString(lotto)));
    }

    public Winning inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = Arrays.stream(scanner.nextLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableList());

        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = Integer.parseInt(scanner.nextLine());
        return new Winning(winningNumbers, bonusNumber);
    }

    private String LottoToString(Lotto lotto) {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");

        lotto.getNumbers().forEach(num -> joiner.add(num.toString()));
        return joiner.toString();
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

    private String PrizeToString(Prize prize) {
        if (prize == Prize.SECOND_BONUS)
            return String.format("%d개 일치, 보너스 볼 일 (%d원)", prize.getMatchCount(), prize.getMoney());

        return String.format("%d개 일치 (%d원)", prize.getMatchCount(), prize.getMoney());
    }
}
