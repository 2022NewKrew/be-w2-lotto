import dto.input.PurchaseDto;
import dto.input.WinningNumbersDto;
import presentation.controller.LottoController;
import presentation.view.input.PurchaseInputView;
import presentation.view.input.WinningNumberInputView;
import presentation.view.output.ErrorOutputView;
import presentation.view.output.OutputView;

import java.util.Scanner;

public class LottoDriver {
    private static final LottoController lottoController = new LottoController();

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            inputPurchaseAndPrintResult(scanner);
            inputWinningNumbersAndPrintResult(scanner);
        }
    }

    private static void inputPurchaseAndPrintResult(Scanner scanner){
        PurchaseDto purchaseDto = new PurchaseInputView(scanner).input();
        OutputView outputView = lottoController.getPurchaseResult(purchaseDto);
        outputView.print();
        exitProgramIfErrorOutputView(outputView);
    }

    private static void inputWinningNumbersAndPrintResult(Scanner scanner){
        WinningNumbersDto winningNumbersDto =  new WinningNumberInputView(scanner).input();
        OutputView outputView = lottoController.getLottoResult(winningNumbersDto);
        outputView.print();
        exitProgramIfErrorOutputView(outputView);
    }

    private static void exitProgramIfErrorOutputView(OutputView outputView){
        if(outputView instanceof  ErrorOutputView){
            System.exit(0);
        }
    }
}
