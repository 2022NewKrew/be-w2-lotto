package domain.LottoLineStructure;

import domain.LottoLine;
import domain.WinningLottoLine;

import java.util.*;

public class ManualLottoLine implements LottoLine {
    public List<Integer> lottoLine;

    private ManualLottoLine(List<Integer> paramLottoLine) {
        lottoLine = paramLottoLine;
    }

    public static ManualLottoLine makeManualLottoLineFromStrLst(List<String> strLst) {
        List<Integer> retLst = new ArrayList<>();

        for (String str : strLst) {
            try {
                retLst.add(Integer.parseInt(str));
            } catch (NumberFormatException e) {
                return null;
            }
        }

        Collections.sort(retLst);

        if (isVerifiedLine(retLst)) {
            return new ManualLottoLine(retLst);
        }

        return null;
    }

    public int checkWinning(List<Integer> winningNumbers) {
        int matchNum = 0;

        for (int num : winningNumbers) {
            matchNum += lottoLine.contains(num) ? 1 : 0;
        }

        return matchNum;
    }

    public List<Integer> getLottoLine() {
        return new ArrayList<>(lottoLine);
    }

    public String getPrintLine() {
        return lottoLine.toString();
    }

    private static boolean isVerifiedLine(List<Integer> srcLst) {
        Set<Integer> set = new HashSet<>(srcLst);

        return set.size() == NUM_PER_LINE && srcLst.get(0) >= MIN_NUM && srcLst.get(NUM_PER_LINE - 1) <= MAX_NUM;
    }
}
