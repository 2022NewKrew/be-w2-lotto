import domain.{Lotto, LottoStatistics}
import view.UI

object Main extends App {
  val (money, numberOfLottos) = UI.getMoney
  val lottos = Lotto.makeRandomLottos(numberOfLottos)
  UI.printAllLottos(lottos)
  val answerLotto = UI.getAnswerLotto
  val bonusBall = UI.getBonusBall
  val statistics = new LottoStatistics(money, lottos, answerLotto, bonusBall)
  val (results, yd) = statistics.makeResults
  UI.printResults(results, yd)
}
