package domain;

public class LottoNumber {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static void validate(int number){
        if(number < MIN_NUMBER || number > MAX_NUMBER){
            throw new IllegalArgumentException("당첨번호는 "
                    .concat(String.valueOf(MIN_NUMBER)).concat("이상 ")
                    .concat(String.valueOf(MAX_NUMBER)).concat("이하입니다."));
        }
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(number);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof LottoNumber)){
            return false;
        }

        LottoNumber other = (LottoNumber) obj;
        return this.number == other.number;
    }
}
