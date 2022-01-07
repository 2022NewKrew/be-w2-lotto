package com.kakao.lotto.step3.view;

import com.kakao.lotto.step3.core.Lotto;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputLotto {

    public final static int LOTTO_PRICE = 1000;

    private Scanner scanner = new Scanner(System.in);

    private void checkNegative(int number) throws Exception {
        if(number < 0)
            throw new Exception("음수 발생");
    }

    private int inputPrice() throws Exception {
        System.out.println("구입 금액을 입력해주세요.");
        int price = Integer.parseInt(scanner.nextLine());
        checkNegative(price);
        return price;
    }

    // 구입 금액을 입력받습니다. 정수가 아니거나 음수를 입력받았을 경우 다시 입력받습니다.
    public int getLottoCount() {
        while(true) {
            try {
                return inputPrice() / LOTTO_PRICE;
            } catch (Exception exception) {
                System.out.println("0 이상의 정수를 입력하세요");
            }
        }
    }

    private void checkSize(List<Integer> lottoNumbers) throws Exception {
        if(lottoNumbers.size() != 6)
            throw new Exception("6개의 번호를 입력해주세요");
    }

    private void checkDuplicate(List<Integer> lottoNumbers) throws Exception {
        Set<Integer> lottoSet = new HashSet<>(lottoNumbers);
        if(lottoNumbers.size() != lottoSet.size())
            throw new Exception("중복 요소가 있습니다.");
    }

    private void checkLottoNumbers(List<Integer> lottoNumbers) throws RuntimeException {
        lottoNumbers.stream()
                .filter(number -> number < 1 || number > 45)
                .findAny()
                .ifPresent(it -> {
                    throw new RuntimeException();
                });
    }

    private List<Integer> inputLottoNumbers() throws Exception {
        List<Integer> lottoNumbers = Pattern.compile(", ").splitAsStream(scanner.nextLine())
                .map(string -> Integer.valueOf(string)).collect(Collectors.toList());
        checkSize(lottoNumbers);
        checkDuplicate(lottoNumbers);
        checkLottoNumbers(lottoNumbers);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    // 6개의 당첨 번호를 입력받습니다. 올바른 입력이 들어올 때까지 반복문을 돕니다.
    private List<Integer> getLottoNumbers() {
        while(true) {
            try {
                return inputLottoNumbers();
            } catch(Exception exception) {
                System.out.println("1 ~ 45 사이의 정수를 ', '로 구분해 중복되지 않게 6개 입력해주세요.");
            }
        }
    }

    public List<Integer> getWinningNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return getLottoNumbers();
    }

    private void checkBonusNumber(int number, List<Integer> winningNumbers) throws Exception {
        if(number < 1 || number > 45 || winningNumbers.contains(number))
            throw new Exception("당첨 번호에 존재하지 않는 1 ~ 45 사이의 수를 입력하시오");
    }

    private int inputBonusNumber(List<Integer> winningNumbers) throws Exception {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = Integer.parseInt(scanner.nextLine());
        checkBonusNumber(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    // 구입 금액을 입력받습니다. 정수가 아니거나 음수를 입력받았을 경우 다시 입력받습니다.
    public int getBonusNumber(List<Integer> winningNumbers) {
        while(true) {
            try {
                return inputBonusNumber(winningNumbers);
            } catch (Exception exception) {
                System.out.println("당첨 번호에 존재하지 않는 1 ~ 45 범위의 정수를 입력하세요");
            }
        }
    }

    private void checkManualLottoCount(int manualLottoCount, int lottoCount) throws Exception {
        if(manualLottoCount < 0 || manualLottoCount > lottoCount)
            throw new Exception("구매할 lotto 개수 이하인 음이 아닌 정수를 입력하세요.");
    }

    private int inputManualLottoCount(int lottoCount) throws Exception {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        int manualLottoCount = Integer.parseInt(scanner.nextLine());
        checkManualLottoCount(manualLottoCount, lottoCount);
        return manualLottoCount;
    }

    private int getManualLottoCount(int lottoCount) {
        while(true) {
            try {
                return inputManualLottoCount(lottoCount);
            } catch (Exception exception) {
                System.out.println("구매할 수 있는 lotto의 수보다 작은 값을 입력하세요");
            }
        }
    }

    private List<Lotto> inputManualLottos(int manualLottoCount) {
        if(manualLottoCount > 0)
            System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        return Stream.generate(() -> new Lotto(getLottoNumbers())).limit(manualLottoCount).collect(Collectors.toList());
    }

    public List<Lotto> getManualLottos(int lottoCount) {
        int manualLottoCount = getManualLottoCount(lottoCount);
        return inputManualLottos(manualLottoCount);
    }

}
