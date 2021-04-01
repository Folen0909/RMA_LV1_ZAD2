class Hand {
    val hand = mutableListOf<Card>()

    fun hit() = this.hand.add(Game.draw())

    fun getHandValue(): Int {
        var value = 0
        this.hand.forEach {
            value += if (it.value > 10) 10 else it.value
        }
        return value
    }

    fun seeHand() {
        this.hand.forEach{ it.getCardName() }
        this.getHandValue()
        println()
    }

    fun isBust() = getHandValue() > 21
}