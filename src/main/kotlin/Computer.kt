class Computer() : Player {
    override val hand: MutableList<Card> = mutableListOf()

    fun showFirstDeal() {
        println("*******")
        hand.last() {
            when(it.value) {
                1 -> println("Aces of ${it.suit}")
                2,3,4,5,6,7,8,9,10 -> println("${it.value} of ${it.suit}")
                11 -> println("Jack of ${it.suit}")
                12 -> println("Queen of ${it.suit}")
                else -> println("King of ${it.suit}")
            }
            println(if (hand.last().value > 10) 10 else hand.last().value)
            println()
            return
        }
    }
}