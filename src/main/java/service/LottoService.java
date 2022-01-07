package service;

import domain.Lotto;
import exception.InvalidInputException;

import java.util.ArrayList;
import java.util.List;

import static utils.Symbol.LOTTO_PRICE;

public class LottoService {
    private List<Lotto> lottoList = new ArrayList<>();
    private static final AutomaticGenerator automaticGenerator = new AutomaticGenerator();

    public LottoService(int purchaseAmount, List<Lotto> manualLottoList) throws InvalidInputException {
        int manualLottoCount = manualLottoList.size();
        int automaticLottoCount = purchaseAmount / LOTTO_PRICE - manualLottoCount;
        generateLottoList(automaticLottoCount, manualLottoList);
    }

    public void generateLottoList(int automaticLottoCount, List<Lotto> manualLottoList) throws InvalidInputException {
        lottoList.addAll(manualLottoList);
        for (int i = 0; i < automaticLottoCount; i++) {
            lottoList.add(generate(automaticGenerator));
        }
    }

    public Lotto generate(LottoGenerator lottoGenerator) throws InvalidInputException {
        return lottoGenerator.generate();
    }

    public List<Lotto> getLottos() {
        return lottoList;
    }
}
