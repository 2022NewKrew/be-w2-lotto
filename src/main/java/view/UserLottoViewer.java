package view;

import parameters.LottoLine;
import parameters.UserLottoLines;

import java.util.stream.Stream;

public class UserLottoViewer {
    public void viewUserLottoList(UserLottoLines userLottoLines){
        userLottoLines.getUserLottoLinesStream()
                .forEach(this::viewLottoList);
    }

    private void viewLottoList(LottoLine line){
        System.out.println(line.getViewString());
    }
}
