
import com.cocharge.game.model.Choice
import com.cocharge.game.model.Choice.ROCK
import com.cocharge.game.model.Result
import com.cocharge.game.service.Game
import com.cocharge.game.service.GameManager
import com.cocharge.game.service.RockPaperScissorsGame

fun main() {

    val game = RockPaperScissorsGame()
    val gameManager = GameManager(game)
    val result = gameManager.playRounds(rounds = 100, playerAChoice = ROCK)
    println("Player A wins ${result.playerAWins} of 100 games")
    println("Player B wins ${result.playerBWins} of 100 games")
    println("Draws: ${result.draws} of 100 games")
}