package controller;

import domain.lotto.*;
import view.LottoRenderer;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoGameController {

    private static final String INPUT_DELIMITER = ",";
    private static final Scanner sc = new Scanner(System.in);

    private static LottoGameInfo lottoGameInfo;
    private static List<Lotto> lottoList;
    private static List<Integer> winLottoNumbers;
    private static int bonusLottoNumber;
    private static LottoTotalResult lottoTotalResult;

    public static void start() {
        inputPurchaseParam();
        validatePurchaseParam();
        generateLotto();
        renderLottoList();
        inputWinLottoNumbers();
        validateWinLottoNumbers();
        calcLottoResult(lottoGameInfo.getInputMoney());
        renderResult();
    }

    private static void inputPurchaseParam() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = sc.nextInt();

        lottoGameInfo = new LottoGameInfo(money);
    }

    private static void validatePurchaseParam() {
        // TODO - implement input validation
    }

    private static void generateLotto() {
        lottoList = LottoGenerator.generate(lottoGameInfo);
    }

    private static void renderLottoList() {
        LottoRenderer.renderLotto(lottoList);
    }

    private static void inputWinLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] inputLottoNumbers = sc.next().split(INPUT_DELIMITER);
        winLottoNumbers = Arrays.stream(inputLottoNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println("보너스 볼을 입력해 주세요.");
        bonusLottoNumber = sc.nextInt();
    }

    private static void validateWinLottoNumbers() {
        // TODO - implement input validation
    }

    private static void calcLottoResult(int inputMoney) {
        lottoTotalResult = LottoCalculator.calculate(inputMoney, lottoList, winLottoNumbers, bonusLottoNumber);
    }

    private static void renderResult() {
        LottoRenderer.renderResult(lottoTotalResult);
        LottoRenderer.renderEarningRatio(lottoTotalResult);
    }

}
