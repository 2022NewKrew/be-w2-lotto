package domain
import scala.collection.mutable

class LottoStatistics(money: Int, lottos: List[Lotto], answerLotto: Lotto, bonusBall: Int) {
  def evaluateLotto(lotto: Lotto): (Int, Boolean) = {
    (lotto.numbers.intersect(answerLotto.numbers).size,
      lotto.numbers.contains(bonusBall))
  }

  def makeResults: (mutable.Map[Rank, Int], Double) = {
    val results = mutable.Map[Rank, Int]()
    lottos.map(evaluateLotto).foreach {
      case Rank(x) => results(x) = results.getOrElse(x, 0) + 1
      case _ =>
    }
    val yd = results.foldLeft(0)((x,y) => x + y._2 * y._1.reward).toDouble / money * 100 - 100
    (results, yd)
  }
}
