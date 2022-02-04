package database;

public class LottoInfo {
    private static LottoInfo lottoInfo = null;
    private int money;
    private int amountOfManual;

    private LottoInfo() {
    }

    public static LottoInfo getLottoInfo() {
        if (lottoInfo == null) {
            lottoInfo = new LottoInfo();
        }
        return lottoInfo;
    }

    public int getMoney() {
        return money;
    }

    public int getAmountOfManual() {
        return amountOfManual;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setAmountOfManual(int amountOfManual) {
        this.amountOfManual = amountOfManual;
    }
}
