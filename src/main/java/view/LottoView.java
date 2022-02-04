package view;

import constant.Message;

import java.util.Scanner;

public class LottoView {
    private static final Scanner scanner = new Scanner(System.in);

    public String inputWithMessage(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public void printLotto(int manual, int auto, String lotto) {
        System.out.printf(Message.BUY_RESULT, manual, auto);
        System.out.print(lotto);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

}
