object Challenge {
  type Suite = String
  type Deck = List[Card]
  type Hand = List[Card] // TODO: Enforce size.
  case class Card(suite: Suite, number: Int)

  def fullDeck: Deck = {
    def suite(s: Suite) = List.range(1, 15).map(Card(s, _))
    def deck = suite("HE") ::: suite("RU") ::: suite("PA") ::: suite("RI")
    scala.util.Random.shuffle(deck ::: deck)
  }

  def takeHand(d: Deck): Hand = d.take(5)
  def suites(h: Hand): List[Suite] = h.map(_.suite)
  def numbers(h: Hand): List[Int] = h.map(_.number)
  def group(h: Hand) = numbers(h).groupBy(i => i).map(_._2.length).filter(_ > 1)

  def pair(h: Hand) = group(h) == List(2)
  def twoPairs(h: Hand) = group(h) == List(2, 2)
  def fullHouse(h: Hand) = group(h) == List(2, 3)
  def threeOfAKind(h: Hand) = group(h) == List(3)
  def flush(h: Hand) = suites(h).distinct.length == 1
  def straight(h: Hand) = {
    val first = numbers(h).distinct.sorted.head
    numbers(h).sorted == List.range(first, first + 5)
  }
  def straightFlush(h: Hand) = straight(h) && flush(h)

  def run = {
    val hand = takeHand(fullDeck)
    println(hand)
    straightFlush(hand)
  }
}

//Challenge.run