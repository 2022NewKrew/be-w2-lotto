package validate;

public abstract class Validator{
    void validate(Object value) throws IllegalArgumentException{
        if(!supports(value)){
            throw new IllegalArgumentException("해당 타입을 지원하지 않습니다.");
        }

        validateValue(value);
    }

    protected abstract boolean supports(Object value);
    protected abstract void validateValue(Object value) throws IllegalArgumentException;
}
