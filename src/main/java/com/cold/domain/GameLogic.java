package com.cold.domain;

import java.util.Map;

import lombok.Getter;

@Getter
public class GameLogic {
    private static String INVALID_PURCHASED_PRICE = "구입 금액이 음수일 수는 없습니다.";
    private static String INVALID_MANUAL_LOTTO_MONEY = "수동 로또 구입 수량이 전체 구입 금액을 초과할 수는 없습니다.";

    private static Integer PRICE_PER_TICKET = 1000;

    public static int calculateAutoLottoCount(int purchasePrice, int manualLottoCount) throws IllegalArgumentException {
        int purchaseCount = calculateWholeLottoCount(purchasePrice);
        validateManualLotto(purchaseCount, manualLottoCount);
        return purchaseCount - manualLottoCount;
    }

    private static int calculateWholeLottoCount(int purchasePrice) throws IllegalArgumentException {
        validateWholePrice(purchasePrice);
        return purchasePrice / PRICE_PER_TICKET;
    }

    private static void validateManualLotto(int purchasePrice, int manualLottoMoney) throws IllegalArgumentException {
        if (purchasePrice < manualLottoMoney) {
            throw new IllegalArgumentException(INVALID_MANUAL_LOTTO_MONEY);
        }
    }

    private static void validateWholePrice(int purchasePrice) {
        if (purchasePrice < 0) {
            throw new IllegalArgumentException(INVALID_PURCHASED_PRICE);
        }
    }

    public static Object calculateTotalLottoCount(Integer manualLottoCount, Integer autoLottoCount) {
        return manualLottoCount + autoLottoCount;
    }
}

