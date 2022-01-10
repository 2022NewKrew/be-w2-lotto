package domain;

import static utils.ErrorMessage.INVALID_OVER_BUY_LIMIT;
import static utils.ErrorMessage.format;

import domain.lottery.LotteryMachine;
import domain.lotto.Lotto;
import domain.lotto.LottoList;
import java.util.List;

/**
 * 로또 구매, 입출력, 당첨로또 추첨, 통계 리포트 등 로또 흐름을 관리하는 객체
 *
 * @author leo.jung
 * @since 1.0
 */
public class LottoManager {

  private final LottoList wallet;
  private final LotteryMachine lotteryMachine;

  public LottoManager() {
    this.wallet = LottoList.createEmpty();
    this.lotteryMachine = LotteryMachine.createEmpty();
  }


  public LottoList buyLotto(int purchaseAmount, LottoList manuallyBuyLotto) {
    int availableQuantity = getMaxPurchaseQuantity(purchaseAmount);
    int manualBuyQuantity = manuallyBuyLotto.size();
    int randomBuyQuantity = availableQuantity - manualBuyQuantity;

    validCheck(availableQuantity, manualBuyQuantity);

    wallet.addAll(manuallyBuyLotto);
    wallet.addRandomGenerated(randomBuyQuantity);
    return wallet;
  }


  private void validCheck(int availableQuantity, int manualBuyQuantity) {
    if(availableQuantity - manualBuyQuantity < 0) {
      throw new IllegalArgumentException(
          format(INVALID_OVER_BUY_LIMIT, availableQuantity, manualBuyQuantity));
    }
  }


  private int getMaxPurchaseQuantity(int amount) {
    return amount / Lotto.PRICE;
  }


//  private void setLastWinningNumber() throws IOException {
//    lotteryMachine.generateWinningLottery(reader);
//  }


//  private void reportWinningStatistics() throws IOException {
//    YieldStatistics statistics = YieldStatistics.of(
//        lotteryMachine.getCurrentWinningLottery(), wallet);
//    writer.write(statistics);
//  }

}
