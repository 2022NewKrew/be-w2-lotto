package view;

import domain.Lotto;

import java.util.List;

public class ResultView {

    public static void printPurchaseResult(List<Lotto> lottos){
        printLottoCount(lottos);
        printLottos(lottos);
    }

    private static void printLottoCount(List<Lotto> lottos){
        System.out.printf("%d개 구매했습니다.\n", lottos.size());
    }

    private static void printLottos(List<Lotto> lottos){
        lottos.stream()
                .map(Object::toString)
                .forEach(System.out::println);
    }

}
