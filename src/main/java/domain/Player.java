package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*플레이어가 생성되면 랜덤으로 로또번호를 가격/1000 만큼 리스트로 생성한다.*/
public class Player {
    private final List<Lotto> lottoList = new ArrayList<>();
    public Player(int payAutoCount, List<Lotto> manualLottoList) {
        lottoList.addAll(manualLottoList);
        IntStream.range(0,payAutoCount).forEach(i -> lottoList.add(new Lotto()));
    }
    public List<Lotto> getLottoList() {
        return lottoList;
    }
    public List<Integer> matchingLotto(List<Integer> winningNumber)
    {
        return lottoList.stream()
                .map(t -> t.countMatchNumber(winningNumber))
                .collect(Collectors.toList());
    }
    public List<Boolean> matchingBonusLotto(Integer bonusNumber)
    {
        return lottoList.stream()
                .map(t -> t.countBonusNumber(bonusNumber))
                .collect(Collectors.toList());
    }

}