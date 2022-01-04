package view;

import domain.Lotto;

import java.util.ArrayList;

public class OutputView {
    public OutputView(){

    }

    public void printPurchaseLottoList(ArrayList<Lotto> lottos){
        for(Lotto lotto: lottos){
            System.out.println(lotto);
        }
    }
}
