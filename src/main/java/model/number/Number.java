package model.number;

public class Number implements Comparable<Number> {

    public static int START_NUMBER = 1;
    public static int FINAL_NUMBER = 45;

    public static int convertToInt(Number number) {
        return number.number;
    }

    private final int number;

    public Number(int number) {
        NumberPrecondition.checkNumber(number);
        this.number = number;
    }

    @Override
    public int compareTo(Number otherNumber) {
        return Integer.compare(this.number, otherNumber.number);
    }

}
