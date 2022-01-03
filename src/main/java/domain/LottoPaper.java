package domain;

import java.util.ArrayList;

public class LottoPaper {
    public static final int LOTTO_PRICE = 1000;
    public final ArrayList<Lotto> paper = new ArrayList<>();

    public LottoPaper(long money) {
        int buyMax = (int)money / LOTTO_PRICE;
        for(int buy=0; buy<buyMax; buy++){
            paper.add(new Lotto());
        }
    }

}
