package domain.lottery;

/**
 * 당청 로또를 뽑는 모듈, WinningLottery 의 생성과 반환 역할을 한다.
 *
 * @author leo.jung
 * @since 1.0
 */
public class LotteryMachine {

  private WinningLotto winningLotto;


  private LotteryMachine() {
    this.winningLotto = null;
  }


  public static LotteryMachine createEmpty() {
    return new LotteryMachine();
  }

}
