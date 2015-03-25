import org.scalatest.FunSuite

import poker.Challenge._

class ChallengeSuite extends FunSuite {
  test("Full deck should have 112 cards") {
    assert(fullDeck.size == 4 * 14 * 2)
  }

  test("Full deck should be randomized") {
    assert(fullDeck != fullDeck) // There is a possibility that this fails :-)
  }

  test("Hand should have 5 cards") {
    assert(takeHand(fullDeck).size == 5)
  }

  test("Pair") {
    assert(
      pair(
        List(
          Card("HE", 2), Card("RU", 2), Card("HE", 3), Card("HE", 4), Card("HE", 5)
        )
      )
    )
  }
}