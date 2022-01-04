package com.upperleaf.domain.lotto;

/**
 * 로또 생성 전략.
 * @see RandomLottoStrategy
 */
public interface LottoCreateStrategy {
    Lotto createLotto();
}
