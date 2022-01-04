package service;

import domain.Lotto;
import domain.LottoResult;

import java.util.ArrayList;

public class LottoService {
    private final ArrayList<Lotto> lottoList = new ArrayList<>();

    public void createLotto() {
        lottoList.add(Lotto.generateRandomly());
    }

    public ArrayList<Lotto> getAllLotto() {
        return lottoList;
    }

    public LottoResult getLottoResult(ArrayList<Integer> winningNumber, int bonusNumber) {
        return new LottoResult(lottoList, winningNumber, bonusNumber);
    }
}
