package Lotto.view;

import Lotto.domain.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputManager {
    // 구입 금액을 입력받는 메소드
    public int inputPrice(){
        Scanner sc = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return ExceptionCheck.priceCheck(sc);
    }

    // 수동으로 구매할 번호를 입력받는 메소드
    public List<Ticket> inputManualTicket(){
        Scanner sc = new Scanner(System.in);
        List<Ticket> manualTickets = new ArrayList<>();
        int countOfManual = inputCountOfManual();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for(int cnt=0; cnt<countOfManual; cnt++){
            manualTickets.add(new Ticket(ExceptionCheck.inputNumbersCheck(sc)));
        }
        return manualTickets;
    }

    // 수동으로 구매할 로또 수를 입력받는 메소드
    public int inputCountOfManual(){
        Scanner sc = new Scanner(System.in);
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return ExceptionCheck.countOfManualCheck(sc);
    }

    // 지난 주 당첨 번호를 입력받는 메소드
    public List<Integer> inputWiningNumber(){
        Scanner sc = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요. (쉼표(,)로 구분해주세요)");
        return ExceptionCheck.inputNumbersCheck(sc);
    }

    // 보너스 숫자를 입력받는 메소드
    public int inputBonusNumber(List<Integer> WiningNumbers){
        Scanner sc = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        return ExceptionCheck.bonusNumberCheck(sc, WiningNumbers);
    }
}
