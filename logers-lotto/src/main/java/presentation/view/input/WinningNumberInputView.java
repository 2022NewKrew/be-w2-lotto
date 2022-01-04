package presentation.view.input;

import dto.input.WinningNumbersDto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class WinningNumberInputView implements InputView<WinningNumbersDto> {
    private final Scanner scanner;

    public WinningNumberInputView(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public WinningNumbersDto input() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> winNumbers = Arrays.stream(scanner.next()
                        .split(","))
                .map(numberString -> Integer.parseInt(numberString.trim()))
                .collect(toList());

        return new WinningNumbersDto(winNumbers);
    }
}
