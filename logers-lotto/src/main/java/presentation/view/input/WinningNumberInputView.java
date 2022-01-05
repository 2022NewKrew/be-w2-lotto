package presentation.view.input;

<<<<<<< HEAD
import dto.input.WinningNumbersDto;
=======
import dto.input.WinningNumberDto;
import validate.ValidatorService;
>>>>>>> a030324 (refactor : 구조개선)

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

<<<<<<< HEAD
public class WinningNumberInputView implements InputView<WinningNumbersDto> {
    private final Scanner scanner;

    public WinningNumberInputView(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public WinningNumbersDto input() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> winNumbers = Arrays.stream(scanner.next().split(","))
                .map(numberString -> Integer.parseInt(numberString.trim()))
                .collect(toList());

        System.out.println("보너스 볼을 입력해주세요");
        Integer bonusNumber = scanner.nextInt();

        return new WinningNumbersDto(winNumbers, bonusNumber);
=======
public class WinningNumberInputView implements InputView<WinningNumberDto> {
    private final Scanner scanner;
    private final ValidatorService validatorService;

    public WinningNumberInputView(Scanner scanner, ValidatorService validatorService) {
        this.scanner = scanner;
        this.validatorService = validatorService;
    }

    @Override
    public WinningNumberDto input() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> winNumbers = Arrays.stream(scanner.next()
                        .split(","))
                .map(numberString -> Integer.parseInt(numberString.trim()))
                .collect(toList());

        validatorService.validateWinNumbers(winNumbers);

        return new WinningNumberDto(winNumbers);
>>>>>>> a030324 (refactor : 구조개선)
    }
}
