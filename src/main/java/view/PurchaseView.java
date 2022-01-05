package view;

import domain.LottoRepository;

public class PurchaseView {

    private final LottoRepository lottoRepository;

    public PurchaseView(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    public void showLottoList() {
        System.out.println(lottoRepository);
    }

}
