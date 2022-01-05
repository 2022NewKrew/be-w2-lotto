package presentation.view.input;

import dto.input.PurchaseDto;
<<<<<<< HEAD
=======
import validate.ValidatorService;
>>>>>>> a030324 (refactor : 구조개선)

import java.util.Scanner;

public class PurchaseInputView implements InputView<PurchaseDto> {
    private final Scanner scanner;
<<<<<<< HEAD

    public PurchaseInputView(Scanner scanner) {
        this.scanner = scanner;
=======
    private final ValidatorService validatorService;

    public PurchaseInputView(Scanner scanner, ValidatorService validatorService) {
        this.scanner = scanner;
        this.validatorService = validatorService;
>>>>>>> a030324 (refactor : 구조개선)
    }

    @Override
    public PurchaseDto input() {
        System.out.println("구입금액을 입력해 주세요.");
<<<<<<< HEAD
        return new PurchaseDto(scanner.nextInt());
=======
        PurchaseDto purchaseDto = new PurchaseDto(scanner.nextInt());
        validatorService.validatePurchaseAmount(purchaseDto.getPurchaseAmount());
        return purchaseDto;
>>>>>>> a030324 (refactor : 구조개선)
    }
}
