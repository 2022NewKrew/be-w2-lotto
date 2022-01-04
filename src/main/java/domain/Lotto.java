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

    public ArrayList<Number> getNumberList(){
        return this.numberList;
    }

    public int getHitCount(Lotto winningLotto){
        int hitCount = 0;
        ArrayList<Number> winningLottos = winningLotto.getNumberList();
        for(Number number : winningLottos){
            hitCount += isHit(number);
        }
        return hitCount;
    }

    public int isHit(Number bonusNumber){
        int hitCount = (numberList.contains(bonusNumber))? 1 : 0;
        return hitCount;
    }
}
