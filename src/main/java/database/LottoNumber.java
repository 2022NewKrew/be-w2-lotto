package database;

public class LottoNumber {
    private int number;
    private boolean isBonus;

    public LottoNumber(int number) {
        this.number = number;
        this.isBonus = false;
    }

    public LottoNumber(int number, boolean isBonus) {
        this.number = number;
        this.isBonus = isBonus;
    }

    public int getNumber() {
        return number;
    }
}
