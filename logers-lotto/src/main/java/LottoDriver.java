import domain.LottoOrder;
import domain.Result;
import domain.WinningNumber;
import dto.InputResultDto;
import factory.ValidatorServiceFactory;
import validate.ValidatorService;
import view.InputView;
import view.OutputView;

import java.util.Optional;
import java.util.Scanner;

public class LottoDriver {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            startLotto(scanner, ValidatorServiceFactory.getInstance());
        }
    }

    private static void startLotto(Scanner scanner, ValidatorService validatorService){
        Optional<InputResultDto> inputResultDto = InputView.input(scanner, validatorService);
        if(inputResultDto.isEmpty()){
            System.out.println("다시 시작해주세요.");
            return;
        }

        LottoOrder lottoOrder = inputResultDto.get().getLottoOrder();
        WinningNumber winningNumber = inputResultDto.get().getWinningNumber();

        Result result = lottoOrder.getResult(winningNumber);

        OutputView.showResult(result);
    }
}
