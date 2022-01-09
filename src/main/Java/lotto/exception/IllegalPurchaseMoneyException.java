package lotto.exception;

public class IllegalPurchaseMoneyException extends RuntimeException{
    public IllegalPurchaseMoneyException(String message){
        super(message);
    }
}
