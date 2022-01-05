package lotto.domain.purchase;

import lotto.domain.player.PlayerLotto;

import java.util.List;

public class LottoPurchaseMachine {

    public static PlayerLotto purchaseAutoLotto(){
        return new PlayerLotto();
    }

    public static PlayerLotto purchaseManualLotto(List<Integer> numbers){
        return new PlayerLotto(numbers);
    }

}
