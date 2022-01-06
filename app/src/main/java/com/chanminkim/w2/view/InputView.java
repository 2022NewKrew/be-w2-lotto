package com.chanminkim.w2.view;

import com.chanminkim.w2.exception.*;
import com.chanminkim.w2.model.Lotto;
import com.chanminkim.w2.model.LottoNumber;
import com.chanminkim.w2.precondition.Precondition;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public int getPayment() {
        return loopUntilGetProperInput("\n구입금액을 입력해 주세요.", this::getOptionalPayment);
    }

    public Optional<Integer> getOptionalPayment() {
        try {
            int payment = Integer.parseInt(scanner.nextLine());
            Precondition.throwIf(payment < 0, new InvalidPaymentException(payment));
            return Optional.of(payment);
        } catch (NumberFormatException | InvalidPaymentException e) {
            System.out.println("구입금액은 0 이상의 정수여야 합니다. 다시 입력해주세요.");
        }
        return Optional.empty();
    }

    public Lotto getWinningLotto() {
        return loopUntilGetProperInput("\n지난 주 당첨 번호를 입력해 주세요.", this::getOptionalLotto);
    }

    private Lotto getLotto() {
        return new Lotto(Arrays.stream(scanner.nextLine().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    public int getBonusNumber() {
        return loopUntilGetProperInput("보너스 볼을 입력해 주세요.", this::getOptionalBonusNumber);
    }

    public Optional<Integer> getOptionalBonusNumber() {
        try {
            return Optional.of(Integer.parseInt(scanner.nextLine()));
        } catch (NumberFormatException | InvalidLottoNumberException e) {
            System.out.printf("보너스 볼 번호는 %d~%d 사이의 정수여야 합니다. 다시 입력해주세요.%n",
                    LottoNumber.LOTTO_NUMBER_RANGE.lowerEndpoint(),
                    LottoNumber.LOTTO_NUMBER_RANGE.upperEndpoint());
        }
        return Optional.empty();
    }

    public List<Lotto> getManualLottoList(int payment) {
        final int numberOfManualLotto = getNumberOfManualLotto(payment);
        if (numberOfManualLotto == 0) {
            return Collections.emptyList();
        }
        List<Lotto> manualLottoList = new ArrayList<>(numberOfManualLotto);
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < numberOfManualLotto; i++) {
            manualLottoList.add(getManualLotto());
        }
        return manualLottoList;
    }

    private Lotto getManualLotto() {
        return loopUntilGetProperInput(null, this::getOptionalLotto);
    }

    private Optional<Lotto> getOptionalLotto() {
        try {
            return Optional.of(getLotto());
        } catch (NumberFormatException | InvalidLottoNumberException e) {
            System.out.printf("로또 번호는 %d~%d 사이의 정수여야 합니다. 다시 입력해주세요.%n",
                    LottoNumber.LOTTO_NUMBER_RANGE.lowerEndpoint(),
                    LottoNumber.LOTTO_NUMBER_RANGE.upperEndpoint());
        } catch (InvalidLottoNumbersLengthException e) {
            System.out.printf("로또 번호의 갯수는 %d개여야 합니다. 다시 입력해주세요.%n", Lotto.NUMBERS_LENGTH);
        } catch (DuplicatedLottoNumberException e) {
            System.out.println("로또 번호는 중복이 될 수 없습니다. 다시 입력해주세요.");
        }
        return Optional.empty();
    }

    private int getNumberOfManualLotto(final int payment) {
        return loopUntilGetProperInput("\n수동으로 구매할 로또 수를 입력해 주세요.",
                () -> getOptionalNumberOfManualLotto(payment));
    }

    private <T> T loopUntilGetProperInput(String msg, Supplier<Optional<T>> function) {
        while (true) {
            if (msg != null) {
                System.out.println(msg);
            }
            Optional<T> optional = function.get();
            if (optional.isEmpty()) {
                continue;
            }
            return optional.get();
        }
    }

    private Optional<Integer> getOptionalNumberOfManualLotto(int payment) {
        try {
            int numberOfManualLotto = Integer.parseInt(scanner.nextLine());
            Precondition.throwIf(numberOfManualLotto < 0,
                    new InvalidLottoNumbersLengthException(numberOfManualLotto));
            int cost = numberOfManualLotto * Lotto.PRICE;
            Precondition.throwIf(payment < cost,
                    new InsufficientPaymentException(payment, cost));
            return Optional.of(numberOfManualLotto);
        } catch (NumberFormatException | InvalidLottoNumbersLengthException e) {
            System.out.println("0 이상의 정수만 입력 가능합니다. 다시 입력해주세요");
        } catch (InsufficientPaymentException e) {
            System.out.printf("최대 %d개 까지만 수동으로 구매할 수 있습니다. 다시 입력해주세요.%n", e.getPayment() / Lotto.PRICE);
        }
        return Optional.empty();
    }

}
