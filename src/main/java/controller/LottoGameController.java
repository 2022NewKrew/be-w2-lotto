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
    private static LottoTotalResult lottoTotalResult;

    public static void start() {
        inputPurchaseParam();
        validatePurchaseParam(lottoGameInfo);
        generateLotto(lottoGameInfo);
        renderLottoList(lottoList);
        inputWinLottoNumbers();
        validateWinLottoNumbers(winLottoNumbers);
        calcLottoResult(lottoGameInfo.getInputMoney(), lottoList, winLottoNumbers);
        renderResult(lottoTotalResult);
    }

    private static void inputPurchaseParam() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = sc.nextInt();

        lottoGameInfo = new LottoGameInfo(money);
    }

    private static void validatePurchaseParam(LottoGameInfo lottoGameInfo) {
        // TODO - implement input validation
    }

    private static void generateLotto(LottoGameInfo lottoGameInfo) {
        lottoList = LottoGenerator.generate(lottoGameInfo);
    }

    private static void renderLottoList(List<Lotto> lottoList) {
        LottoRenderer.renderLotto(lottoList);
    }

    private static void inputWinLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] inputLottoNumbers = sc.next().split(INPUT_DELIMITER);
        winLottoNumbers = Arrays.stream(inputLottoNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validateWinLottoNumbers(List<Integer> winLottoNumbers) {
        // TODO - implement input validation
    }

    private static void calcLottoResult(int inputMoney, List<Lotto> lottoList, List<Integer> winLottoNumbers) {
        lottoTotalResult = LottoCalculator.calculate(inputMoney, lottoList, winLottoNumbers);
    }

    private static void renderResult(LottoTotalResult lottoTotalResult) {
        LottoRenderer.renderResult(lottoTotalResult);
        LottoRenderer.renderEarningRatio(lottoTotalResult);
    }

}
