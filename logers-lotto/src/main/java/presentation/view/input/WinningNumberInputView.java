package presentation.view.input;

import dto.input.WinningNumbersDto;
import validate.ValidatorService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class WinningNumberInputView implements InputView<WinningNumbersDto> {
    private final Scanner scanner;
    private final ValidatorService validatorService;

    public WinningNumberInputView(Scanner scanner, ValidatorService validatorService) {
        this.scanner = scanner;
        this.validatorService = validatorService;
    }

    @Override
    public WinningNumbersDto input() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> winNumbers = Arrays.stream(scanner.next()
                        .split(","))
                .map(numberString -> Integer.parseInt(numberString.trim()))
                .collect(toList());

        validatorService.validateWinNumbers(winNumbers);

        return new WinningNumbersDto(winNumbers);
    }
}
