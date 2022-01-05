package validator;

import exception.LottoException;

public interface ValidatorInterface {
    void validateData(String input) throws LottoException;
}
