package presentation.view;

import domain.LottoOrder;
import domain.WinningNumber;
import dto.InputResultDto;
import factory.LottoOrderFactory;
import validate.ValidatorService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class InputView {
    public static Optional<InputResultDto> input(Scanner scanner, ValidatorService validatorService){
        try {
            return Optional.of(inputResultDto(scanner, validatorService));
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
            return Optional.empty();
        }
    }

    private static InputResultDto inputResultDto(Scanner scanner, ValidatorService validatorService){
        int purchaseAmount = inputPrice(scanner, validatorService);
        LottoOrder lottoOrder = LottoOrderFactory.createLottoOrder(purchaseAmount);
        System.out.println(lottoOrder);

        WinningNumber winningNumber = new WinningNumber(inputWinNumbers(scanner, validatorService));

        return new InputResultDto(lottoOrder, winningNumber);
    }

    private static int inputPrice(Scanner scanner, ValidatorService validatorService){
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = scanner.nextInt();
        validatorService.validatePurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }

    private static List<Integer> inputWinNumbers(Scanner scanner, ValidatorService validatorService){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        List<Integer> winNumbers = Arrays.stream(scanner.next()
                .split(","))
                .map(numberString -> Integer.parseInt(numberString.trim()))
                .collect(toList());

        validatorService.validateWinNumbers(winNumbers);
        return winNumbers;
    }
}
