package domain;
import java.util.*;

public class LottoStatics {
    private final int money;
    private final ArrayList<Lotto> userLottos;
    private final Lotto answerLotto;
    private Map<Rank, Integer> results;
    private final int bonusBall;

    public LottoStatics(int money, ArrayList<Lotto> userLottos, Lotto answerLotto, int bonusBall) {
        this.userLottos = userLottos;
        this.answerLotto = answerLotto;
        this.money = money;
        this.bonusBall = bonusBall;
        makeResults();
    }

    public Map<Rank, Integer> getResults() {
        return results;
    }

    public double getYield() { return computeYield(results, money); }

    private void makeResults() {
        results = new TreeMap<>();
        Rank[] ranks = Rank.values();
        for(Rank rank : ranks) {
            results.put(rank, 0);
        }
        addToResults();
    }

    private void addToResults() {
        userLottos.forEach(l -> {
            Rank value = evaluateLotto(l, answerLotto, bonusBall);
            if(value == null) {
                return;
            }
            results.put(value, results.get(value)+1);
        });
    }

    public static Rank evaluateLotto(Lotto userLotto, Lotto answerLotto, int bonusBall) {
        int countOfMatch = 0;
        ArrayList<Integer> userLottoNumbers = userLotto.getNumbers();
        ArrayList<Integer> answerLottoNumbers = answerLotto.getNumbers();
        for(int number : userLottoNumbers) {
            countOfMatch += answerLottoNumbers.contains(number) ? 1 : 0;
        }
        return Rank.valueOf(countOfMatch, userLottoNumbers.contains(bonusBall));
    }

    public static double computeYield(Map<Rank, Integer> results, int money) {
        var wrapper = new Object() { double earned = 0; };
        results.forEach((rank, num) -> wrapper.earned += rank.getWinningMoney() * num);
        return wrapper.earned / money * 100 - 100;
    }


}
