package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static domain.Constants.*;

public class LottoNumber {
    private static final Map<Integer, LottoNumber> cache = new HashMap<>();

    static {
        for(int i= MIN_NUMBER; i<=MAX_NUMBER; i++){
            cache.put(i, LottoNumber.of(i));
        }
    }

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
        validateNumber(number);
    }

    public static LottoNumber of(int number){
        LottoNumber lottoNumber = cache.get(number);

        if(Objects.isNull(lottoNumber)) lottoNumber = new LottoNumber(number);

        return lottoNumber;
    }

    private void validateNumber(int number){
        if(number < MIN_NUMBER || number > MAX_NUMBER) throw new IllegalArgumentException();
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
