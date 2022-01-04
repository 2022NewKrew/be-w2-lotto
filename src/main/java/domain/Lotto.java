package domain;

import java.util.ArrayList;
import java.util.Arrays;

public class Lotto{
    private ArrayList<Number> numberList;

    public Lotto(ArrayList<Number> numberList){
        this.numberList = numberList;
    }

    @Override
    public String toString(){
        String lottoList = Arrays.toString(numberList.toArray());
        return lottoList;
    }
}
