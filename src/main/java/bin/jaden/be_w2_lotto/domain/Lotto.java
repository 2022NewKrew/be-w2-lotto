package bin.jaden.be_w2_lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static List<Integer> allNumbers;
    private final List<List<Integer>> lottoGames;

    Lotto(int purchasingAmount) {
        initAllNumbers();
        int size = purchasingAmount / Constants.PRICE_PER_GAME;
        List<List<Integer>> lottoGames = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottoGames.add(getLottoGame());
        }
        this.lottoGames = Collections.unmodifiableList(lottoGames);
    }

    public void initAllNumbers() {
        allNumbers = new ArrayList<>();
        for (int i = Constants.MIN_LOTTO_NUMBER; i <= Constants.MAX_LOTTO_NUMBER; i++) {
            allNumbers.add(i);
        }
    }

    private List<Integer> getLottoGame() {
        Collections.shuffle(allNumbers);
        List<Integer> lottoGame = new ArrayList<>(allNumbers.subList(0, Constants.NUMBERS_PER_GAME));
        Collections.sort(lottoGame);
        return Collections.unmodifiableList(lottoGame);
    }

    public List<List<Integer>> getLottoGames() {
        return lottoGames;
    }
}
