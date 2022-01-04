package presentation.view.input;

import dto.input.PurchaseDto;

import java.util.Scanner;

public class PurchaseInputView implements InputView<PurchaseDto> {
    private final Scanner scanner;

    public PurchaseInputView(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public PurchaseDto input() {
        System.out.println("구입금액을 입력해 주세요.");
        return new PurchaseDto(scanner.nextInt());
    }
}
