package service;

import domain.Lotto;
import exception.InvalidInputException;

public interface LottoGenerator {
    Lotto generate() throws InvalidInputException;
}
