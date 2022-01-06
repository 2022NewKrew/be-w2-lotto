package step3.domain;

import step2.domain.LottoConfig;

public class LottoConfigWithManual extends LottoConfig {

    private ManualLottoInnerConfig manualLottoInnerConfig;

    public LottoConfigWithManual(Integer purchaseAmount) {
        super(purchaseAmount);
    }

    public LottoConfigWithManual(Integer purchaseAmount, ManualLottoInnerConfig manualLottoInnerConfig) {
        super(purchaseAmount);
        this.manualLottoInnerConfig = manualLottoInnerConfig;
    }

    public ManualLottoInnerConfig getManualLottoInnerConfig() {
        return manualLottoInnerConfig;
    }

    public void setManualLottoInnerConfig(ManualLottoInnerConfig manualLottoInnerConfig) {
        this.manualLottoInnerConfig = manualLottoInnerConfig;
    }

    public int getNumberOfAuto(){
        if (manualLottoInnerConfig == null) return getNumberOfLotto();
        return getNumberOfLotto() - manualLottoInnerConfig.getNumberOfManual();
    }

    public int getNumberOfManual(){
        return manualLottoInnerConfig == null ? 0 : manualLottoInnerConfig.getNumberOfManual();
    }
}
