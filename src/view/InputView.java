package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static InputView instance;
    private final Scanner scanner;

    private InputView () {
        this.scanner = new Scanner(System.in);
    }

    public int inputPrice () {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public int inputNumberOfManual (){
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());

    }
    public List<String> inputManual (int numberOfManual) {
        if(numberOfManual == 0){
            return new ArrayList<>();
        }
        System.out.println("수동으로 구매 할 번호를 입력해 주세요.");
        List<String> manualBuy = new ArrayList<>();
        for (int i=0;i<numberOfManual;i++){
            manualBuy.add(scanner.nextLine());
        }
        return  manualBuy;
    }

    public String inputWinning () {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public int inputBonus () {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static InputView getInstance () {
        if (instance == null) instance = new InputView();
        return instance;
    }
}