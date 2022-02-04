package database;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WinNumbers {
    private static WinNumbers winNumbers = null;
    private final List<LottoNumber> myWinNumbers = new ArrayList<>();
    private LottoNumber bonusNumber = null;

    private WinNumbers() {
    }

    public static WinNumbers getWinNumbers() {
        if (winNumbers == null) {
            winNumbers = new WinNumbers();
        }
        return winNumbers;
    }

    public void insert(Integer bonusNumber) {
        this.bonusNumber = new LottoNumber(bonusNumber, true);
    }

    public void insert(List<Integer> numbers) {
        for (Integer number : numbers) {
            LottoNumber winNumber = new LottoNumber(number);
            myWinNumbers.add(winNumber);
        }
    }

    public List<Integer> findWinNumbers() {
        return myWinNumbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }

    public Integer findBonusNumber() {
        return this.bonusNumber.getNumber();
    }

}
