package domain;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class LottoPaper {
    private static final int LOTTO_PRICE = 1000;
    private final ArrayList<Lotto> paper = new ArrayList<>();

    public LottoPaper(long money) {
        int buyMax = (int)money / LOTTO_PRICE;
        for(int buy=0; buy<buyMax; buy++){
            paper.add(new Lotto());
        }
    }

    @Override
    public String toString(){
        return paper.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("]\n[", "[", "]"));
    }

    public int countLotto(){
        return paper.size();
    }
}
