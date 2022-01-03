package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numList = new ArrayList<>();

    public Lotto() {
        init_numList();
    }

    private void init_numList() {
        for (int i = 1; i <= 45; i++) {
            numList.add(i);
        }
    }

    public List<Integer> pick() {
        Collections.shuffle(numList);
        List<Integer> res = numList.subList(0, 6);
        Collections.sort(res);
        return res;
    }

}
