package lotto.util;

/**
 * 예외처리를 위한 클래스
 */
public class InvalidInputException extends RuntimeException{
    public InvalidInputException(String message){
        super(message);
    }
}
