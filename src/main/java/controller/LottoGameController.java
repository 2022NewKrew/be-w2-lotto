package controller;

import domain.Lotto;
import domain.LottoGameInfo;
import domain.LottoGenerator;

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

    public static void start() {
        inputPurchaseParam();
        validatePurchaseParam(lottoGameInfo);
        generateLotto(lottoGameInfo);
        inputWinLottoNumbers();
        validateWinLottoNumbers(winLottoNumbers);
        calcLottoResult(lottoList, winLottoNumbers);
        renderResult();
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

    private static void calcLottoResult(List<Lotto> lottoList, List<Integer> winLottoNumbers) {
        // TODO - implement calculation result
    }

    private static void renderResult() {
        // TODO - implement render result
    }

}
