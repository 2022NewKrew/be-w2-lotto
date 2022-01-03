import domain.Matching;
import domain.Player;
import domain.UserInput;
import view.MatchingView;
import view.PlayerView;

public class main {
    public static void main(String[] args) {

        Player player = new Player(UserInput.getIntegerInput("구입금액을 입력해 주세요.","양의 점수를 입력해 주세요."));

        PlayerView playerView = new PlayerView(player);
        playerView.PrintPlayerLottoList();

        Matching matching = new Matching(UserInput.getWinningInput("지난 주 당첨 번호를 입력해 주세요."));
        matching.matchPlayer(player);

        MatchingView matchingView = new MatchingView(matching, player);
        matchingView.PrintMatchResult();
    }
}
