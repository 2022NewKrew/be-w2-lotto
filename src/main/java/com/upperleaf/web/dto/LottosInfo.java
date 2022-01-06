package com.upperleaf.web.dto;

import com.upperleaf.domain.lotto.Lottos;

import java.util.List;

public class LottosInfo {
    private final List<String> lottos;
    private final int lottosSize;
    private final long lottoId;

    public LottosInfo(Lottos lottos) {
        this.lottosSize = lottos.getLottosSize();
        this.lottos = lottos.getLottosInfo();
        this.lottoId = lottos.getId();
    }

    public List<String> getLottos() {
        return lottos;
    }
    public int getLottosSize() {
        return lottosSize;
    }
    public long getLottoId() {
        return lottoId;
    }
}
