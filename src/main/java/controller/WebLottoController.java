package controller;

import domain.*;
import input.LottoInput;

import java.text.DecimalFormat;
import java.util.*;

public class WebLottoController {
    private final LottoInput lottoInput;
    private final LottoMachine lottoMachine;
    private LottoResult lottoResult;

    public WebLottoController() {
        lottoInput = new LottoInput();
        lottoMachine = new LottoMachine();
    }

    public Map<String, Object> buyLotto(String inputMoney, String manualLotto) throws IllegalArgumentException{
        Map<String, Object> model = new HashMap<>();

        int price = lottoInput.inputPrice(inputMoney);

        if(!manualLotto.equals("")){
            List<Lotto> lottos = lottoInput.inputManualLotto(manualLotto, price);
            lottoMachine.manualLottoList(lottos);
        }

        int autoBuyPrice = price - lottoMachine.getLottoList().getCount() * LottoConst.ONE_LOTTO_PRICE;
        lottoMachine.autoLottoList(autoBuyPrice);

        LottoList lottoList = lottoMachine.getLottoList();
        model.put("lottosSize", lottoList.getCount());
        model.put("lottos", lottoList.getLottoList());

        return model;
    }

    public Map<String, Object> matchLotto(String winningNumber, String bonusNumber){
        Map<String, Object> model = new HashMap<>();

        Lotto winningLotto = lottoInput.inputResultLotto(winningNumber);
        int bonus = lottoInput.inputResultBonusLotto(bonusNumber);

        lottoResult = new LottoResult(lottoMachine.getLottoList(), winningLotto, bonus);
        model.put("lottoResult", mapToList());

        DecimalFormat df = new DecimalFormat("0.00");
        model.put("totalResultPrice", df.format(lottoResult.getTotalResultPrice()));
        return model;
    }

    private List<String> mapToList(){
        List<String> resultList = new ArrayList<>();

        lottoResult.getLottoResult().forEach(
                (rank, count) -> {
                    if(rank != Rank.NONE) {
                        resultList.add(rank + String.format(" %d개", count));
                    }
                }
        );

        return resultList;
    }
}
