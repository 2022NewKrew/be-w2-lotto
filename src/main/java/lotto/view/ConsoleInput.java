package lotto.view;

import lotto.util.ResourceManager;
import lotto.util.TypeConverter;
import lotto.util.Validator;

import java.util.List;

public class ConsoleInput implements InputInterface {

    @Override
    public long inputBudget() throws IllegalArgumentException{
        System.out.println("구입금액을 입력해 주세요.");
        long budget = Long.parseLong(ResourceManager.SCANNER.nextLine());//nextLong();
        Validator.checkBudget(budget);
        return budget;
    }

    @Override
    public List<Integer> inputWinningNumbers() throws IllegalArgumentException {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumbersStr = ResourceManager.SCANNER.nextLine();
        List<Integer> winningNumbers = TypeConverter.strToIntegerList(winningNumbersStr);
        Validator.checkLottoNumbersFormat(winningNumbers);
        return winningNumbers;
    }

    @Override
    public int inputBonusNumber(List<Integer> winningNumbers) throws IllegalArgumentException {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = Integer.parseInt(ResourceManager.SCANNER.nextLine());
        Validator.checkLottoNumberRange(bonusNumber);
        Validator.checkBonusNumberAndWinningNumbersDuplication(winningNumbers, bonusNumber);
        return 0;
    }

}
