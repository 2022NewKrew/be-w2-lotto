package model.datastructure;

import java.util.HashMap;
import java.util.Map;

public class LottoWinPrize {
    public static final HashMap<Integer, Integer> lottoWinPrize = new HashMap<>(Map.of(0,0,1,0,2,0,3,5000,4,50000, 5,1500000, 6,2000000000));

    public int get(int i) {
        return lottoWinPrize.get(i);
    }

}
