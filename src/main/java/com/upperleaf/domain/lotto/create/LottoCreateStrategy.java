package com.upperleaf.domain.lotto.create;

import com.upperleaf.domain.lotto.Lotto;

/**
 * 로또 생성 전략.
 * @see RandomLottoStrategy
 * @see ManualLottoStrategy
 * @see CustomLottoStrategy
 */
public interface LottoCreateStrategy {
    Lotto createLotto();
}
