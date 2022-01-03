package view;

import domain.LottoRepository;

import java.util.List;

public class PurchaseView {

    private int quantity;
    private LottoRepository lottoRepository;

    public PurchaseView(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
        quantity = lottoRepository.getList().size();
    }

    public void showLottoList() {
        for (int i = 0; i < quantity; i++) {
            System.out.println(lottoRepository.getList().get(i));
        }
    }

}
