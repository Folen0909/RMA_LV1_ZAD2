fun main(args: Array<String>) {

    var appOver = false
    var appinput: String
    while(!appOver) {
        println("1: New game")
        println("anything else: Quit")
        appinput = readLine() ?: ""
        when(appinput) {
            "1" -> {
                var gameInput: String
                var playerTurnOver = false
                var isPlayerBust = false
                val game = Game()
                game.player.seeHand()
                game.computer.showFirstDeal()
                while(!playerTurnOver) {
                    println("hit: get one more card")
                    println("anything else: stop at current number")
                    gameInput = readLine() ?: ""
                    when(gameInput) {
                        "hit" -> {
                            if (!game.player.hit()) {
                                game.player.seeHand()
                            }
                            else {
                                game.player.seeHand()
                                println("Player bust")
                                playerTurnOver = true
                                isPlayerBust = true
                            }
                        }
                        else -> playerTurnOver = true
                    }
                }
                println("----------")
                if(isPlayerBust) {
                    println("Computer wins!")
                }
                else {
                    game.computer.seeHand()
                    while(game.computer.getHandValue() in 0..17) {
                        if (!game.computer.hit()) {
                            game.computer.seeHand()
                        }
                        else {
                            game.computer.seeHand()
                            println("Computer bust, player wins!")
                        }
                    }
                }
                if (game.computer.getHandValue() <= 21 && game.computer.getHandValue() >= game.player.getHandValue()) {
                    println("Computer wins!")
                }
                else {
                    if(!isPlayerBust) println("Player wins")
                }
            }
            else -> appOver = true
        }
    }
}