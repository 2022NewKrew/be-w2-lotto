package lottoStage1;

public class Number {
    private final int number;

    private Number() {
        number = RandomUtils.nextInt();
    }

    public static Number create() {
        return new Number();
    }

    public int getNumber() {
        return number;
    }
}
