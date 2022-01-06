package controller;

import domain.Lotto;
import domain.LottoList;
import domain.LottoResult;
import domain.Rank;
import input.LottoInput;

import java.text.DecimalFormat;
import java.util.*;

public class WebLottoController {
    private final LottoInput lottoInput = new LottoInput();
    private LottoList lottoList;
    private LottoResult lottoResult;

    public Map<String, Object> buyLotto(String inputMoney, String manualLotto) throws IllegalArgumentException{
        Map<String, Object> model = new HashMap<>();
        lottoList = new LottoList();

        int price = lottoInput.inputPrice(inputMoney);

        if(!manualLotto.equals("")){
            List<Lotto> lottos = lottoInput.inputManualLotto(manualLotto, price);
            lottoList.createManualLottoList(lottos);
        }
        lottoList.createAutoLottoList(price - lottoList.getLottoPrice());

        model.put("lottosSize", lottoList.getCount());
        model.put("lottos", lottoList.getLottoList());

        return model;
    }

    public Map<String, Object> matchLotto(String winningNumber, String bonusNumber){
        Map<String, Object> model = new HashMap<>();

        Lotto winningLotto = lottoInput.inputResultLotto(winningNumber);
        int bonus = lottoInput.inputResultBonusLotto(bonusNumber);

        lottoResult = new LottoResult(lottoList, winningLotto, bonus);
        model.put("lottoResult", mapToList());

        DecimalFormat df = new DecimalFormat("0.00");
        model.put("totalResultPrice", df.format(lottoResult.getTotalResultPrice()));
        return model;
    }

    private List<String> mapToList(){
        List<String> resultList = new ArrayList<>();

        lottoResult.getLottoResult().forEach(
                (rank, count) -> resultList.add(printLottoRank(rank, count))
        );

        return resultList;
    }

    private String printLottoRank(Rank rank, int count){
        StringBuilder sb = new StringBuilder();
        if(rank == Rank.NONE){
            return sb.toString();
        }

        sb.append(String.format("%d개 일치", rank.getCountOfMatch()));
        if(rank == Rank.SECOND){
            sb.append(", 보너스 볼 일치");
        }
        sb.append(String.format(" (%d원) - %d개", rank.getWinningMoney(), count));

        return sb.toString();
    }
}
