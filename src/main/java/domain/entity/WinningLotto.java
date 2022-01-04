package domain.entity;

import view.InputManager;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto{
    private final List<Integer> winningNums;
    private final int bonusNum;

    public WinningLotto() {
        String lottoNums = InputManager.inputWinningNums();

        String[] winningNumsArray = lottoNums.split(",");
        winningNums = new ArrayList<>();
        for (String num : winningNumsArray) {
            winningNums.add(Integer.parseInt(num));
        }

        bonusNum = InputManager.inputBonusNum();
    }

    public List<Integer> getWinningNums() {
        return winningNums;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
