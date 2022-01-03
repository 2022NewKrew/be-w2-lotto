package view;

import model.datastructure.LottoMatchStateDTO;
import model.datastructure.LottoNumber;

public interface LottoUI {
    int askUserBudget();
    LottoNumber askUserWinNumber() throws Exception;
    void printLine(String str);
    void showResult(LottoMatchStateDTO lottoMatchStateDTO);
}
