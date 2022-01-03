package view;

import domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoView {

    public static void printLotto(Lotto lotto) {
        List<Integer> numberList = lotto.getNumberList();
        System.out.print("[");
        System.out.print(numberList.stream().map(v->v.toString()).collect(Collectors.joining(",")));
        System.out.println("]");
    }
}
