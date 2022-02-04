package repository;

import database.WinNumbers;

import java.util.List;

public class WinNumbersRepository {
    private static WinNumbersRepository winNumbersRepository = null;
    private final WinNumbers winNumbers = WinNumbers.getWinNumbers();

    private WinNumbersRepository() {
    }

    public static WinNumbersRepository getWinNumbersRepository() {
        if (winNumbersRepository == null) {
            winNumbersRepository = new WinNumbersRepository();
        }
        return winNumbersRepository;
    }

    public void insert(List<Integer> winNumbers) {
        this.winNumbers.insert(winNumbers);
    }

    public void insert(Integer bonusNumber) {
        this.winNumbers.insert(bonusNumber);
    }

    public List<Integer> findWinNumbers() {
        return winNumbers.findWinNumbers();
    }
}
