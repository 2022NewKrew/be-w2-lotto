package service;

import domain.lotto.*;
import dto.LottoRequest;

import java.util.*;
import java.util.stream.Collectors;

import static domain.lotto.LottoValidator.*;

public class LottoInputService {

    private static final String LOTTO_REQUEST_DELIMITER = "\r?\n";
    private static final String INPUT_DELIMITER = ",";


    public int getMoney(String inputMoney) {
        try {
            return Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[에러] 반드시 숫자를 입력해야 합니다.");
        }
    }

    public List<LottoRequest> getManualLottoRequests(String manualString) {
        String[] manualStringRequests = manualString.split(LOTTO_REQUEST_DELIMITER);

        return Arrays.stream(manualStringRequests)
                .map(this::getManualLottoRequest)
                .collect(Collectors.toList());
    }

    private LottoRequest getManualLottoRequest(String manualStringRequest) {
        List<Integer> inputNumbers = inputNumbersToList(manualStringRequest);
        validateInputNumbers(inputNumbers);
        return new LottoRequest(inputNumbers);
    }

    public WinningLotto inputWinningLottoNumbers() {
        List<Integer> inputWinningNumbers;
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        inputWinningNumbers = inputNumbersToList("");
        validateInputNumbers(inputWinningNumbers);

        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusLottoNumber = -1;
        validateBonusLottoNumber(inputWinningNumbers, bonusLottoNumber);

        return LottoGenerator.generateWinningLotto(inputWinningNumbers, bonusLottoNumber);
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
