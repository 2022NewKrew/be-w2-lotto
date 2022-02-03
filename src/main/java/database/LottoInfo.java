package database;

public class LottoInfo {
    private static LottoInfo lottoInfo = null;
    private int money;
    private int amountOfManual;

    public int getMoney() {
        return money;
    }

    private LottoInfo() {
    }

    public static LottoInfo getLottoInfo() {
        if (lottoInfo == null) {
            lottoInfo = new LottoInfo();
        }
        return lottoInfo;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setAmountOfManual(int amountOfManual) {
        this.amountOfManual = amountOfManual;
    }
}
