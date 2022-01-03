package view;

import service.OwnLotto;

public class OutputView {
    public OutputView(){

    }

    public void printPurchaseLottoList(OwnLotto ownLotto){
        ownLotto.printOwnLottoList();
    }
}
