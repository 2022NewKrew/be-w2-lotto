package lotto.view;

import lotto.domain.LottoNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInput {
    public static final Scanner sc = new Scanner(System.in);

    public int moneyInput() {
        int money;
        System.out.println("구입금액을 입력해 주세요.");
        money = Integer.parseInt(sc.nextLine());
        return money;
    }

    public int selectCountInput() {
        int count;
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        count = Integer.parseInt(sc.nextLine());
        System.out.println();
        return count;
    }

    public void userInputLottoNumbers(List<LottoNumbers> lottoList, int generateCount) {
        LottoNumbers lottoNumbers;
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < generateCount; i++) {
            lottoNumbers = new LottoNumbers(Arrays.stream(sc.nextLine().split("\\s*,\\s*"))
                    .map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new)));
            lottoList.add(lottoNumbers);
        }
        System.out.println();
    }


    public ArrayList<Integer> winningNumbersInput() {
        ArrayList<Integer> winningNumbers;
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        winningNumbers = Arrays.stream(sc.nextLine().split("\\s*,\\s*"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
        return winningNumbers;
    }

    public int bonusNumberInput() {
        int bonusNumber;
        System.out.println("보너스 볼을 입력해 주세요");
        bonusNumber = Integer.parseInt(sc.nextLine());
        return bonusNumber;
    }
}
