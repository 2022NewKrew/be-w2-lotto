import domain.LottoPaper;
import view.LottoUI;

public class LottoMain {
    public static void main(String[] args) {
        long money = LottoUI.inputMoney();

        LottoPaper lottoPaper = new LottoPaper(money);
        LottoUI.outputLotto(lottoPaper.countLotto(), lottoPaper.toString());

        // 당첨번호 입력하면 arraylist 반환해서 저장
        // 당첨 통계 계산 후 출력
    }
}
