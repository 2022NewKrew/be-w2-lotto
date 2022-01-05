import dto.input.PurchaseDto;
import dto.input.WinningNumbersDto;
import presentation.controller.LottoController;
import presentation.view.input.PurchaseInputView;
import presentation.view.input.WinningNumbersInputView;
import presentation.view.output.ErrorOutputView;
import presentation.view.output.OutputView;

import java.util.Scanner;

public class LottoDriver {
    private static final LottoController lottoController = new LottoController();

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            inputPurchaseAndPrintResult(scanner);
            inputWinningNumbersAndPrintRewardResult(scanner);
        }
    }

    private static void inputPurchaseAndPrintResult(Scanner scanner){
        PurchaseDto purchaseDto = new PurchaseInputView(scanner).input();
        OutputView outputView = lottoController.purchaseLotto(purchaseDto);
        outputView.print();
        exitProgramIfErrorOutputView(outputView);
    }

    private static void inputWinningNumbersAndPrintRewardResult(Scanner scanner){
        WinningNumbersDto winningNumbersDto =  new WinningNumbersInputView(scanner).input();
        OutputView outputView = lottoController.matchingWith(winningNumbersDto);
        outputView.print();
        exitProgramIfErrorOutputView(outputView);
    }

    private static void exitProgramIfErrorOutputView(OutputView outputView){
        if(outputView instanceof  ErrorOutputView){
            System.exit(0);
        }
    }
}
