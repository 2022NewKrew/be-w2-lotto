package controller;

import domain.lotto.Lotto;
import domain.lotto.LottoPrecondition;
import domain.lotto.LottoRank;
import dto.LottoDTO;
import view.UserInput;
import view.UserOutput;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {

    private static final List<Integer> lottoNumbers =
            IntStream.rangeClosed(Lotto.START_NUMBER, Lotto.FINAL_NUMBER)
                    .boxed()
                    .collect(Collectors.toList());

    private List<Integer> winningLotto;
    private final List<Lotto> lottos = new ArrayList<>();

    public void run() {
        int money = UserInput.getMoney();
        UserOutput.printBuyMessage(money / Lotto.LOTTO_PRICE);
        buyLottos(money);
        UserOutput.printLotto(getLottoDTOs());
        List<Integer> winningNumbers = UserInput.getWinningLotto();
        setWinningLotto(winningNumbers);
        UserOutput.printRevenueRate(getTotalEarn() / money);
        UserOutput.printHistory(getResult());
    }

    public void buyLottos(int money) {
        int numberOfLotto = money / Lotto.LOTTO_PRICE;
        for (int i = 0; i < numberOfLotto; i++) {
            buyLotto();
        }
    }

    public void setWinningLotto(List<Integer> numbers) {
        LottoPrecondition.checkNumbers(numbers);
        winningLotto = numbers;
    }

    public Map<LottoRank, Integer> getResult() {
        List<LottoRank> lottoRanks =
                lottos.stream()
                        .map(this::matchLotto)
                        .collect(Collectors.toList());
        Map<LottoRank, Integer> resultMap = new HashMap<>();
        for (LottoRank targetLottoRank : LottoRank.values()) {
            generateResult(resultMap, lottoRanks, targetLottoRank);
        }

        return resultMap;
    }

    public double getTotalEarn(){
        return
                getResult()
                        .entrySet()
                        .stream()
                        .mapToDouble(entry->entry.getKey().getReward() * entry.getValue())
                        .sum();
    }

    public List<LottoDTO> getLottoDTOs() {
        return
                lottos.stream()
                        .map(LottoDTO::getLottoDTO)
                        .collect(Collectors.toList());
    }

    private void buyLotto() {
        Collections.shuffle(lottoNumbers);
        List<Integer> randomNumbers = new ArrayList<>(lottoNumbers.subList(0, 6));
        Collections.sort(randomNumbers);
        lottos.add(new Lotto(randomNumbers));
    }

    private LottoRank matchLotto(Lotto lotto) {
        int numberOfSameNumber = numberOfWinningNumberInLotto(lotto);
        return convertToLottoRank(numberOfSameNumber);
    }

    private int numberOfWinningNumberInLotto(Lotto lotto) {
        return
                (int) lotto.getNumbers()
                        .stream()
                        .filter(number -> winningLotto.contains(number))
                        .count();
    }

    private LottoRank convertToLottoRank(int numberOfSameNumber) {
        if (numberOfSameNumber == 6) {
            return LottoRank.FIRST_PRIZE;
        }
        if (numberOfSameNumber == 5) {
            return LottoRank.SECOND_PRIZE;
        }
        if (numberOfSameNumber == 4) {
            return LottoRank.THIRD_PRIZE;
        }
        if (numberOfSameNumber == 3) {
            return LottoRank.FORTH_PRIZE;
        }
        return LottoRank.FAIL;
    }

    private void generateResult(Map<LottoRank, Integer> result, List<LottoRank> lottoRanks, LottoRank targetLottoRank) {
        result.put(targetLottoRank, countLottoRank(lottoRanks, targetLottoRank));
    }

    private int countLottoRank(List<LottoRank> lottoRanks, LottoRank targetLottoRank) {
        return
                (int) lottoRanks.stream()
                        .filter(lottoRank -> lottoRank == targetLottoRank)
                        .count();
    }
}
