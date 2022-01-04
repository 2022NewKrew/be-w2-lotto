import domain.Matching;
import domain.Player;
import domain.UserInput;
import view.MatchingView;
import view.PlayerView;

public class main {
    public static void main(String[] args) {

        Player player = new Player(UserInput.getPayPriceInput());

        PlayerView playerView = new PlayerView(player);
        playerView.PrintPlayerLottoList();

        Matching matching = new Matching(UserInput.getWinningInput());
        matching.matchPlayer(player);

        MatchingView matchingView = new MatchingView(matching, player);
        matchingView.PrintMatchResult();
    }
}
