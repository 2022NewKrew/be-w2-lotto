package lotto;

import lotto.domain.Lotto;
import lotto.view.LottoViewInput;

public class Main {
    public static void main(String[] args){
        Lotto lottoObject = new Lotto(LottoViewInput.lottoInitialInput());
    }
}
