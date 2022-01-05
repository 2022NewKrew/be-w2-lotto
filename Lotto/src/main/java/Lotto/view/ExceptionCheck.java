package Lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExceptionCheck {
    // 구입금액 입력 체크
    public static int priceCheck(Scanner sc){
        int price = 0;
        try{
            price = sc.nextInt();
        }catch (Exception e){
            System.out.println("구입금액을 잘 못 입력했습니다.");
            System.exit(1);
        }
        return price;
    }

    // 수동으로 구매할 로또 수를 체크
    public static int countOfManualCheck(Scanner sc){
        int count = 0;
        try{
            count = sc.nextInt();
        }catch (Exception e){
            System.out.println("로또 수를 잘 못 입력했습니다.");
            System.exit(1);
        }
        return count;
    }

    // 로또 번호 혹은 지난 주 당첨 번호를 체크
    public static List<Integer> inputNumbersCheck(Scanner sc){
        List<Integer> ticketNumbers = new ArrayList<>();
        for( String element : sc.next().replace(" ", "").split(","))
            ticketNumbers.add(Integer.parseInt(element));
        if(ticketNumbers.size() < 6)
            throw new IllegalArgumentException("번호 수가 6개보다 적습니다.");
        if(ticketNumbers.size() > 6)
            throw new IllegalArgumentException("번호 수가 6개보다 많습니다.");
        return ticketNumbers;
    }

    // 보너스 번호를 체크
    public static int bonusNumberCheck(Scanner sc, List<Integer> WiningNumbers){
        int bonusNumber = 0;
        try{
            bonusNumber = sc.nextInt();
        }catch (Exception e){
            System.out.println("번호를 잘 못 입력했습니다.");
            System.exit(1);
        }
        if(WiningNumbers.contains(bonusNumber))
            throw new IllegalArgumentException("보너스 번호와 당첨번호가 중복됩니다.");
        return bonusNumber;
    }
}
