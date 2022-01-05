package be.w2.lotto.cashier;

public class OrderSheet {
    private int numOfAuto;
    private int numOfManual;

    public OrderSheet(int numOfAuto, int numOfManual) {
        this.numOfAuto = numOfAuto;
        this.numOfManual = numOfManual;
    }

    public int getNumOfAuto() {
        return numOfAuto;
    }

    public int getNumOfManual() {
        return numOfManual;
    }

    public int getNumOfLotto() {
        return numOfAuto + numOfManual;
    }
}
