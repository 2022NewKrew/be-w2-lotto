import controller.CheckPrize;
import domain.LottoPack;
import view.LottoInput;
import view.LottoOutput;

public class LottoApp {
    public static void main(String[] args) {
        LottoPack lottoPack = LottoInput.inputBuyLottoPrize();
        LottoOutput.printLottoPack(lottoPack);
        CheckPrize.printPrize(lottoPack, LottoInput.inputLastPrizeNum());
    }
}
