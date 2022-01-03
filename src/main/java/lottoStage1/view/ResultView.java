package lottoStage1.view;

import lottoStage1.Lotto;
import lottoStage1.Lottos;

import java.util.stream.Collectors;

public class ResultView {

    public static void showLottoCount(Lottos lottos) {
        System.out.println(lottos.getLottos().size() + " 개를 구매했습니다.");
    }

    public static void showAllLottoNumbers(Lottos lottos) {
        for(Lotto lotto : lottos.getLottos()) {
            System.out.println("[" + prettyLottoNumber(lotto) + "]");
        }
    }

    private static String prettyLottoNumber(Lotto lotto) {
        return lotto.getLottoNumbers().stream()
                .map(number -> String.valueOf(number.getNumber()))
                .collect(Collectors.joining(", "));
    }
}
