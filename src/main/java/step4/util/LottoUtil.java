package step4.util;

import step4.service.domain.LottoBundle;
import step4.view.dto.LottoGameResult;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * LottoService에 두기 적합하지 않다고 판단되는 로직들을 담아두었습니다.
 */
public class LottoUtil {

    public static String removeExp(double num) {
        return new BigDecimal(num).toPlainString();
    }

    /**
     * 뷰에게 넘겨주기 위해 ModelAndView를 만들기위한 메서드 입니다.
     * @param lottoTickets
     * @return
     */
    public static Map createShowPageModel(LottoBundle lottoTickets) {
        Map model = new HashMap<>();
        model.put("lottosSize", lottoTickets.getTicketAmount());
        model.put("lottos", lottoTickets.getTicketBundle());
        return model;
    }


    public static Map createResultModel(LottoGameResult gameResult) {
        Map model = new HashMap<>();
        model.put("lottosResult", gameResult);
        model.put("totalRateOfReturn", gameResult.getProfitRate());
        return model;
    }
}
