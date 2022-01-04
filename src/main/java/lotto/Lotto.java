package main.java.lotto;

import java.util.ArrayList;

public class Lotto {
    private ArrayList<Integer> lotto;

    public Lotto(){
        lotto = new ArrayList<Integer>();
    }

    public ArrayList<Integer> getLotto() {
        return lotto;
    }

    public void addLotto(int num) {
        this.lotto.add(num);
    }

    public void printLotto(){
        System.out.println(""+lotto);
    }
}
