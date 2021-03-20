class Game {
    val player: Player = User()
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
}