package service;

import domain.lotto.Lotto;
import domain.lotto.LottoPrecondition;
import domain.lotto.LottoRank;
import dto.LottoDTO;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {
    private static final List<Integer> lottoNumbers = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

    private List<Integer> winningLotto;
    private final List<Lotto> lottos = new ArrayList<>();

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
        List<LottoRank> lottoRanks = lottos.stream().map(this::matchLotto).collect(Collectors.toList());
        Map<LottoRank, Integer> resultMap = new HashMap<>();
        for (LottoRank targetLottoRank : LottoRank.values()) {
            generateResult(resultMap, lottoRanks, targetLottoRank);
        }

        return resultMap;
    }

    public List<LottoDTO> getLottoDTOs() {
        return lottos.stream().map(lotto -> new LottoDTO(lotto.getNumbers())).collect(Collectors.toList());
    }

    private void buyLotto() {
        Collections.shuffle(lottoNumbers);
        List<Integer> randomNumbers = new ArrayList<>(lottoNumbers.subList(0, 6));
        Collections.sort(randomNumbers);
        lottos.add(new Lotto(randomNumbers));
    }

    private LottoRank matchLotto(Lotto lotto) {
        int numberOfSameNumber = 0;
        for (int number : lotto.getNumbers()) {
            if (isContainNumber(number)) {
                numberOfSameNumber++;
            }
        }
        return convertToLottoRank(numberOfSameNumber);
    }

    private boolean isContainNumber(int number) {
        return winningLotto.contains(number);
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
        return (int) lottoRanks.stream().filter(lottoRank -> lottoRank == targetLottoRank).count();
    }
}
