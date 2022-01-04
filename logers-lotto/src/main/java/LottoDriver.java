import dto.InputResultDto;
import factory.ValidatorServiceFactory;
import presentation.controller.LottoController;
import validate.ValidatorService;
import presentation.view.InputView;
import presentation.view.OutputView;

import java.util.Optional;
import java.util.Scanner;

public class LottoDriver {
    private static final LottoController lottoController = new LottoController();

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

        OutputView outputView = lottoController.getLottoResult(inputResultDto.get());
        outputView.showResult();
    }
}
