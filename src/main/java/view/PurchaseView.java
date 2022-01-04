package view;

import domain.LottoRepository;

public class PurchaseView {

    private final int quantity;
    private final LottoRepository lottoRepository;

    public PurchaseView(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
        quantity = lottoRepository.getList().size();
    }

    public void showLottoList() {
        System.out.println(lottoRepository);
    }

}
