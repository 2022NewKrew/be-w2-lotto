package domain;

import domain.LottoLineStructure.ManualLottoLine;

import java.util.*;

public class WinningLottoLine {
    private static LottoLine lottoLine;
    private int bonus;

    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final int NUM_PER_LINE = 6;

    private WinningLottoLine(LottoLine paramLottoLine) {
        lottoLine = paramLottoLine;
    }

    public static WinningLottoLine makeWinningLine(List<String> strLst) {
        List<Integer> retLst = new ArrayList<>();

        for (String str : strLst) {
            retLst.add(Integer.valueOf(str));
        }

        Collections.sort(retLst);

        if (isVerifiedLine(retLst)) {
            return new WinningLottoLine(new ManualLottoLine(retLst));
        }

        return null;
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

    private static boolean isVerifiedLine(List<Integer> srcLst) {
        Set<Integer> set = new HashSet<>(srcLst);

        return set.size() == NUM_PER_LINE && srcLst.get(0) >= MIN_NUM && srcLst.get(NUM_PER_LINE - 1) <= MAX_NUM;
    }
}
