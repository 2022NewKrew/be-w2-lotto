package presentation.view;

import domain.LottoOrder;
import domain.WinningNumber;
import dto.InputResultDto;
import factory.LottoOrderFactory;
import validate.ValidatorService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class InputViewz {
    public static Optional<InputResultDto> input(Scanner scanner, ValidatorService validatorService){
        try {
            return Optional.of(inputResultDto(scanner, validatorService));
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
            return Optional.empty();
        }
    }

    private static InputResultDto inputResultDto(Scanner scanner, ValidatorService validatorService){
        int purchaseAmount = new PurchaseInputView(scanner, validatorService).input().getPurchaseAmount();
        LottoOrder lottoOrder = LottoOrderFactory.createLottoOrder(purchaseAmount);
        System.out.println(lottoOrder);


        List<Integer> numbers =  new WinningNumberInputView(scanner, validatorService).input().getWinningNumbers();
        WinningNumber winningNumber = new WinningNumber(numbers);
        return new InputResultDto(lottoOrder, winningNumber);
    }
}
