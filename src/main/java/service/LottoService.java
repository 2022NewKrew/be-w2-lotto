package service;

import domain.Lotto;
import domain.LottoNormal;
import domain.LottoStatistic;

import java.util.List;

/**
 * 로또번호를 자동으로 생성하고 로또통계 객체생성 등 여러 서비스를 제공합니다.
 *
 * @author jm.hong
 */
public interface LottoService {

    /**
     *
     * @param purchaseCount 총 구매한 로또 수를 입력합니다.
     * @param normalLottoCount 구매한 수동 로또 수를 입력합니다.
     * @param autoLottoCount 구매한 자동 로또 수를 입력합니다.
     * @param lottos 수동과 자동으로 구매한 로또에 대한 정보가 담긴 리스트를 입력합니다.
     * @return 로또 통계에 대한 정보가 담긴 LottoStatistic 객체를 반환합니다.
     */
    LottoStatistic createLottoStatistic(int purchaseCount, int normalLottoCount, int autoLottoCount, List<Lotto> lottos);

    /**
     *
     * @param autoLottoCount 자동으로 생성하고 싶은 로또 수를 입력합니다.
     * @return 자동으로 생성한 로또 수 만큼 로또 리스트를 반환합니다.
     */
    List<Lotto> createAutoLottoList(int autoLottoCount);

    /**
     *
     * @param purchasePrice 로또 구매금액을 입력합니다.
     * @exception 1000원 단위가 아닌 경우
     * @exception 0원인 경우
     * @return 구매한 로또 수를 반환합니다.
     */
    int calculateLottoCount(int purchasePrice);

    /**
     *
     * @param line ',' 로 구분되는 6자리의 숫자 문자열을 입력합니다.
     * @exception 6자리가 아닌경우
     * @exception 1~45의 숫자가 아닌 경우
     * @return
     */
    LottoNormal createStringToLottoNumbers(String line);
}
