package domain;

import view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*플레이어가 생성되면 랜덤으로 로또번호를 가격/1000 만큼 리스트로 생성한다.*/
public class Player {
    private final List<Lotto> lottoList = new ArrayList<>();

    public static final int LOTTO_PRICE = 1000;

    private final int payAutoCount;
    private final int payManualCount;
    public Player(int playerMoney, List<Lotto> manualLottoList) {
        this.payManualCount = manualLottoList.size();
        this.payAutoCount = playerMoney/LOTTO_PRICE - payManualCount;
        lottoList.addAll(manualLottoList);
        IntStream.range(0,payAutoCount).forEach(i -> lottoList.add(new Lotto()));
    }
    public int getPayAutoCount() {
        return payAutoCount;
    }

    public int getPayManualCount() {
        return payManualCount;
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