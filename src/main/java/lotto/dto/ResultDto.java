package lotto.dto;

import java.util.Map;
import lotto.domain.Rank;
import lotto.domain.Result;

public class ResultDto {

    final float yield;
    final Map<Rank, Integer> result;

    public ResultDto(float yield, Map<Rank, Integer> result) {
        this.yield = yield;
        this.result = result;
    }

    public static ResultDto resultToDto(Result result) {
        return new ResultDto(result.getYield(), result.getResult());
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }

    public float getYield() {
        return yield;
    }
}
