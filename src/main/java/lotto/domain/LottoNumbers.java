package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    private static final List<Integer> allLottoNumber = IntStream.range(1, 46).boxed().collect(Collectors.toList());
    private final ArrayList<Integer> lottoNumber = new ArrayList<>();

    public LottoNumbers() {
        Collections.shuffle(allLottoNumber);
        for (int i = 0; i < 6; i++) {
            int number = allLottoNumber.get(i);
            lottoNumber.add(number);
        }
        Collections.sort(lottoNumber);
    }
    public LottoNumbers(ArrayList<Integer> lottoNumbers) {
        for (int i = 0; i < 6; i++) {
            int number = lottoNumbers.get(i);
            lottoNumber.add(number);
        }
        Collections.sort(lottoNumber);
    }

    public ArrayList<Integer> getNumbers() {
        return lottoNumber;
    }

    public int calculateContain(List<Integer> winningNumber, int bonusNumber) {
        int containCount = 0;
        for (int number : winningNumber) {
            containCount += checkContain(number) ? 1 : 0;
        }
        if (containCount == 6) {
            return 7;
        }
        if (containCount == 5 && checkContain(bonusNumber)) {
            return 6;
        }
        return containCount;
    }

    public boolean checkContain(int number) {
        if (lottoNumber.contains(number)) {
            return true;
        }
        return false;
    }
}
