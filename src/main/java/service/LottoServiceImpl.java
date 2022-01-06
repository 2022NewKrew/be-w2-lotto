package service;

import domain.Lotto;
import domain.LottoAuto;
import domain.LottoNormal;
import domain.LottoStatistic;
import repository.LottoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

/**
 * LottoService의 구현체입니다.
 *
 * @author jm.hong
 */
public class LottoServiceImpl implements LottoService {

    private final LottoRepository lottoRepository;

    public LottoServiceImpl(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;

    }

    @Override
    public LottoStatistic createLottoStatistic(int purchaseCount, int normalLottoCount, int autoLottoCount, List<Lotto> lottos) {
        return new LottoStatistic(purchaseCount, normalLottoCount, autoLottoCount, lottos);
    }

    @Override
    public List<Lotto> createAutoLottoList(int autoLottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int count = 0; count < autoLottoCount; count++) {
            LottoAuto lottoAuto = new LottoAuto();
            lottos.add(lottoAuto);
        }

        return lottos;
    }

    @Override
    public int calculateLottoCount(int purchasePrice) {
        if (purchasePrice == 0) {
            throw new IllegalArgumentException("0원 입니다.");
        }

        if (purchasePrice % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위가 아닙니다.");
        }

        return purchasePrice / 1000;
    }

    @Override
    public LottoNormal createStringToLottoNumbers(String numbers) {
        List<Integer> list = stream(numbers.split(",")).map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
        LottoNormal lottoNormal = new LottoNormal(list);
        return lottoNormal;
    }

}
