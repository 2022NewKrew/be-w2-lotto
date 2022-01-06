package model.builder;

import model.scan.AmountOfLottoScanner;
import model.scan.LottoNumberScanner;
import model.scan.ManualCountScanner;
import parameters.LottoLine;
import parameters.UserLottoLines;

public class UserLottoLineBuilder {

    private UserLottoLineBuilder() {
        
    }

    public static UserLottoLines makeUserLottoLines() {
        int amountOfLotto = AmountOfLottoScanner.getAmountOfLotto();
        int manualCount = ManualCountScanner.getManualCount(amountOfLotto);
        UserLottoLines userLottoLines = new UserLottoLines(amountOfLotto);
        getManualLotto(userLottoLines, manualCount);
        new LottoNumberGenerator().makeLines(userLottoLines, amountOfLotto - manualCount);
        System.out.println("수동으로 " + manualCount + "장, 자동으로 " + (amountOfLotto - manualCount) + "개를 구매했습니다.");
        return userLottoLines;
    }

    private static void getManualLotto(UserLottoLines userLottoLines, int manualCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int manualLotto = 0; manualLotto < manualCount; manualLotto++) {
            userLottoLines.addLottoLine(new LottoLine(LottoNumberScanner.getLottoNumbers()));
        }
    }
}
