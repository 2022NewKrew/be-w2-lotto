package com.worldbright.dto;

import com.worldbright.domain.Lotto;

import java.util.List;

public class MainDTO {
    private int buyPrice;
    private int size;
    private Lotto lottoManager;
    private List<Integer> results;

    public void setBuyPrice(int buyPrice) {
        this.size = buyPrice / 1000;
        this.buyPrice = size * 1000;
        this.lottoManager = new Lotto(size);
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public int getSize() {
        return size;
    }

    public Lotto getLotto() {
        return lottoManager;
    }

    public List<Integer> getResults() {
        return results;
    }

    public void registerWinningLotto(LottoDTO winning) {
        results = lottoManager.getResult(winning);
    }
}
