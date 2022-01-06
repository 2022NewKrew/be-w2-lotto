package bin.jaden.be_w2_lotto.service;

import bin.jaden.be_w2_lotto.LottoGame.ManualLottoGame;
import bin.jaden.be_w2_lotto.LottoGame.WinLottoGame;
import bin.jaden.be_w2_lotto.domain.Constants;
import bin.jaden.be_w2_lotto.domain.LottoGameManager;
import bin.jaden.be_w2_lotto.exception.DuplicateNumberException;
import bin.jaden.be_w2_lotto.exception.InvalidArraySizeException;
import bin.jaden.be_w2_lotto.exception.InvalidNumberException;
import bin.jaden.be_w2_lotto.exception.NumberOutOfRangeException;
import bin.jaden.be_w2_lotto.renderer.LottoRenderer;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoService {
    LottoRenderer lottoRenderer = new LottoRenderer();

    public String index(Request request, Response response) {
        request.session(true);
        return lottoRenderer.getIndexRender();

    }

    // 요구사항
    // 서버는 request의 queryParams("inputMoney") 메소드를 통해 클라이언트에서 전달한 로또 구입 금액을 받는다.
    // 서버는 request의 queryParams("manualNumber") 메소드를 통해 클라이언트에서 전달한 수동으로 구매하는 로또를 받는다.
    public String buyLotto(Request request, Response response) {
        String inputMoney = request.queryParams("inputMoney");
        String manualNumber = request.queryParams("manualNumber");

        try {
            LottoGameManager lottoGameManager = getLottoManager(inputMoney, manualNumber);
            request.session().attribute("lottoGameManager", lottoGameManager);
            return lottoRenderer.getBuyLottoRender(lottoGameManager.getLottoGames());
        } catch (NumberFormatException | InvalidArraySizeException | NumberOutOfRangeException | DuplicateNumberException | InvalidNumberException exception) {
            return lottoRenderer.getErrorRender(exception.getMessage(), "/index.html");
        }
    }

    // 요구사항
    // 서버는 request의 queryParams("winningNumber") 메소드를 통해 클라이언트에서 전달한 당첨번호 값을 추출한다.
    // 서버는 request의 queryParams("bonusNumber") 메소드를 통해 클라이언트에서 전달한 보너스 번호 값을 추출한다.
    public String matchLotto(Request request, Response response) {
        String winningString = request.queryParams("winningNumber");
        String bonusString = request.queryParams("bonusNumber");
        LottoGameManager lottoGameManager = request.session().attribute("lottoGameManager");
        try {
            WinLottoGame winLottoGame = getWinLottoGame(winningString, bonusString);
            return lottoRenderer.getMatchLottoRender(lottoGameManager.getResults(winLottoGame));
        } catch (NumberFormatException | InvalidArraySizeException | NumberOutOfRangeException | DuplicateNumberException exception) {
            return lottoRenderer.getBuyLottoErrorRender(exception.getMessage(), lottoGameManager.getLottoGames());
        }
    }

    private LottoGameManager getLottoManager(String inputMoney, String manualNumber) {
        int purchasingAmount = getPurchasingAmount(inputMoney);
        int lottosSize = purchasingAmount / Constants.PRICE_PER_GAME;
        List<ManualLottoGame> manualLottoGames = getManualLottoGames(manualNumber, lottosSize);
        return new LottoGameManager(purchasingAmount, manualLottoGames);
    }


    private WinLottoGame getWinLottoGame(String winningString, String bonusString) {
        List<Integer> winNumbers = getWinNumbers(winningString);
        int bonusNumber = getBonusNumbers(winNumbers, bonusString);
        return new WinLottoGame(winNumbers, bonusNumber);
    }

    private List<ManualLottoGame> getManualLottoGames(String manualString, int lottosSize) {
        List<ManualLottoGame> manualLottoGames = new ArrayList<>();
        if (manualString.trim().length() == 0)
            return manualLottoGames;
        String[] manualNumbersList = manualString.split("\r?\n");
        if (manualNumbersList.length > lottosSize)
            throw new NumberOutOfRangeException(Constants.INVALID_NUMBER_OF_PURCHASE_MANUALLY_RANGE_MESSAGE);
        for (String manualNumbers : manualNumbersList) {
            manualLottoGames.add(scanManualLottoGame(manualNumbers));
        }

        return manualLottoGames;
    }

    private ManualLottoGame scanManualLottoGame(String manualString) {
        try {
            return new ManualLottoGame(manualString);
        } catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException(Constants.INPUT_WRONG_MANUAL_NUMBERS_MESSAGE);
        }

    }


    public List<Integer> getWinNumbers(String bonusString) {
        try {
            return parseWinNumbers(bonusString);
        } catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException(Constants.INPUT_WRONG_WIN_NUMBERS_MESSAGE);
        }
    }

    public int getBonusNumbers(List<Integer> winNumbers, String bonusString) {
        try {
            return parseBonusNumber(winNumbers, bonusString);
        } catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException(Constants.INVALID_BONUS_NUMBER_MESSAGE);
        }
    }

    private List<Integer> parseWinNumbers(String winningString) {
        String[] numbers = winningString.split(Constants.INPUT_WIN_NUMBERS_DELIMITER);

        List<Integer> winNumbers = Arrays.stream(numbers)
                .map(Integer::parseInt).collect(Collectors.toList());
        winNumbersValidationCheck(winNumbers);
        return winNumbers;
    }

    private int parseBonusNumber(List<Integer> winNumbers, String bonusString) {
        int bonusNumber = Integer.parseInt(bonusString);
        if (bonusNumber < Constants.MIN_LOTTO_NUMBER || bonusNumber > Constants.MAX_LOTTO_NUMBER)
            throw new NumberOutOfRangeException(Constants.INVALID_BONUS_NUMBER_RANGE_MESSAGE);
        if (winNumbers.contains(bonusNumber))
            throw new DuplicateNumberException(Constants.DUPLICATE_BONUS_NUMBERS_MESSAGE);
        return bonusNumber;
    }

    private int getPurchasingAmount(String inputMoney) {
        int purchasingAmount;
        try {
            purchasingAmount = Integer.parseInt(inputMoney);
        } catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException(Constants.INPUT_WRONG_PURCHASING_AMOUNT_MESSAGE);
        }
        if (purchasingAmount < Constants.PRICE_PER_GAME)
            throw new InvalidNumberException(Constants.INVALID_PURCHASING_AMOUNT_MESSAGE);
        return purchasingAmount;
    }

    private void winNumbersValidationCheck(List<Integer> winNumbers) {
        if (winNumbers.size() != Constants.NUMBERS_PER_GAME)
            throw new InvalidArraySizeException(Constants.INVALID_WIN_NUMBERS_LENGTH_MESSAGE);
        for (int winNumber : winNumbers) {
            if (winNumber < Constants.MIN_LOTTO_NUMBER || winNumber > Constants.MAX_LOTTO_NUMBER)
                throw new NumberOutOfRangeException(Constants.INVALID_WIN_NUMBERS_RANGE_MESSAGE);
        }
        if (winNumbers.size() != new TreeSet<>(winNumbers).size()) { // 중복이 있다면 다른 길이를 가지게 된다.
            throw new DuplicateNumberException(Constants.DUPLICATE_WIN_NUMBERS_MESSAGE);
        }
    }


}
