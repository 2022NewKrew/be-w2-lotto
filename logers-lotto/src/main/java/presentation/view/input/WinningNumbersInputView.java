package presentation.view.input;

import dto.input.WinningNumbersDto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class WinningNumbersInputView implements InputView<WinningNumbersDto> {
    private final Scanner scanner;

    public WinningNumbersInputView(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public WinningNumbersDto input() {
        List<Integer> winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber();

        return new WinningNumbersDto(winningNumbers, bonusNumber);
    }

    private List<Integer> inputWinningNumbers(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Arrays.stream(scanner.next().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());
    }

    private int inputBonusNumber(){
        System.out.println("보너스 볼을 입력해주세요");
        return scanner.nextInt();
    }
}
