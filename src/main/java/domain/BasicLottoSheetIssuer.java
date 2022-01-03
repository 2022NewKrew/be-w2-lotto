package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BasicLottoSheetIssuer implements LottoSheetIssuer {

    private static final int PRICE = 1000;
    private static List<Integer> SHUFFLED_LOTTO_NUMBER_LIST = IntStream.rangeClosed(Lotto.LOTTO_MIN_NUM, Lotto.LOTTO_MAX_NUM).boxed().collect(Collectors.toList());

    @Override
    public LottoSheet issueLottoSheet(LottoConfig lottoConfig) {
        final int numberOfLotto = lottoConfig.getPurchaseAmount() / PRICE;
        System.out.println(numberOfLotto + "개를 구매했습니다.");

        if (lottoConfig.getIssueCondition() == IssueConditionType.AUTO)
            return issueLottoSheetAuto(lottoConfig);
        return issueLottoSheetManual(lottoConfig);
    }

    private LottoSheet issueLottoSheetAuto(LottoConfig lottoConfig) {
        final int numberOfLotto = lottoConfig.getPurchaseAmount() / PRICE;
        List<Lotto> lottoList = new ArrayList<>();
        IntStream.rangeClosed(0, numberOfLotto)
                .forEach(i -> lottoList.add(new Lotto(generateRandomNumber())));
        return new LottoSheet(lottoList);
    }

    private LottoSheet issueLottoSheetManual(LottoConfig lottoConfig) {
        List<Lotto> lottoList = new ArrayList<>();
        lottoConfig.getUserInputLottoList()
                .forEach(userInput -> lottoList.add(new Lotto(generateNumberByUser(userInput))));
        return new LottoSheet(lottoList);
    }

    private List<Integer> generateRandomNumber() {
//        List<Integer> SHUFFLED_LOTTO_NUMBER_LIST = IntStream.rangeClosed(Lotto.LOTTO_MIN_NUM, Lotto.LOTTO_MAX_NUM).boxed().collect(Collectors.toList());
        Collections.shuffle(SHUFFLED_LOTTO_NUMBER_LIST);
//        return SHUFFLED_LOTTO_NUMBER_LIST.subList(0, Lotto.THE_NUMBER_OF_LOTTO);
        return new ArrayList<>(SHUFFLED_LOTTO_NUMBER_LIST.subList(0, Lotto.THE_NUMBER_OF_LOTTO));
    }

    private List<Integer> generateNumberByUser(List<Integer> lottoNumbers) {
        return lottoNumbers;
    }
}
