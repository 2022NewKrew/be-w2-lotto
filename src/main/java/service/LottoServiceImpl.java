package service;

import domain.Lotto;
import dto.LottoStatistic;
import repository.LottoRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LottoServiceImpl implements LottoService {

    private LottoRepository lottoRepository;

    public LottoServiceImpl(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    @Override
    public void run() {
        try {
            int purchasePrice = inputPurchasePrice();
            int purchaseCount = calculateLottoCount(purchasePrice);
            List<Lotto> lottos = createLottoList(purchaseCount);
            lottoRepository.save(lottos); // inMemory database save
            printLottoList(lottos);
            List<Integer> winningNumbers = inputWinningNumbers();
            printWinningStatistics(purchaseCount, lottos, winningNumbers);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    private void printWinningStatistics(int purchaseCount, List<Lotto> lottos, List<Integer> winningNumbers) {
        List<Integer> resultList = new ArrayList<>();
        LottoStatistic lottoStatistic = new LottoStatistic(purchaseCount);

        for (Lotto lotto : lottos) {
            int count = getCountWinning(lotto, winningNumbers);
            lottoStatistic.addLottoInfo(count);
        }

        lottoStatistic.calculateProfitRate();

        System.out.println(lottoStatistic.getLottoStatisticString());

    }

    private int getCountWinning(Lotto lotto, List<Integer> winningNumbers) {
        int count = 0;

        for (int number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private List<Integer> inputWinningNumbers() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> result = new ArrayList<>();

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = bufferedReader.readLine();

        for (String numberString : input.split(",")) {
            int number = Integer.parseInt(numberString.trim());
            if(result.contains(number)) throw new IllegalArgumentException("중복된 값이 존재 합니다.");
            result.add(number);
        }

        return result;
    }

    private void printLottoList(List<Lotto> lottos) {
        lottos.forEach(System.out::println);
        System.out.println();
    }

    private int calculateLottoCount(int purchasePrice) {
        if (purchasePrice % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위가 아닙니다.");
        }

        return purchasePrice / 1000;
    }

    private int inputPurchasePrice() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("구입금액을 입력해 주세요.");

        return Integer.parseInt(bufferedReader.readLine());

    }

    private List<Lotto> createLottoList(int purchaseCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int count = 0; count < purchaseCount; count++) {
            Lotto lotto = new Lotto();
            lotto.createRandomNumber();
            lottos.add(lotto);
        }

        return lottos;
    }
}
