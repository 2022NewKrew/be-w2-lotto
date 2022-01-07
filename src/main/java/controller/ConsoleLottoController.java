package controller;

import domain.*;
import input.LottoConsoleInput;
import view.LottoView;

public class ConsoleLottoController {
    private final LottoConsoleInput lottoInput = new LottoConsoleInput();

    public void startLotto(){
        LottoView lottoView = new LottoView();
        LottoList lottoList = createLottoList();

        if(lottoList.getCount() == 0){
            System.out.println("로또를 구매하지 않습니다.");
            return;
        }

        lottoView.printLottoList(lottoList);
        LottoResult lottoResult = createLottoResult(lottoList);
        lottoView.printLottoResult(lottoResult);
    }

    private LottoList createLottoList() throws IllegalArgumentException {
        LottoMachine lottoMachine = new LottoMachine();
        int price = lottoInput.inputPrice();

        if(price > 0){
            lottoMachine.manualLottoList(lottoInput.inputManualLotto(price));
            int autoBuyPrice = lottoMachine.getLottoList().getCount() * LottoConst.ONE_LOTTO_PRICE;
            lottoMachine.autoLottoList(price - autoBuyPrice);
        }

        return lottoMachine.getLottoList();
    }

    private LottoResult createLottoResult(LottoList lottoList) throws IllegalArgumentException{
        Lotto resultLottoNumber = lottoInput.inputResultLotto();
        int resultBonusNumber = lottoInput.inputResultBonusLotto();

        return new LottoResult(lottoList, resultLottoNumber, resultBonusNumber);
    }
}
