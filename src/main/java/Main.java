import controller.ResultController;
import controller.StartController;
import domain.MatchStore;
import domain.MyLottoLines;

public class Main {
    public static void main(String[] args) {
        StartController sm = new StartController();

        MyLottoLines myLottoLines = sm.getLottoLines();
        MatchStore matchStore = new MatchStore();

        myLottoLines.checkWinning(matchStore, sm.getWinningLine().getLottoLine(), sm.getWinningLine().getBonusList());

        ResultController.printResult(matchStore);
    }
}
