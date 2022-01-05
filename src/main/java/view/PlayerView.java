package view;

import domain.Lotto;
import domain.Player;

import java.util.List;

public class PlayerView {

    public void PrintLottoSize(int payAutoCount, int payManualCount)
    {
        System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.",payManualCount,payAutoCount));
    }
}