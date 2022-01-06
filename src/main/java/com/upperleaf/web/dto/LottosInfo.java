package com.upperleaf.web.dto;

import com.upperleaf.domain.lotto.Lottos;

import java.util.List;

public class LottosInfo {
    private final List<String> lottos;
    private final int lottosSize;

    public LottosInfo(Lottos lottos) {
        this.lottosSize = lottos.getLottosSize();
        this.lottos = lottos.getLottosInfo();
    }

    public List<String> getLottos() {
        return lottos;
    }
    public int getLottosSize() {
        return lottosSize;
    }
}
