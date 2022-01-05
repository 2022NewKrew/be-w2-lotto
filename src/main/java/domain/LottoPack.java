package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoPack {
    private static final List<Lotto> lottoList = new ArrayList<>();
    public LottoPack(){

    }
    public void add(Lotto lotto){
        lottoList.add(lotto);
    }


    public void printLottoPack() {
        lottoList.stream().forEach(e -> System.out.print(e+"\n"));
    }
}
