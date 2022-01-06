import controller.BuyLotto;
import controller.CheckPrize;
import domain.LottoPack;
import view.LottoInput;

public class LottoApp {
    public static void main(String[] args) {
        LottoPack lottoPack = LottoInput.inputBuyLottoPrize();
        BuyLotto.printLottoPack(lottoPack);
        CheckPrize.printPrize(lottoPack, LottoInput.inputLastPrizeNum(),LottoInput.inputBonusBall());
    }
}
