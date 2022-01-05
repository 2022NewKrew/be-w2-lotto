package model.scan;

import validator.LottoNumberValidator;
import validator.ValidatorInterface;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberScanner extends InputData {
    public LottoNumberScanner() {
    }

    public static List<Integer> getLottoNumbers() {
        ValidatorInterface validatorInterface = new LottoNumberValidator();
        String winningNumbers = validateAndGetInput(validatorInterface);
        return convertToList(winningNumbers);
    }

    private static List<Integer> convertToList(String winningNumbers) {
        List<Integer> listWinningNumber = new ArrayList<>();
        for (String number : winningNumbers.split(",")) {
            listWinningNumber.add(Integer.parseInt(number));
        }

        return listWinningNumber;
    }
}
