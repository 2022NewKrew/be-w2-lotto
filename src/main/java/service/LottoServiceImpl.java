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
    private LottoStatistic lottoStatistic;

    private int purchasePrice;
    private int purchaseCount;
    private int normalLottoCount;
    private int autoLottoCount;

    public LottoServiceImpl(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    @Override
    public void run() {

        createLottoStatic();
        createLottoList();
        printLottoList();
        createWinningNumbersAndBonusNumber();
        printLottoStatic();

    }

    private void createWinningNumbersAndBonusNumber() {
        List<Integer> winningNumbers = inputWinningNumbers();
        int winningBonusNumber = inputWinningBonusNumber();

        lottoStatistic.updateStatus(winningNumbers, winningBonusNumber);
    }

    private void createLottoStatic() {

        purchasePrice = inputPurchasePrice();
        purchaseCount = calculateLottoCount();
        normalLottoCount = inputNormalPurchaseCount();
        autoLottoCount = purchaseCount - normalLottoCount;

        lottoStatistic = new LottoStatistic(purchaseCount, normalLottoCount, autoLottoCount);
    }

    private void createLottoList() {

        List<Lotto> normalLottoList = inputNormalLottoList(normalLottoCount);

        List<Lotto> autoLottoList = createAutoLottoList(autoLottoCount);

        lottoStatistic.addLottos(normalLottoList);
        lottoStatistic.addLottos(autoLottoList);
    }

    private void printLottoStatic() {
        System.out.println(lottoStatistic.getLottoStatisticString());
    }

    private void printLottoList() {
        System.out.println(lottoStatistic.getLottoListToString());
    }

    private List<Lotto> inputNormalLottoList(int normalLottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            for (int i = 0; i < normalLottoCount; i++) {
                String line = bufferedReader.readLine();
                LottoNormal lottoNormal = LottoNormal.createStringToLottoNumbers(line);
                lottos.add(lottoNormal);
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

    private int calculateLottoCount() {
        if (purchasePrice == 0) {
            throw new IllegalArgumentException("0원 입니다.");
        }

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

    private List<Lotto> createAutoLottoList(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            LottoAuto lottoAuto = new LottoAuto();
            lottoAuto.createRandomNumber();
            lottos.add(lottoAuto);
        }

        return lottos;
    }
}
