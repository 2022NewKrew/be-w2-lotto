package presentation.view;

import dto.PurchaseDto;
import validate.ValidatorService;

import java.util.Scanner;

public class PurchaseInputView implements InputView<PurchaseDto>{
    private final Scanner scanner;
    private final ValidatorService validatorService;

    public PurchaseInputView(Scanner scanner, ValidatorService validatorService) {
        this.scanner = scanner;
        this.validatorService = validatorService;
    }

    @Override
    public PurchaseDto input() {
        System.out.println("구입금액을 입력해 주세요.");
        PurchaseDto purchaseDto = new PurchaseDto(scanner.nextInt());
        validatorService.validatePurchaseAmount(purchaseDto.getPurchaseAmount());
        return purchaseDto;
    }
}
