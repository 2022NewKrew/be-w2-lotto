package service;

import domain.Lotto;
import exception.InvalidInputException;

import java.util.ArrayList;

import static utils.Symbol.LOTTO_PRICE;

public class LottoService {
    private ArrayList<Lotto> lottoList = new ArrayList<>();

    public LottoService(int purchaseAmount, int manualLottoCount) throws InvalidInputException {
        int automaticLottoCount = purchaseAmount / LOTTO_PRICE - manualLottoCount;
        ManualGenerator manualGenerator = new ManualGenerator();
        AutomaticGenerator automaticGenerator = new AutomaticGenerator();

        for (int i = 0; i < manualLottoCount; i++) {
            lottoList.add(generate(manualGenerator));
        }
        for (int i = 0; i < automaticLottoCount; i++) {
            lottoList.add(generate(automaticGenerator));
        }
    }

    public Lotto generate(LottoGenerator lottoGenerator) throws InvalidInputException {
        return lottoGenerator.generate();
    }

    public ArrayList<Lotto> getLottos() {
        return lottoList;
    }
}
