package lotto.domain;

import lotto.view.LottoPrinter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by melodist
 * Date: 2022-01-03 003
 * Time: 오후 6:12
 */
public class LottoBundle {
    private final int lottoCount;
    private final int manualLottoCount;
    private final List<Lotto> lottos;

    /**
     * 콘솔 UI 사용 생성자
     */
    public LottoBundle(int purchaseAmount, int manualLottoCount) {
        Validator.validatePurchaseAmount(purchaseAmount);

        this.lottoCount = purchaseAmount / Constants.LOTTO_PRICE;
        this.manualLottoCount = manualLottoCount;
        Validator.validateManualLottoCount(lottoCount, manualLottoCount);

        lottos = new ArrayList<>();
        generateLottos();
    }

    /**
     * 웹 UI 사용 생성자
     */
    public LottoBundle(int purchaseAmount, String manualLottoString) {
        Validator.validatePurchaseAmount(purchaseAmount);
        this.lottoCount = purchaseAmount / Constants.LOTTO_PRICE;

        String[] manualNumbers = createManualNumbers(manualLottoString);
        this.manualLottoCount = manualNumbers.length;
        Validator.validateManualLottoCount(lottoCount, manualLottoCount);

        lottos = new ArrayList<>();
        generateLottosWeb(manualNumbers);
    }

    private String[] createManualNumbers(String manualLottoString) {
        if (manualLottoString.isBlank()) {
            return new String[0];
        }
        return manualLottoString.split("\r?\n");
    }

    private void generateLottos() {
        LottoPrinter.printManualLotto();
        for (int i = 0; i < manualLottoCount; i++) {
            List<Integer> manualLottoNumbers = LottoGenerator.generateManualLotto();
            lottos.add(new Lotto(manualLottoNumbers));
        }

        for (int i = 0; i < lottoCount - manualLottoCount; i++) {
            lottos.add(new Lotto(LottoGenerator.generateLotto()));
        }
    }

    private void generateLottosWeb(String[] manualNumberStrings) {
        for (String numberString : manualNumberStrings) {
            lottos.add(new Lotto(createManualLotto(numberString)));
        }

        for (int i = 0; i < lottoCount - manualLottoCount; i++) {
            lottos.add(new Lotto(LottoGenerator.generateLotto()));
        }
    }

    private List<Integer> createManualLotto(String lottoString) {
        return Arrays.stream(lottoString.split(Constants.INPUT_MANUAL_LOTTO_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Integer getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void printLottos() {
        LottoPrinter.printLottoAmount(manualLottoCount, lottoCount - manualLottoCount);
        lottos.forEach(System.out::println);
    }
}
