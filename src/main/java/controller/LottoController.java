package controller;

import dto.LottoResultEntryDto;
import dto.LottoResultRevenuePercentDto;
import dto.LottosDto;
import model.lotto.Lotto;
import model.lotto.LottoRank;
import model.lotto.number.LottoNumber;
import model.lotto.result.LottoResult;
import view.UserInput;
import view.UserOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoController {

    private static final int START_NUMBER_PRESENT = 1;

    public static void run() {
        List<Lotto> lottos = SellLottoController.buyLottos(UserInput.getMoney());
        UserOutput.printLotto(new LottosDto(getLottoNumbers(lottos)));
        LottoResult lottoResult = MatchLottoController.matchingResult(lottos);
        UserOutput.printHistory(resultMapToEntryList(lottoResult.getResult()), START_NUMBER_PRESENT);
        UserOutput.printRevenueRate(new LottoResultRevenuePercentDto(lottoResult.getRevenuePercent()));
    }

    private static List<List<Integer>> getLottoNumbers(List<Lotto> lottos) {
        List<List<Integer>> numbers = new ArrayList<>();
        for (Lotto lotto : lottos) {
            numbers.add(getLottoNumber(lotto));
        }
        return numbers;
    }

    private static List<Integer> getLottoNumber(Lotto lotto) {
        return lotto
                .getNumbers()
                .stream()
                .map(LottoNumber::convertToInt)
                .collect(Collectors.toList());
    }

    private static List<LottoResultEntryDto> resultMapToEntryList(Map<LottoRank, Integer> result) {
        return result
                .entrySet()
                .stream()
                .map(LottoResultEntryDto::new)
                .collect(Collectors.toList());
    }
}
