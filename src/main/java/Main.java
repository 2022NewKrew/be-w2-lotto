package main.java;

import main.java.myexception.UnderThousandException;
import main.java.view.LottoUI;

public class Main {
    public static void main(String[] args) throws UnderThousandException {
        LottoUI lotto = new LottoUI();
        lotto.startGame();
    }
}
