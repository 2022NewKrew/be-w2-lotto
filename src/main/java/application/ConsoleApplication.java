package application;

import config.AppConfig;
import domain.Lotto;
import domain.LottoNormal;
import domain.LottoStatistic;
import service.LottoService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleApplication {

    private LottoStatistic lottoStatistic;
    private final LottoService lottoService;

    private int purchasePrice;
    private int purchaseCount;
    private int normalLottoCount;
    private int autoLottoCount;

    public ConsoleApplication() {
        AppConfig appConfig = new AppConfig();
        this.lottoService = appConfig.lottoService();
    }

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

    public void createLottoStatic() {
        purchasePrice = inputPurchasePrice();
        purchaseCount = lottoService.calculateLottoCount(purchasePrice);
        normalLottoCount = inputNormalPurchaseCount();
        autoLottoCount = purchaseCount - normalLottoCount;
        lottoStatistic = lottoService.createLottoStatistic(purchaseCount, normalLottoCount, autoLottoCount);
    }

    private void createLottoList() {

        List<Lotto> normalLottoList = inputNormalLottoList(normalLottoCount);
        List<Lotto> autoLottoList = lottoService.createAutoLottoList(autoLottoCount);
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
                LottoNormal lottoNormal = lottoService.createStringToLottoNumbers(line);
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
}
