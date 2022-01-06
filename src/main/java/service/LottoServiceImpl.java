package service;

import domain.Lotto;
import domain.LottoAuto;
import domain.LottoStatistic;
import repository.LottoRepository;

import java.util.ArrayList;
import java.util.List;

public class LottoServiceImpl implements LottoService {

    private final LottoRepository lottoRepository;

    public LottoServiceImpl(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;

    }

    @Override
    public LottoStatistic createLottoStatistic(int purchaseCount, int normalLottoCount, int autoLottoCount) {
        return new LottoStatistic(purchaseCount, normalLottoCount, autoLottoCount);
    }

    @Override
    public List<Lotto> createAutoLottoList(int autoLottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int count = 0; count < autoLottoCount; count++) {
            LottoAuto lottoAuto = new LottoAuto();
            lottoAuto.createRandomNumber();
            lottos.add(lottoAuto);
        }

        return lottos;
    }
}
