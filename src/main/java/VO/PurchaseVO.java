package VO;

import java.util.List;

public class PurchaseVO {
    private int money;
    private int manualAmount;
    private List<String> manualLottoStringList;

    public PurchaseVO(int money, int manualAmount, List<String> manualLottoStringList) {
        this.money = money;
        this.manualAmount = manualAmount;
        this.manualLottoStringList = manualLottoStringList;
    }

    public int getMoney() {
        return money;
    }

    public int getManualAmount() {
        return manualAmount;
    }

    public List<String> getManualLottoStringList() {
        return manualLottoStringList;
    }
}
