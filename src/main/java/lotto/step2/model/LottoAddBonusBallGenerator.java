package lotto.step2.model;

import lotto.step1.dto.request.LottoPurchaseSheetDTO;
import lotto.step1.model.Lotto;
import lotto.step1.model.LottoGenerator;
import lotto.step1.model.LottoNumbers;

import java.util.List;

public class LottoAddBonusBallGenerator extends LottoGenerator {

    @Override
    public Lotto generate(LottoPurchaseSheetDTO lottoPurchaseSheetDTO) {
        final List<LottoNumbers> purchasedLottoNumbersList = generateLottoNumbersList(lottoPurchaseSheetDTO);
        return new LottoAddBonusBall(purchasedLottoNumbersList);
    }

    @Override
    protected LottoNumbers generateLottoNumbers() {
        final List<Integer> randomNumbers = generateRandomNumbers();
        return new LottoNumbersAddBonusBall(randomNumbers);
    }
}
