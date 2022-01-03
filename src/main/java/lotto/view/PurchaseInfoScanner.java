package lotto.view;

import java.util.Scanner;

public class PurchaseInfoScanner {
    Scanner sc = new Scanner(System.in);

    public long getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Long.parseLong(sc.nextLine());
    }
}
