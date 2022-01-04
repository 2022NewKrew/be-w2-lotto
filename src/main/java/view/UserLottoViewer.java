package view;

import parameters.LottoLine;
import parameters.UserLottoLines;


public class UserLottoViewer {
    public static void viewUserLottoList(UserLottoLines userLottoLines){
        userLottoLines.getUserLottoLinesStream()
                .forEach(UserLottoViewer::viewLottoList);
    }

    private static void viewLottoList(LottoLine line){
        System.out.println(line.getViewString());
    }
}
