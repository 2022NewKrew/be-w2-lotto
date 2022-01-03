package be.w2.lotto.lottos;

import java.util.List;

public class LottoService {

    public static String getStringOfLottos(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto)
                    .append("\n");
        }
        return sb.toString();
    }
}
