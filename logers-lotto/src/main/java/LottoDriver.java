import dto.InputResultDto;
import factory.ValidatorServiceFactory;
import presentation.controller.LottoController;
import validate.ValidatorService;
import presentation.view.InputViewz;
import presentation.view.LottoResultOutputView;

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
        Optional<InputResultDto> inputResultDto = InputViewz.input(scanner, validatorService);
        if(inputResultDto.isEmpty()){
            System.out.println("다시 시작해주세요.");
            return;
        }

        LottoResultOutputView lottoResultOutputView = lottoController.getLottoResult(inputResultDto.get());
        lottoResultOutputView.print();
    }
}
