package lotto;

import java.util.*;

public class Lotto {
    protected ArrayList<Integer> lottoNumbers;

    public Lotto() {
        ArrayList<Integer> balls = new ArrayList<>();
        for (int i = 0; i < 45; i++) {
            balls.add(i);
        }
        Collections.shuffle(balls);
        lottoNumbers = new ArrayList<>(balls.subList(0, 6));
        Collections.sort(lottoNumbers);
    }

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>();
        this.lottoNumbers.addAll(lottoNumbers);
    }

    public ArrayList<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public String toString() {
        return lottoNumbers.toString();
    }
}
