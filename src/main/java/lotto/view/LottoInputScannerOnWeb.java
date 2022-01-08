package lotto.view;

import static lotto.controller.LottoSimulator.SEPARATOR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoNumber;

public class LottoInputScannerOnWeb implements LottoInputScanner {

    private long purchaseAmount;
    private long numOfManualLottos;
    private List<String> manualLottoNumberStringList;
    private List<LottoNumber> winningLottoNumberList;
    private LottoNumber bonusNumber;


    public long getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(String purchaseAmountStr) {
        this.purchaseAmount = Long.parseLong(purchaseAmountStr);
    }

    public long getNumOfManualLottos() {
        return numOfManualLottos;
    }

    public List<String> getManualLottoNumberStringList(long ignoredNumOfManualLottos) {
        return manualLottoNumberStringList;
    }

    public List<LottoNumber> getWinningLottoNumberList() {
        return winningLottoNumberList;
    }

    public void setWinningLottoNumberList(String winningLottoNumbers) {
        this.winningLottoNumberList = Arrays.stream(winningLottoNumbers.split(SEPARATOR))
            .map(s -> new LottoNumber(Integer.parseInt(s.trim())))
            .collect(Collectors.toList());
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(String bonusNumberStr) {
        int bonusNumberInt = Integer.parseInt(bonusNumberStr);
        this.bonusNumber = new LottoNumber(bonusNumberInt);
    }

    public void setManualLottoNumberStringList(String manualLottoNumbers) {
        if (manualLottoNumbers.equals("")) {
            this.numOfManualLottos = 0;
            return;
        }

        this.manualLottoNumberStringList = Arrays.stream(manualLottoNumbers.split("\r\n")).collect(
            Collectors.toList());
        this.numOfManualLottos = this.manualLottoNumberStringList.size();
    }

    public void init() {
        purchaseAmount = 0;
        numOfManualLottos = 0;
        manualLottoNumberStringList = new ArrayList<>();
        winningLottoNumberList = new ArrayList<>();
        bonusNumber = new LottoNumber(1);
    }
}
