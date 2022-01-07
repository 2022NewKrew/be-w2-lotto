package domain;

import java.util.List;

public interface Lotto {
    List<Integer> getNumbers();
    int getBonusNumber();
    String toString();
}
