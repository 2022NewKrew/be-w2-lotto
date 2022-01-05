package com.chanminkim.w2.view;

import com.chanminkim.w2.model.Lotto;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public int getPayment() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public List<Integer> getWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return getLottoNumbers();
    }

    private List<Integer> getLottoNumbers() {
        return Arrays.stream(scanner.nextLine().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public List<Lotto> getManualLottoList(int payment) {
        int numberOfManualLotto = getNumberOfManualLotto(payment);
        if (numberOfManualLotto == 0) {
            return Collections.emptyList();
        }
        List<Lotto> manualLottoList = new ArrayList<>(numberOfManualLotto);
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < numberOfManualLotto; i++) {
            manualLottoList.add(new Lotto(getLottoNumbers()));
        }
        return manualLottoList;
    }

    private int getNumberOfManualLotto(int payment) {
        while (true) {
            System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
            int numberOfManualLotto = Integer.parseInt(scanner.nextLine());
            if (payment < numberOfManualLotto * Lotto.PRICE) {
                System.out.printf("최대 %d개 까지만 수동으로 구매할 수 있습니다. 다시 입력해주세요.%n", payment / Lotto.PRICE);
                continue;
            }
            return numberOfManualLotto;
        }
    }
}
