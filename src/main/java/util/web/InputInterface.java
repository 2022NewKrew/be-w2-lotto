package util.web;

import dto.request.LottoCheckDTO;
import dto.request.LottoPurchaseDTO;
import spark.Request;
import util.TypeConverter;
import util.Validator;

import java.util.*;
import java.util.stream.Collectors;

public class InputInterface {
    public LottoPurchaseDTO convertRequestToPurchaseDto(Request req) {
        final int budget = TypeConverter.convertStringToInteger(req.queryParams("inputMoney"), Validator.INTEGER_GREATER_THAN_OR_EQUAL_TO_1000);

        final String manualNumber = req.queryParams("manualNumber");

        if (manualNumber.equals(""))
            return new LottoPurchaseDTO(budget, 0, new ArrayList<>());

        final List<List<Integer>> manualLottoTickets = Arrays.stream(manualNumber.split("\r?\n"))
                .map(number -> {
                    final List<Integer> ticket = TypeConverter.convertStringToIntegerList(number, Validator.INTEGER_WITHIN_1_AND_45, Validator.LIST_SIZE_EQUAL_TO_6);
                    validateRedundantNumberInTicket(ticket);
                    return ticket;
                })
                .collect(Collectors.toList());

        final int numberOfManualLotto = manualLottoTickets.size();

        validatePurchaseMoreThanBudget(budget, numberOfManualLotto);

        return new LottoPurchaseDTO(budget, numberOfManualLotto, manualLottoTickets);
    }

    public LottoCheckDTO convertRequestToCheckDto(Request req) {
        final List<Integer> winningNumber = TypeConverter.convertStringToIntegerList(req.queryParams("winningNumber"), Validator.INTEGER_WITHIN_1_AND_45, Validator.LIST_SIZE_EQUAL_TO_6);

        final int bonusNumber = TypeConverter.convertStringToInteger(req.queryParams("bonusNumber"), Validator.INTEGER_WITHIN_1_AND_45);

        validateBonusNumberInWinningNumber(winningNumber, bonusNumber);

        return new LottoCheckDTO(winningNumber, bonusNumber);
    }

    void validatePurchaseMoreThanBudget(int budget, int numberofManualLotto) {
        int PRICE_OF_TICKET = 1000;

        if (budget < numberofManualLotto * PRICE_OF_TICKET)
            throw new IllegalArgumentException("구입 금액보다 적거나 같은 수의 수동 로또를 입력해야 합니다.");
    }

    void validateRedundantNumberInTicket(List<Integer> ticket) {
        Set<Integer> set = new HashSet<>(ticket);

        if (ticket.size() != set.size())
            throw new IllegalArgumentException("로또 번호는 중복되지 않은 숫자들로 이루어져야 합니다.");
    }

    void validateBonusNumberInWinningNumber(List<Integer> winningNumbers, int bonuseNumber) {
        if (winningNumbers.contains(bonuseNumber))
            throw new IllegalArgumentException("당첨 로또 번호와 보너스 번호는 중복되지 않아야 합니다.");
    }
}
