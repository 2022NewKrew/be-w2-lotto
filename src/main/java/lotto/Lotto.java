package lotto;

import java.util.*;

public class Lotto {
    protected ArrayList<LottoBall> lottoNumbers;

    public Lotto() {
        ArrayList<LottoBall> balls = new ArrayList<>(Arrays.asList(LottoBall.values()));
        Collections.shuffle(balls);
        lottoNumbers = new ArrayList<>(balls.subList(0, 6));
        Collections.sort(lottoNumbers);
    }

    public Lotto(List<LottoBall> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>();
        this.lottoNumbers.addAll(lottoNumbers);
    }

    public ArrayList<LottoBall> getLottoNumbers() {
        return lottoNumbers;
    }

}
