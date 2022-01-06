package com.kakaocorp.lotto.dto;

import com.kakaocorp.lotto.domain.Lotto;

import java.util.List;

public class BuyLottoDto {

    private final List<Lotto> lottoList;
    private final int orderManualNumber;

    public BuyLottoDto(List<Lotto> lottoList, int orderManualNumber) {
        this.lottoList = lottoList;
        this.orderManualNumber = orderManualNumber;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int getOrderManualNumber() {
        return orderManualNumber;
    }
}
