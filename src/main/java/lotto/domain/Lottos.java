package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Lottos {
    List<LottoNumbers> lottos;

    public List<LottoNumbers> getLottos() {
        return lottos;
    }

    public void setLottos(List<LottoNumbers> lottoNumbers) {
        this.lottos = lottoNumbers;
    }

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public void generateAutoNumbers(int numOfAuto) {
        for (int i = 0; i < numOfAuto; i++) {
            lottos.add(new LottoNumbers());
        }
    }

    public void add(LottoNumbers ln) {
        lottos.add(ln);
    }

    public void add(String[] lottoNumbersArr) {
        if (lottoNumbersArr.length == 0) return;
        Arrays.stream(lottoNumbersArr).forEach(lnStr -> add(new LottoNumbers(lnStr)));
    }

    public int size() {
        return lottos.size();
    }

    public void forEach(Consumer<? super LottoNumbers> action) {
        lottos.forEach(action);
    }
}
