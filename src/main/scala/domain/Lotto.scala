package domain
import scala.util.Random.shuffle
import domain.Constants._
import scala.collection.mutable.ListBuffer

class Lotto(_numbers: List[Int]) {
  def numbers: List[Int] = _numbers
}

object Lotto {
  def apply() : Lotto = new Lotto(shuffle((1 to 45).toList).take(LOTTO_SIZE).sorted)

  def makeRandomLottos(numberOfLottos: Int): List[Lotto] = {
    val lottos = new ListBuffer[Lotto]()
    for (_ <- 1 to numberOfLottos) lottos += Lotto()
    lottos.toList
  }
}
