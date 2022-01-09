package lotto.exception;

public class IllegalPurchaseMoneyException extends RuntimeException{
    public IllegalPurchaseMoneyException(){
        super("입력된 금액이 올바르지 않습니다.");
    }

    public IllegalPurchaseMoneyException(String message){
        super(message);
    }
}
