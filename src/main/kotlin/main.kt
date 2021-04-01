fun main(args: Array<String>) {

    var appOver = false
    var appInput: String
    while(!appOver) {
        println("1: New game")
        println("anything else: Quit")
        appInput = readLine() ?: ""
        when(appInput) {
            "1" -> {
                var gameInput: String
                var playerTurnOver = false
                var playerBust = false
                val game = Game()
                game.seeFirstDeal()
                while(!playerTurnOver) {
                    println("1: hit")
                    println("anything else: stop")
                    gameInput = readLine() ?: ""
                    when(gameInput) {
                        "1" -> {
                            game.playerHit()
                            if (game.isPlayerBlackJack()) {
                                game.seePlayerHand()
                                println("Player BlackJack!!!")
                                playerTurnOver = true
                            }
                            if (!game.isPlayerBust()) {
                                game.seePlayerHand()
                            }
                            else {
                                game.seePlayerHand()
                                println("Player bust")
                                playerTurnOver = true
                                playerBust = true
                            }
                        }
                        else -> playerTurnOver = true
                    }
                }

                println("----------")
                if (playerBust || game.isPlayerBlackJack()) {
                    if (playerBust)  {
                        println("Computer wins!")
                    }
                    else println("Game Over")
                }
                else {
                    game.seeComputerHand()
                    while(!game.isComputerDone()) {
                        game.computerHit()
                        game.seeComputerHand()
                        if (game.isComputerBust()) println("Computer bust!")
                    }
                }
                if (!game.isComputerBust() && game.isComputerWinner()) {
                    println("Computer wins!")
                }
                else {
                    if(!playerBust) println("Player wins")
                }
            }
            else -> appOver = true
        }
    }
}