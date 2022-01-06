package domain.entity;

import view.InputManager;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto{
    private final List<Integer> winningNums;
    private final int bonusNum;

    public WinningLotto() {
        winningNums = InputManager.inputWinningLotto();
        bonusNum = InputManager.inputBonusNum();
    }

    public List<Integer> getWinningNums() {
        return winningNums;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
