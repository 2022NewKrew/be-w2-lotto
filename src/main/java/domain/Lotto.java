package domain;

import java.util.*;
import java.util.stream.Collectors;

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

    public List<Integer> autoPick() {
        Collections.shuffle(numList);
        List<Integer> res = numList.subList(0, 6);
        Collections.sort(res);
        new LottoValidation(res);
        return res;
    }

    public List<Integer> manuallyPick(){
        Scanner sc = new Scanner(System.in);
        List<Integer> res = Arrays.stream(sc.nextLine().split(",")).map(Integer::parseInt).collect(Collectors.toList());
        new LottoValidation(res);
        return res;
    }



}
