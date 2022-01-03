package view.output;

import domain.LottoResult;
import domain.LottoSheet;

import java.util.Map;

public interface OutputPrinter {
    void printLottoSheet(LottoSheet lottoSheet);
    void printLottoResult(Map<Integer, Integer> userResult);

}
