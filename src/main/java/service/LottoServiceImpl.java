package service;

import domain.Lotto;
import domain.LottoAuto;
import domain.LottoNormal;
import domain.LottoStatistic;
import repository.LottoRepository;
import repository.LottoStatisticRepository;

import java.sql.SQLException;
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

    private final LottoStatisticRepository lottoStatisticRepository;
    private final LottoRepository lottoRepository;

    public LottoServiceImpl(LottoStatisticRepository lottoStatisticRepository, LottoRepository lottoRepository) {
        this.lottoStatisticRepository = lottoStatisticRepository;
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

    @Override
    public LottoStatistic findLottoStatistic(Long id) {

        try {
            LottoStatistic lottoStatistic = lottoStatisticRepository.findOne(id);
            List<Lotto> lottos = lottoRepository.findAllAsLottoStatisticId(id);
            lottoStatistic.setLottos(lottos);
            return lottoStatistic;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public Long saveLottoStatistic(LottoStatistic lottoStatistic) {
        try {
            Long id = lottoStatisticRepository.save(lottoStatistic);

            List<Lotto> lottos = lottoStatistic.getLottos();

            for (Lotto lotto : lottos) {
                lottoRepository.save(lotto, id);
            }

            return id;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

}
