package controller;

import service.LottoService;
import view.HomeView;

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
        homeView.printInputBuyView();
        inputBuyPrice = sc.nextInt();
        homeView.printInputManualSize();
        inputSizeManual = sc.nextInt();
        homeView.printInputManualLotto();
        for (int i = 0; i < inputSizeManual; i++) {
            lottoService.registerManualLotto(sc.next());
        }
        lottoService.registerAutoLottos(inputBuyPrice / 1000 - inputSizeManual);
        homeView.printBuySuccessView(inputSizeManual);

        homeView.printInputWinningNumbersView();
        lottoService.registerWinningLotto(sc.next());
        homeView.printInputBonusBall();
        lottoService.registerBonusBall(sc.nextInt());
        homeView.printResults();
    }
}
