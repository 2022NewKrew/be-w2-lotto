package domain;

import DTO.NNumber;

import java.util.*;

public class WinningLottoLine {
    private static List<Integer> lottoLine;
    private int bonus;

    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final int NUM_PER_LINE = 6;

    private WinningLottoLine(List<Integer> paramLottoLine) {
        lottoLine = paramLottoLine;
    }

    public static WinningLottoLine makeWinningLine(List<String> strLst) {
        List<Integer> retLst = new ArrayList<>();

        for (String str : strLst) {
            retLst.add(Integer.valueOf(str));
        }

        Collections.sort(retLst);

        if (isVerifiedLine(retLst)) {
            return new WinningLottoLine(retLst);
        }

        return null;
    }

    public boolean setBonus(int bonus) {
        if (!lottoLine.contains(bonus) && bonus >= MIN_NUM && bonus <= MAX_NUM) {
            this.bonus = bonus;
            return true;
        }
        return false;
    }

    public int getBonus() {
        return bonus;
    }

    public List<Integer> getLottoLine() {
        return new ArrayList<>(lottoLine);
    }

    private static boolean isVerifiedLine(List<Integer> srcLst) {
        Set<Integer> set = new HashSet<>(srcLst);

        return set.size() == NUM_PER_LINE && srcLst.get(0) >= MIN_NUM && srcLst.get(NUM_PER_LINE - 1) <= MAX_NUM;
    }
}
