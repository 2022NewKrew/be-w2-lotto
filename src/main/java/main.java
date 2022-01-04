import domain.Lotto;
import domain.Matching;
import domain.Player;
import domain.UserInput;
import view.LottoView;
import view.MatchingView;
import view.PlayerView;

import java.util.List;
import java.util.stream.Collectors;

public class main {
    private static Player player;
    private static PlayerView playerView = new PlayerView();
    private static LottoView lottoView = new LottoView();
    private static Matching matching = new Matching();
    private static List<Integer> winningNumber;
    public static void main(String[] args) {

        player = new Player(UserInput.getPayPriceInput());
        printLottoList();
        printLottoSize();
        addMatchingLotto();

        MatchingView matchingView = new MatchingView(matching, player);
        matchingView.PrintMatchResult();
    }
    private static void printLottoList()
    {
        List<Lotto> lottoList = player.getLottoList();
        for(Lotto lotto : lottoList)
        {
            List<Integer> numberList = lotto.getNumberList();
            String lottoNumber = numberList.stream().map(v -> v.toString()).collect(Collectors.joining(","));
            lottoView.printLottoNumber(lottoNumber);
        }
    }
    private static void printLottoSize() {
        playerView.PrintLottoSize(player.getLottoList().size());
    }
    private static void addMatchingLotto()
    {
        winningNumber= UserInput.getWinningInput();
        List<Integer> matchingLottos = player.matchingLotto(winningNumber);
        for(Integer num : matchingLottos)
        {
            matching.addMatchMap(num);
        }
    }
}
