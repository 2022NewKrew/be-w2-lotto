package view;

import domain.Lotto;
import domain.Person;
import domain.Rank;

import java.util.List;

public class LottoView {

    private final Person buyer;

    public LottoView(Person buyer) {
        this.buyer = buyer;
    }

    public void showLotto() {
        StringBuilder result = new StringBuilder();
        List<Lotto> lottoList = buyer.getLottoList();
        result.append(lottoList.size()).append("개를 구입했습니다.\n");

        for (Lotto lotto : lottoList) {
            result.append(lotto.getLottoNumbers()).append("\n");
        }
        System.out.println(result);
    }

    public void showResult(){
        System.out.println("당첨 통계\n---------");
        Rank.showAllRank();
        System.out.println("총 수입률은 "+buyer.getIncomeRate()+"%입니다.");
    }

}
