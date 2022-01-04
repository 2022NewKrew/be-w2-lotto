package domain;


import java.util.Objects;

public class Number implements Comparable<Number>{
    private int num;

    public Number(int num){
        this.num = num;
    }
    
    public int getNum(){
        return this.num;
    }
    @Override
    public String toString(){
        return Integer.toString(num);
    }

    @Override
    public int compareTo(Number o) {
        return this.getNum() - o.getNum() ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return num == number.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}
