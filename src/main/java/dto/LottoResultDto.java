package dto;

import java.util.Collections;
import java.util.Map;

public class LottoResultDto {
    private final Map<Integer, Integer> result;

    public LottoResultDto(Map<Integer, Integer> result) {
        this.result = Collections.unmodifiableMap(result);
    }

    public Integer get(int key) {
        return result.get(key);
    }

    public boolean containsKey(int key) {
        return result.containsKey(key);
    }
}
