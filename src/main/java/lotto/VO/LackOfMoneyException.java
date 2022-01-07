package lotto.VO;

public class LackOfMoneyException extends RuntimeException{
    public LackOfMoneyException(String message) {
        super(message);
    }
}
