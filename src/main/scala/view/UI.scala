package view
import scala.io.StdIn._
import domain.Constants._
import domain.{Lotto, Rank}
import scala.collection.mutable

object UI {
  def getMoney: (Int, Int) = {
    println("구입금액을 입력해 주세요.")
    val money = readInt()
    val numberOfLottos = money / LOTTO_PRICE
    println(s"${numberOfLottos}개를 구매했습니다.")
    (money, numberOfLottos)
  }

  def printAllLottos(lottos: List[Lotto]): Unit = {
    lottos.foreach(x => println(x.numbers.mkString("[", ", ", "]")))
  }

  def getAnswerLotto: Lotto = {
    println("\n지난 주 당첨 번호를 입력해 주세요.")
    new Lotto(readLine().split(",").map(_.toInt).toList)
  }

  def getBonusBall: Int = {
    println("\n보너스 볼을 입력해 주세요.")
    readInt()
  }

  def printResults(results: mutable.Map[Rank, Int], yd: Double): Unit = {
    println("\n당첨 통계\n---------")
    Rank.values.foreach(x => println(s"${x.numOfMatch}개 일치 (${x.reward}원)- ${results.getOrElse(x, 0)}개"))
    println("총 수익률은 %.2f%%입니다.".format(yd))
  }
}
