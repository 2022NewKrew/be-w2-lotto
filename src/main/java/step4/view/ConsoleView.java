package step4.view;

import step4.service.domain.LottoTicket;
import step4.view.dto.LottoGameResult;

import java.util.List;
import java.util.Map;

public class ConsoleView implements View<Void>{

    @Override
    public Void getStartPage() {
        return null;
    }

    @Override
    public Void showResult(Map map) {
        System.out.printf("당첨 통계\n=========\n");
        LottoGameResult lottoGameResult = (LottoGameResult)map.get("lottosResult");
        lottoGameResult.getMessage().stream().forEach(System.out::println);
        System.out.println("총 수익률은 " + lottoGameResult.getProfitRate() + "%입니다.");
        return null;
    }

    @Override
    public Void showTickets(Map map) {
        List<LottoTicket> tickets = (List<LottoTicket>) map.get("lottos");
        tickets.stream().forEach(System.out::println);
        return null;
    }
}