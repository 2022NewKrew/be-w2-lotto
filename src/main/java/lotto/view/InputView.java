package lotto.view;

import lotto.domain.Constants;
import lotto.domain.LottoTicket;
import lotto.service.LottoTicketFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static final String LINE_DELIMITER = "\r?\n";

    public int inputPurchaseAmount(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) / Constants.LOTTO_PRICE;
    }

    public List<LottoTicket> inputManualLottoNumbers(String manualNumber, int purchaseCount) {
        String[] manualNumbers = manualNumber.split(LINE_DELIMITER);
        validateManualPurchaseCount(purchaseCount, manualNumber.length());

        List<LottoTicket> lottoNumbers = new ArrayList<>();
        for (String number : manualNumbers) {
            lottoNumbers.add(LottoTicketFactory.createManualLottoTicket(number));
        }
        return lottoNumbers;
    }

    private void validateManualPurchaseCount(int purchaseCount, int manualPurchaseCount) {
        if (purchaseCount - manualPurchaseCount < 0) {
            throw new IllegalArgumentException("구입한 로또의 수보다 더 많은 수동 로또를 구매할 수 없습니다.");
        }
    }

    public int inputBonusNumber(LottoTicket winningNumbers, int bonusNumber) {
        validateBonusNumber(winningNumbers, bonusNumber);
        return bonusNumber;
    }

    private void validateBonusNumber(LottoTicket winningNumbers, int bonusNumber) {
        if (winningNumbers.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 볼은 중복될 수 없습니다.");
        }
    }
}
