package model.lotto.strategy;

import model.lotto.number.LottoNumber;

import java.util.List;

public interface GenerateLottoStrategy {
    List<LottoNumber> generate();
}
