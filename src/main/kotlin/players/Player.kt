package players

import Hand

open class Player {
    val playerHand = Hand()

    fun hit() = this.playerHand.hit()

    fun seeHand() = this.playerHand.seeHand()

    fun getHandValue() = this.playerHand.getHandValue()

    fun isBust() = this.playerHand.isBust()
}