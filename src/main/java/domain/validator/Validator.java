package domain.validator;

import exception.LottoException;

public interface Validator {
    void validate(String input) throws LottoException;
}
