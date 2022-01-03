import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGame {
    private static final int PRICE_OF_LOTTO = 1000;
    private static final List<Integer> REWARDS = Arrays.asList(0, 0, 0, 5000, 50000, 1500000, 2000000000);

    private int purchased;
    private int numOfLotto;
    private Lotto winningLotto;
    private List<Lotto> lottos = new ArrayList<>();
    private List<Integer> numberOfWinnings = Arrays.asList(0, 0, 0, 0, 0, 0, 0);
    private long revenue;

    private UIView uiView = new UIView();

    public void startLottoGame() {
        this.revenue = 0;
        this.purchased = uiView.inputPurchased();
        this.numOfLotto = (int) this.purchased / PRICE_OF_LOTTO;
        uiView.purchaseCompleted(numOfLotto);
    }

    public void runLottoGame() {
        this.makeLottos();
        this.showLottos();
        this.winningLotto = new Lotto(uiView.inputWinningLotto());
        this.matchCountForLottos();
        uiView.print(revenue);
        uiView.showStatistics(this.numberOfWinnings, (int) (this.revenue * 100 / this.purchased));
    }

    private void makeLottos() {
        for (int i = 0; i < numOfLotto; i++) {
            lottos.add(new Lotto());
        }
    }

    private void showLottos() {
        for (Lotto lotto : lottos) {
            uiView.print(lotto.getLotto());
        }
    }

    private void matchCountForLottos() {
        for (Lotto lotto : lottos) {
            matchCountForSingleLotto(lotto);
        }
    }

    private void matchCountForSingleLotto(Lotto lotto) {
        int totalMatch = 0;
        for (int i = 0; i < Lotto.getLength(); i++) {
            totalMatch += numOfMatch(lotto.getLotto().get(i));
        }
        if (totalMatch >= 3) {
            this.numberOfWinnings.set(totalMatch, this.numberOfWinnings.get(totalMatch) + 1);
            this.revenue += REWARDS.get(totalMatch);
        }
    }

    private int numOfMatch(int number) {
        if (winningLotto.getLotto().contains(number)) {
            return 1;
        }
        return 0;
    }

    public static List<Integer> getRewards() { return REWARDS; }
}
