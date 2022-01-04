package domain;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static domain.Lotto.lottoPrice;

/*플레이어가 생성되면 랜덤으로 로또번호를 가격/1000 만큼 리스트로 생성한다.*/
public class Player {

    private final List<Lotto> lottoList;
    public Player(int price) {
        lottoList = IntStream.range(0,price/lottoPrice)
                .mapToObj(e -> new Lotto())
                .collect(Collectors.toList());

    }
    public List<Lotto> getLottoList() {
        return lottoList;
    }

}
