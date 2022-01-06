package service;

import domain.lotto.LottoOrder;

import java.util.*;
import java.util.stream.Collectors;

public class LottoInputService {

    private static final String LOTTO_REQUEST_DELIMITER = "\r?\n";
    private static final String INPUT_DELIMITER = ",";

    public List<LottoOrder> getManualLottoRequests(String manualString) {
        if (manualString.isEmpty()) {
            return Collections.emptyList();
        }
        String[] manualStringRequests = manualString.split(LOTTO_REQUEST_DELIMITER);

        return Arrays.stream(manualStringRequests)
                .map(this::parseLottoRequest)
                .collect(Collectors.toList());
    }

    public LottoOrder parseLottoRequest(String lottoRequest) {
        List<Integer> inputNumbers = inputNumbersToList(lottoRequest);
        return new LottoOrder(inputNumbers);
    }

    public int getIntegerFromString(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[에러] 반드시 숫자를 입력해야 합니다.");
        }
    }

    private List<Integer> inputNumbersToList(String inputString) {
        String[] inputStrings = inputString.split(INPUT_DELIMITER);
        try {
            return Arrays.stream(inputStrings)
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[에러] 반드시 숫자를 입력해야 합니다.");
        }
    }
}
