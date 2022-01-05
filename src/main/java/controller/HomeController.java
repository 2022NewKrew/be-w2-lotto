package controller;

import service.LottoService;
import view.HomeView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HomeController {
    private final LottoService lottoService;
    private final HomeView homeView;
    private final Scanner sc;

    public HomeController(Scanner sc) {
        lottoService = new LottoService();
        homeView = new HomeView(lottoService);
        this.sc = sc;
    }

    public void run() {
        int inputBuyPrice, inputSizeManual;
        inputBuyPrice = inputBuyPrice();
        inputSizeManual = inputManualLottoSize();
        inputManualLottoNumbers(inputSizeManual)
                .forEach(number -> lottoService.registerManualLotto(number));
        lottoService.registerAutoLottos(inputBuyPrice / 1000 - inputSizeManual);

        homeView.printBuySuccessView(inputSizeManual);

        lottoService.registerWinningLotto(inputWinningLottoNumbers());
        lottoService.registerBonusBall(inputBonusBallNumber());
        homeView.printResults();
    }

    private int inputBuyPrice() {
        homeView.printInputBuyView();
        return sc.nextInt();
    }

    private int inputManualLottoSize() {
        homeView.printInputManualSize();
        return sc.nextInt();
    }

    private List<String> inputManualLottoNumbers(int manualLottoSize) {
        List<String> inputNumbers = new ArrayList<String>(manualLottoSize);
        homeView.printInputManualLotto();
        for (int i = 0; i < manualLottoSize; i++) {
            inputNumbers.add(sc.next());
        }
        return inputNumbers;
    }

    private String inputWinningLottoNumbers() {
        homeView.printInputWinningNumbersView();
        return sc.next();
    }

    private int inputBonusBallNumber() {
        homeView.printInputBonusBall();
        return sc.nextInt();
    }
}
