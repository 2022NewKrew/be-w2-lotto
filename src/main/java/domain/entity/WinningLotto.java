package domain.entity;

import view.InputManager;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto extends Lotto{
    private final int bonusNum;

    public WinningLotto() {
        super("지난 주 당첨 번호를 입력해 주세요.");
        bonusNum = InputManager.inputBonusNum();
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
