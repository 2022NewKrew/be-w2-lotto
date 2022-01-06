package lotto.domain;

import lotto.domain.generator.Generator;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public LottoMachine() {}

    /**
     * 구매금액과 발행정책을 입력받아 복권의 리스트를 반환.
     * @param purchaseCount 구매개수
     * @param generator 발행정책
     * @return lottoList 복권의 리스트
     */
    public List<Ticket> purchaseLotto(int purchaseCount, Generator generator) {
        List<Ticket> ticketList = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            ticketList.add(generator.generate());
        }
        return ticketList;
    }
}
