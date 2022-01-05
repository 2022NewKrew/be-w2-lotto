import domain.LottoSimulator;
import view.LottoInterface;

public class LottoMain {
    public static void main(String[] args) {
        new LottoSimulator(new LottoInterface()).run();
    }
}
