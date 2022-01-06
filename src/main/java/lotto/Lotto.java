package lotto;

import lotto.Server.LottoServer;
import lotto.domain.LottoManager;

public class Lotto {
    public static void main(String[] args) {
        LottoServer ls = new LottoServer();
        ls.start();

        LottoManager lm = new LottoManager();
        lm.start();
    }
}
