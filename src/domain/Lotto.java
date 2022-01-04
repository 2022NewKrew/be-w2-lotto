package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto implements ILotto{

    private List<Integer> numbers;
    public Lotto(){
        createNum();
    }
    public Lotto(List<Integer> lotto){
        createNum(lotto);
    }

    @Override
    public void createNum() {
        List<Integer> range = new ArrayList<>();
        for(int i=MINNUM; i<=MAXNUM; i++){
            range.add(i);
        }
        Collections.shuffle(range);
        this.numbers = range.subList(0,SIZE);
    }

    @Override
    public void createNum(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> getNumbers() { return this.numbers; }

}
