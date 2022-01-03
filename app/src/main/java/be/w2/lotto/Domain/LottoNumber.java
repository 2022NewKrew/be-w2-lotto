package be.w2.lotto.Domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{
    private final int number;

    public LottoNumber(int number){
        this.number = number;
    }

    public String toString(){
        return String.valueOf(number);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(number, o.getNumber());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
