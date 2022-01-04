package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static domain.Lotto.lottoPrice;

/*플레이어가 생성되면 랜덤으로 로또번호를 가격/1000 만큼 리스트로 생성한다.*/
public class Player {
    private final List<Lotto> lottoList;
    public Player(int price) {
        lottoList = new ArrayList<>();
        IntStream.range(0,price/1000).forEach(i -> lottoList.add(new Lotto()));
    }
    public List<Lotto> getLottoList() {
        return lottoList;
    }
    public List<Integer> matchingLotto(List<Integer> winningNumber)
    {
        return lottoList.stream()
                .map(t -> t.countMatchNumber(winningNumber))
                .filter(s -> s > 0)
                .collect(Collectors.toList());
    }


}
