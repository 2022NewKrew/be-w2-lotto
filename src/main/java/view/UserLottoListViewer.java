package view;

import parameters.LottoLine;
import parameters.UserLottoLines;


public class UserLottoListViewer {
    private UserLottoListViewer() {

    }

    public static void view(UserLottoLines userLottoLines) {
        userLottoLines.getUserLottoLinesStream()
                .forEach(UserLottoListViewer::viewLottoList);
    }

    private static void viewLottoList(LottoLine line) {
        System.out.println(line.getViewString());
    }
}
