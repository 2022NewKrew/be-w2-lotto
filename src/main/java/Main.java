import dto.LottoDTO;
import dto.MainDTO;
import view.MainView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MainDTO mainDTO = new MainDTO();
        MainView mainView = new MainView(mainDTO);
        Scanner sc = new Scanner(System.in);

        mainView.printInputBuyView();
        mainDTO.setBuyPrice(sc.nextInt());
        mainView.printBuySuccessView();
        sc.nextLine();

        mainView.printInputWinningNumbersView();
        mainDTO.registerWinningLotto(new LottoDTO(sc.nextLine()));

        mainView.printResults();
    }
}
