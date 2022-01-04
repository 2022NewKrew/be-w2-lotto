import dto.input.PurchaseDto;
import dto.input.WinningNumberDto;
import factory.ValidatorServiceFactory;
import presentation.controller.LottoController;
import presentation.view.input.PurchaseInputView;
import presentation.view.input.WinningNumberInputView;
import presentation.view.output.PurchaseOutputView;
import presentation.view.output.ResultOutputView;
import validate.ValidatorService;

import java.util.Scanner;

public class LottoDriver {
    private static final LottoController lottoController = new LottoController();

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            startLotto(scanner, ValidatorServiceFactory.getInstance());
        }
    }

    private static void startLotto(Scanner scanner, ValidatorService validatorService){
        PurchaseDto purchaseDto = new PurchaseInputView(scanner,validatorService).input();
        PurchaseOutputView purchaseOutputView = lottoController.getPurchaseResult(purchaseDto);
        purchaseOutputView.print();

        WinningNumberDto winningNumberDto =  new WinningNumberInputView(scanner, validatorService).input();
        ResultOutputView resultOutputView = lottoController.getLottoResult(purchaseDto, winningNumberDto);
        resultOutputView.print();
    }
}
