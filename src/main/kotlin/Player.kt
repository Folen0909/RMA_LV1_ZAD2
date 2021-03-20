interface Player {
    val hand: MutableList<Card>

    fun hit(): Boolean {
        hand.add(Game.draw())
        return isBust()
    }

    fun seeHand() {
        hand.forEach {
            when(it.value) {
                1 -> println("Aces of ${it.suit}")
                2,3,4,5,6,7,8,9,10 -> println("${it.value} of ${it.suit}")
                11 -> println("Jack of ${it.suit}")
                12 -> println("Queen of ${it.suit}")
                13 -> println("King of ${it.suit}")
            }
        }
        println(getHandValue())
        println()
    }

    fun getHandValue(): Int {
        var value = 0
        hand.forEach {
            value += if (it.value > 10) 10 else it.value
        }
        return value
    }

    fun isBust() = getHandValue() > 21
}
