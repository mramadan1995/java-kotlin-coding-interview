
import com.cocharge.game.model.Choice.LIZARD
import com.cocharge.game.model.Choice.ROCK
import com.cocharge.game.service.GameManager
import com.cocharge.game.service.RockPaperScissorsGame

fun main() {

    val game = RockPaperScissorsGame()
    val gameManager = GameManager(game)
    val result = gameManager.playRounds(rounds = 100)
    println("Player A wins ${result.playerAWins} of 100 games")
    println("Player B wins ${result.playerBWins} of 100 games")
    println("Draws: ${result.draws} of 100 games")
}