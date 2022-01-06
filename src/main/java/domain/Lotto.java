package domain;

import java.util.ArrayList;
import java.util.List;

public interface Lotto {
    int MIN_LOTTO_NUMBER = 1;
    int MAX_LOTTO_NUMBER = 2;

    List<Integer> getNumbers();
    String toString();
}
