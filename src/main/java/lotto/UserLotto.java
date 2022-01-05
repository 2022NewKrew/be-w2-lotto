package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UserLotto extends Lotto {
    public UserLotto() {
        ArrayList<LottoBall> balls = new ArrayList<>(Arrays.asList(LottoBall.values()));
        Collections.shuffle(balls);
        lottoNumbers = new ArrayList<>(balls.subList(0, 6));
        Collections.sort(lottoNumbers);
    }

    public UserLotto(List<LottoBall> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>();
        this.lottoNumbers.addAll(lottoNumbers);
    }
}
