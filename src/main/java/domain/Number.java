package domain;

public class Number {
    private int num;

    public Number(int num){
        this.num = num;
    }

    @Override
    public String toString(){
        return Integer.toString(num);
    }
}
