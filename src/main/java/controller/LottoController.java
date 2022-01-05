package controller;

import domain.Lotto;
import domain.LottoList;
import domain.LottoResult;
import view.LottoInput;
import view.LottoView;

public class LottoController {
    private final LottoInput lottoInput = new LottoInput();

    public void startLotto(){
        try{
            LottoView lottoView = new LottoView();
            LottoList lottoList = createLottoList();

            if(lottoList.getLottoPrice() == 0){
                System.out.println("로또를 구매하지 않습니다.");
                return;
            }

            lottoView.printLottoList(lottoList);
            LottoResult lottoResult = createLottoResult(lottoList);
            lottoView.printLottoResult(lottoResult);
        } catch(NumberFormatException e){
            System.out.println("숫자만 입력할 수 있습니다.");
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private LottoList createLottoList() throws IllegalArgumentException {
        LottoList lottoList = new LottoList();
        int price = lottoInput.inputPrice();

        if(price > 0){
            lottoList.createManualLottoList(lottoInput.inputManualLotto(price));
            lottoList.createAutoLottoList(price - lottoList.getLottoPrice());
        }
        return lottoList;
    }

    private LottoResult createLottoResult(LottoList lottoList) throws IllegalArgumentException{
        Lotto resultLottoNumber = lottoInput.inputResultLotto();
        int resultBonusNumber = lottoInput.inputResultBonusLotto();

        return new LottoResult(lottoList, resultLottoNumber, resultBonusNumber);
    }
}
