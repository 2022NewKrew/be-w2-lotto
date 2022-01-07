package domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLottoLine {
    private static LottoLine lottoLine;
    private int bonus;

    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final int NUM_PER_LINE = 6;

    public WinningLottoLine(LottoLine paramLottoLine) {
        lottoLine = paramLottoLine;
    }

    public boolean setBonus(int bonus) {
        if (!lottoLine.getLottoLine().contains(bonus) &&
                bonus >= MIN_NUM && bonus <= MAX_NUM) {
            this.bonus = bonus;
            return true;
        }
        return false;
    }

    public List<Integer> getBonusList() {
        List<Integer> foo = new ArrayList<>();
        foo.add(bonus);
        return foo;
    }

    public List<Integer> getLottoLine() {
        return lottoLine.getLottoLine();
    }


}
