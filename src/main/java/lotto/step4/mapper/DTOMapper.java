package lotto.step4.mapper;

import lotto.step1.dto.request.ConfirmTheWinDTO;
import lotto.step1.dto.request.LottoPurchaseSheetDTO;
import lotto.step1.exception.LottoGameException;
import lotto.step1.util.TypeConverter;
import lotto.step1.util.Validator;
import lotto.step2.dto.request.ConfirmTheWinAddBonusBallDTO;
import lotto.step3.dto.request.NoAutoLottoPurchaseSheetDTO;
import spark.Request;

import java.util.Arrays;
import java.util.List;

public class DTOMapper {
    public static LottoPurchaseSheetDTO reqToLottoPurchaseSheetDTO(Request req) {
        final int purchaseAmount = TypeConverter.strToInt(req.queryParams("inputMoney"), Validator.EMPTY_VALIDATOR);
        final String nonAutoLottoNumbersListStr = req.queryParams("manualNumber");

        final List<List<Integer>> nonAutoLottoNumbersList = Arrays.stream(nonAutoLottoNumbersListStr.split("\n"))
                .map(str -> TypeConverter.strToIntList(str, Validator.FROM_1_TO_45_VALIDATOR))
                .toList();

        return new NoAutoLottoPurchaseSheetDTO(purchaseAmount, nonAutoLottoNumbersList);
    }

    public static ConfirmTheWinDTO reqToConfirmTheWinAddBonusBallDTO(Request req) {
        final List<Integer> lastWeekWinningNumbers = TypeConverter.strToIntList(req.queryParams("lastWeekWinningNumbers"), Validator.FROM_1_TO_45_VALIDATOR);
        final int bonusBall = TypeConverter.strToInt(req.queryParams("bonusBall"), Validator.FROM_1_TO_45_VALIDATOR);

        return new ConfirmTheWinAddBonusBallDTO(lastWeekWinningNumbers, bonusBall);
    }
}
