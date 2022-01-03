package com.kakao.lottogame.domain;

import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;

public class Result {

    private final EnumMap<Reward, Integer> result;

    public Result() {
        result = new EnumMap<>(Reward.class);
        for (Reward reward : Reward.values()) {
            result.put(reward, 0);
        }
    }

    public void add(Reward reward) {
        result.put(reward, result.get(reward) + 1);
    }

    public Map<Reward, Integer> getResult() {
        return result;
    }

    public long getProfit(Money money) {
        long total = 0L;
        for (Entry<Reward, Integer> entry : result.entrySet()) {
            total += (long) entry.getKey().getValue().getValue() * result.get(entry.getKey());
        }
        return total * 100 / money.getValue();
    }
}
