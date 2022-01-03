package validate;

public abstract class Validator {
    public void validate(Object param) throws RuntimeException{
        if(!supports(param)){
            throw new IllegalArgumentException("타입이 맞지 않습니다.");
        }

        validateValue(param);
    }

    protected abstract boolean supports(Object param);
    protected abstract void validateValue(Object param) throws IllegalArgumentException;
}
