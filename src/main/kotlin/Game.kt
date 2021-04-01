import players.Computer
import players.Player

class Game {
    val player: Player = Player()
    val computer: Computer = Computer()

    init {
        player.hit()
        computer.hit()
        player.hit()
        computer.hit()
    }

    companion object Deck {
        val cards = mutableListOf<Card>()
        init {
            for (suit in 1..4) {
                for (value in 1..13) {
                    when(suit) {
                        1 -> {cards.add(Card(value, "Hearts"))}
                        2 -> {cards.add(Card(value, "Clubs"))}
                        3 -> {cards.add(Card(value, "Diamonds"))}
                        4 -> {cards.add(Card(value, "Spades"))}
                    }
                }
            }
            cards.shuffle()
        }

        fun draw(): Card {
            val card = cards.last()
            cards.removeLast()
            return card
        }
    }

    fun seeFirstDeal() {
        this.player.seeHand()
        this.computer.showFirstDeal()
    }

    fun seePlayerHand() = this.player.seeHand()

    fun playerHit() = this.player.hit()

    fun seeComputerHand() = this.computer.seeHand()

    fun computerHit() = this.computer.hit()

    fun isPlayerBlackJack() = this.player.getHandValue() == 21

    fun isPlayerBust() = this.player.isBust()

    fun isComputerBust() = this.computer.isBust()

    fun isComputerDone() = this.computer.getHandValue() >= 17

    fun isComputerWinner() = this.computer.getHandValue() >= this.player.getHandValue()
}