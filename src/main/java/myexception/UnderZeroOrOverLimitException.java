package main.java.myexception;

public class UnderZeroOrOverLimitException extends Exception{
    public UnderZeroOrOverLimitException(String msg){
        super(msg);
    }
}
