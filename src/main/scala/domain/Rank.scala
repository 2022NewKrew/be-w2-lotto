package domain

case class Rank(numOfMatch: Int, reward: Int)

object Rank {
  final val FIRST = Rank(6, 2000000000)
  final val SECOND = Rank(5, 30000000)
  final val THIRD = Rank(5, 1500000)
  final val FOURTH = Rank(4, 50000)
  final val FIFTH = Rank(3, 5000)
  final val values = Iterable(FIRST, SECOND, THIRD, FOURTH, FIFTH)

  def unapply(tuple: (Int, Boolean)): Option[Rank] = {
    tuple match {
      case (6, _) => Some(FIRST)
      case (5, true) => Some(SECOND)
      case (5, false) => Some(THIRD)
      case (4, _) => Some(FOURTH)
      case (3, _) => Some(FIFTH)
      case _ => None
    }
  }
}

