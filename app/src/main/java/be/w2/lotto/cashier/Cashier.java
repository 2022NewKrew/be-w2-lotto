package be.w2.lotto.cashier;

import be.w2.lotto.exceptions.NonValidPurchaseAmountException;
import be.w2.lotto.lottos.Lotto;
import be.w2.lotto.machines.AutoPurchaseMachine;
import be.w2.lotto.machines.ManualPurchaseMachine;
import be.w2.lotto.machines.PurchaseMachine;
import be.w2.lotto.messages.ErrorMessage;
import be.w2.lotto.precondition.Precondition;

import java.util.ArrayList;
import java.util.List;

public class Cashier {
    public static final int PRICE_PER_LOTTO = 1000;

    public static OrderSheet createOrderSheet(int purchaseAmount, int numOfManual) {
        int amountForAuto = purchaseAmount - numOfManual * PRICE_PER_LOTTO;
        Precondition.notLessThanInt(purchaseAmount, 0, new NonValidPurchaseAmountException(ErrorMessage.CAN_NOT_BUY_OVER_AMOUNT));

        int numOfAuto = amountForAuto / PRICE_PER_LOTTO;
        return new OrderSheet(numOfAuto, numOfManual);
    }

    public static List<Lotto> createLottoByOrder(OrderSheet orderSheet) {
        List<Lotto> lottos = new ArrayList<>(orderSheet.getNumOfLotto());

        List<Lotto> lottosByManual = createLottoByMachine(new ManualPurchaseMachine(), orderSheet.getNumOfManual());
        lottos.addAll(lottosByManual);

        List<Lotto> lottsByAuto = createLottoByMachine(new AutoPurchaseMachine(), orderSheet.getNumOfAuto());
        lottos.addAll(lottsByAuto);
        return lottos;
    }

    private static List<Lotto> createLottoByMachine(PurchaseMachine purchaseMachine, int numOfLotto) {
        return purchaseMachine.purchaseLottos(numOfLotto);
    }
}
