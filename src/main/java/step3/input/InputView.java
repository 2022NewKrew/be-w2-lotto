package step3.input;

import java.util.List;

public interface InputView {
    public int inputBuyTicketAmount();
    public List<Integer> inputLottoNum();
    public int inputBonusNum(List<Integer> targetNums);
    public int inputAmoundOfSelf(int buyAmount);
    public List<Integer> inputWinningNum();
}
