package step1.domain;

import java.util.ArrayList;
import java.util.List;

public class WinNumbers {

    List<Integer> numbers = new ArrayList<>();
    int bonusNumber;

    WinNumbers(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }
}
