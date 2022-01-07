package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static view.Sentence.COMMA;

public class SparkLottoInputController implements LottoServiceInputController{

    private int purchaseAmount;
    private int numberOfManualPurchase;
    private List<String> manualLottoNumbers = new ArrayList<>();
    private int manualLottoNumberIdx;
    private List<Integer> lastWeekWinningNumbers = new ArrayList<>();
    private int bonusBallNumber;

    @Override
    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    @Override
    public int getNumberOfManualPurchase() {
        return numberOfManualPurchase;
    }

    @Override
    public List<Integer> getManualLottoNumber() {
        return getNumbers(manualLottoNumbers.get(manualLottoNumberIdx++));
    }

    @Override
    public List<Integer> getLastWeekWinningNumbers() {
        return lastWeekWinningNumbers;
    }

    @Override
    public int getBonusBallNumber() {
        return bonusBallNumber;
    }

    public void setPurchaseAmount(String purchaseAmount) {
        this.purchaseAmount = Integer.parseInt(purchaseAmount);
    }

    public void setManualLottoNumbers(String manualLottoNumbers) {
        if(manualLottoNumbers.equals("")) {
            this.numberOfManualPurchase = 0;
            return;
        }

        this.manualLottoNumbers = Arrays.stream(manualLottoNumbers.split("\r\n")).collect(Collectors.toList());
        this.numberOfManualPurchase = this.manualLottoNumbers.size();
    }

    public void setLastWeekWinningNumbers(String lastWeekWinningNumbers) {
        this.lastWeekWinningNumbers = getNumbers(lastWeekWinningNumbers);
    }

    public void setBonusBallNumber(String bonusBallNumber) {
        this.bonusBallNumber = Integer.parseInt(bonusBallNumber);
    }

    private List<Integer> getNumbers(String manualLottoNumbers) {
        return Arrays.stream(manualLottoNumbers.replaceAll(" ", "").split(COMMA.getString()))
                .map(Integer::valueOf).collect(Collectors.toUnmodifiableList());
    }

    public void init() {
        purchaseAmount = 0;
        numberOfManualPurchase = 0;
        manualLottoNumbers = new ArrayList<>();
        manualLottoNumberIdx = 0;
        lastWeekWinningNumbers = new ArrayList<>();
        bonusBallNumber = 0;
    }
}
