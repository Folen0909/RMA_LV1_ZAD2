data class Card constructor(val value: Int, val suit: String) {

    fun getCardName() {
        when (value) {
            1 -> println("Aces of ${suit}")
            2, 3, 4, 5, 6, 7, 8, 9, 10 -> println("${value} of ${suit}")
            11 -> println("Jack of ${suit}")
            12 -> println("Queen of ${suit}")
            13 -> println("King of ${suit}")
        }
    }
}