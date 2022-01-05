package lotto.step3.model;

import lotto.step1.dto.request.LottoPurchaseSheetDTO;
import lotto.step1.exception.LottoGameException;
import lotto.step1.model.Lotto;
import lotto.step1.model.LottoNumbers;
import lotto.step2.model.LottoAddBonusBall;
import lotto.step2.model.LottoAddBonusBallGenerator;
import lotto.step2.model.LottoNumbersAddBonusBall;
import lotto.step3.dto.request.NoAutoLottoPurchaseSheetDTO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NonAutoLottoAddBonusBallGenerator extends LottoAddBonusBallGenerator {

    @Override
    public Lotto generate(LottoPurchaseSheetDTO lottoPurchaseSheetDTO) {
        final List<LottoNumbers> purchasedLottoNumbersList = generateLottoNumbersList(lottoPurchaseSheetDTO);
        final List<LottoNumbers> nonAutoLottoNumbersList = generateNonAutoLottoNumbersList(lottoPurchaseSheetDTO);

        purchasedLottoNumbersList.addAll(nonAutoLottoNumbersList);

        return new LottoAddBonusBall(purchasedLottoNumbersList);
    }

    @Override
    protected List<LottoNumbers> generateLottoNumbersList(LottoPurchaseSheetDTO lottoPurchaseSheetDTO) {
        final NoAutoLottoPurchaseSheetDTO noAutoLottoPurchaseSheetDTO = checkAndConvertType(lottoPurchaseSheetDTO);

        final int PRICE = 1000;
        final List<List<Integer>> nonAutoLottoNumbersList = noAutoLottoPurchaseSheetDTO.getNonAutoLottoNumbersList();
        final int numOfNonAuto = nonAutoLottoNumbersList.size();
        final int count = (lottoPurchaseSheetDTO.getPurchaseAmount() / PRICE) - numOfNonAuto;

        return IntStream.range(0, count)
                .mapToObj(i -> generateLottoNumbers())
                .collect(Collectors.toList());
    }

    private List<LottoNumbers> generateNonAutoLottoNumbersList(LottoPurchaseSheetDTO lottoPurchaseSheetDTO) {
        final NoAutoLottoPurchaseSheetDTO noAutoLottoPurchaseSheetDTO = checkAndConvertType(lottoPurchaseSheetDTO);

        final List<List<Integer>> nonAutoLottoNumbersList = noAutoLottoPurchaseSheetDTO.getNonAutoLottoNumbersList();

        return nonAutoLottoNumbersList.stream()
                .map(LottoNumbersAddBonusBall::new)
                .collect(Collectors.toList());
    }

    private NoAutoLottoPurchaseSheetDTO checkAndConvertType(LottoPurchaseSheetDTO lottoPurchaseSheetDTO) {
        if (!(lottoPurchaseSheetDTO instanceof NoAutoLottoPurchaseSheetDTO noAutoLottoPurchaseSheetDTO)) {
            throw new LottoGameException("");
        }
        return noAutoLottoPurchaseSheetDTO;
    }
}
