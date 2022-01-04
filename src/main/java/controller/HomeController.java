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
        homeView.printInputBuyView();
        lottoService.buyLottos(sc.nextInt());
        homeView.printBuySuccessView();

        homeView.printInputWinningNumbersView();
        lottoService.registerWinningLotto(sc.next());
        homeView.printResults();
    }
}
