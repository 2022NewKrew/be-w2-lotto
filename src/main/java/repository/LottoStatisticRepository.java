package repository;

import domain.LottoStatistic;

/**
 * LottoStatic 객체를 반환하는 저장소입니다.
 *
 * @author jm.hong
 */
public interface LottoStatisticRepository {
    /**
     *
     * @param lottoStatistics 로또통계에 대한 정보가 담긴 객체를 입력합니다.
     * @return database key 값을 반환합니다.
     */
    Long save(LottoStatistic lottoStatistics);

    /**
     *
     * @param id database key 값을 입력합니다.
     * @return 로또통계에 대한 정보가 담긴 객체를 반환합니다.
     */
    LottoStatistic findOne(Long id);
}
