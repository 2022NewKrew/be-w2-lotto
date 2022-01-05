package service;

import domain.Lotto;
import domain.LottoAuto;
import domain.LottoNormal;
import domain.LottoStatistic;
import repository.LottoRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LottoServiceImpl implements LottoService {

    private final LottoRepository lottoRepository;

    public LottoServiceImpl(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    @Override
    public void run() {
        int purchasePrice = inputPurchasePrice();
        int purchaseCount = calculateLottoCount(purchasePrice);
        int normalLottoCount = inputNormalPurchaseCount();
        List<Lotto> lottos = new ArrayList<>();
        List<Lotto> normalLottos = inputNormalLottoList(normalLottoCount);
        lottos.addAll(normalLottos);

        int autoLottoCount = purchaseCount - normalLottoCount;
        lottos.addAll(createAutoLottoList(autoLottoCount));
        lottoRepository.save(lottos); // inMemory database save
        printLottoList(lottos);
        List<Integer> winningNumbers = inputWinningNumbers();
        int winningBonusNumber = inputWinningBonusNumber();
        updateLottoStatus(lottos, winningNumbers, winningBonusNumber);
        LottoStatistic lottoStatistic = getLottoStatic(purchaseCount, lottos);
        printLottoStatic(lottoStatistic);

    }

    private List<Lotto> inputNormalLottoList(int normalLottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            for (int i = 0; i < normalLottoCount; i++) {
                String line = bufferedReader.readLine();
                lottos.add(LottoNormal.createStringToLottoNumbers(line));
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return lottos;
    }

    private int inputNormalPurchaseCount() {
        int result = 0;

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("수동으로 구매할 로또 수를 입력해 주세요");
            result = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return result;
    }

    private void updateLottoStatus(List<Lotto> lottos, List<Integer> winningNumbers, int winningBonusNumber) {
        for (Lotto lotto : lottos) {
            lotto.updateStatus(winningNumbers, winningBonusNumber);
        }
    }

    private LottoStatistic getLottoStatic(int purchaseCount, List<Lotto> lottos) {
        LottoStatistic lottoStatistic = new LottoStatistic(purchaseCount);

        for (Lotto lotto : lottos) {
            lottoStatistic.addLottoInfo(lotto);
        }

        lottoStatistic.calculateProfitRate();

        return lottoStatistic;
    }

    private void printLottoStatic(LottoStatistic lottoStatistic) {
        System.out.println(lottoStatistic.getLottoStatisticString());
    }

    private List<Integer> inputWinningNumbers() {

        List<Integer> result = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            String input = bufferedReader.readLine();

            for (String numberString : input.split(",")) {
                int number = Integer.parseInt(numberString.trim());
                if (result.contains(number)) throw new IllegalArgumentException("중복된 값이 존재 합니다.");
                result.add(number);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return result;
    }

    private int inputWinningBonusNumber() {
        int result = 0;

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("보너스 볼을 입력해 주세요.");

            result = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            System.err.println(e.getMessage());
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

    private int inputPurchasePrice() {
        int result = 0;

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("구입금액을 입력해 주세요.");
            result = Integer.parseInt(bufferedReader.readLine());

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return result;
    }

    private List<Lotto> createAutoLottoList(int purchaseCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int count = 0; count < purchaseCount; count++) {
            LottoAuto lottoAuto = new LottoAuto();
            lottoAuto.createRandomNumber();
            lottos.add(lottoAuto);
        }

        return lottos;
    }
}
