package lotto.controller;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.LottoMachine;
import lotto.domain.game.LottoGameResult;
import lotto.domain.game.LottoGameStatus;
import lotto.domain.game.LottoPurchasePrice;
import lotto.domain.game.LottoRankCount;
import lotto.domain.model.Lotto;
import lotto.domain.model.LottoNumber;
import lotto.domain.model.LottoTickets;
import lotto.domain.model.WinningLotto;
import lotto.dto.LottoResultDTO;
import lotto.dto.LottoTicketsDTO;
import lotto.view.LottoGameView;

public class LottoGame {

    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "숫자만 입력해주세요.";

    private final LottoMachine lottoMachine;
    private final LottoGameView lottoGameView;

    private LottoGameStatus lottoGameStatus;

    public static LottoGame of(LottoMachine lottoMachine, LottoGameView lottoGameView) {
        return new LottoGame(lottoMachine, lottoGameView);
    }

    private LottoGame(LottoMachine lottoMachine, LottoGameView lottoGameView) {
        this.lottoMachine = lottoMachine;
        this.lottoGameView = lottoGameView;
    }

    public void run() {
        initializeGame();
        makeGameResult();
    }

    private void initializeGame() {
        LottoPurchasePrice purchasePriceInput = getPurchasePriceInLoop();

        LottoTickets manualPurchaseTickets = manualPurchaseTickets(purchasePriceInput);

        LottoTickets autoPurchaseTickets = lottoMachine.purchaseLottoTickets(
            purchasePriceInput.availableNumberOfTickets());

        lottoGameView.printLottoTickets(LottoTicketsDTO.from(manualPurchaseTickets),
            LottoTicketsDTO.from(autoPurchaseTickets));

        autoPurchaseTickets.addAllTickets(manualPurchaseTickets);
        lottoGameStatus = LottoGameStatus.of(autoPurchaseTickets, purchasePriceInput);
    }

    private LottoPurchasePrice getPurchasePriceInLoop() {
        Optional<LottoPurchasePrice> purchasePriceInput;
        do {
            purchasePriceInput = getPurchasePriceFromUser();
        } while (purchasePriceInput.isEmpty());

        return purchasePriceInput.get();
    }

    private Optional<LottoPurchasePrice> getPurchasePriceFromUser() {
        String input = lottoGameView.inputPurchasePrice();
        try {
            return Optional.of(LottoPurchasePrice.from(Integer.parseInt(input)));
        } catch (NumberFormatException e) {
            System.err.println(NUMBER_FORMAT_ERROR_MESSAGE);
            return Optional.empty();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return Optional.empty();
        }
    }

    private LottoTickets manualPurchaseTickets(LottoPurchasePrice lottoPurchasePrice) {
        int manualPurchaseAmount = getManualPurchaseAmountInLoop(lottoPurchasePrice);

        return getManualPurchaseLottoFromUser(manualPurchaseAmount);
    }

    private Integer getManualPurchaseAmountInLoop(LottoPurchasePrice purchasePrice) {
        Optional<Integer> manualPurchaseAmountInput;
        do {
            manualPurchaseAmountInput = getManualPurchaseAmountFromUser(purchasePrice);
        } while (manualPurchaseAmountInput.isEmpty());

        return manualPurchaseAmountInput.get();
    }

    private Optional<Integer> getManualPurchaseAmountFromUser(LottoPurchasePrice purchasePrice) {
        String input = lottoGameView.inputManualPurchaseAmount();
        try {
            int amount = Integer.parseInt(input);
            purchasePrice.purchaseAmountOrElseThrow(amount);
            return Optional.of(Integer.valueOf(input));
        } catch (NumberFormatException e) {
            System.err.println(NUMBER_FORMAT_ERROR_MESSAGE);
            return Optional.empty();
        } catch (InputMismatchException e) {
            System.err.println(e.getMessage());
            return Optional.empty();
        }
    }

    private LottoTickets getManualPurchaseLottoFromUser(int amount) {
        lottoGameView.printManualLottoTicketMessage();

        return LottoTickets.from(IntStream.range(0, amount).boxed()
            .map(x -> getLottoNumbersInLoop())
            .collect(Collectors.toList()));
    }

    private Lotto getLottoNumbersInLoop() {
        Optional<Lotto> winningLottoInput;
        do {
            winningLottoInput = getLottoNumbersFromUser();
        } while (winningLottoInput.isEmpty());

        return winningLottoInput.get();
    }

    private Optional<Lotto> getLottoNumbersFromUser() {
        String[] input = lottoGameView.inputLottoNumbers();
        try {
            return Optional.of(lottoMachine.issueLottoTicketWithNumbers(
                Arrays.stream(input)
                    .map(Integer::valueOf)
                    .map(LottoNumber::from)
                    .sorted()
                    .collect(Collectors.toList())));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return Optional.empty();
        }
    }

    private void makeGameResult() {
        WinningLotto winningLottoInput = getWinningLottoInLoop();

        LottoRankCount lottoRankCount = LottoRankCount.of(winningLottoInput,
            lottoGameStatus.getLottoTickets());

        LottoGameResult lottoGameResult = LottoGameResult.of(lottoRankCount,
            lottoGameStatus.getPurchasePrice());

        lottoGameView.printLottoResult(LottoResultDTO.from(lottoGameResult));
    }

    private WinningLotto getWinningLottoInLoop() {
        lottoGameView.printWinningLottoNumbersMessage();
        Lotto lottoInput = getLottoNumbersInLoop();

        Optional<WinningLotto> winningLottoInput;
        do {
            winningLottoInput = getWinningLottoFromUser(lottoInput);
        } while (winningLottoInput.isEmpty());

        return winningLottoInput.get();
    }

    private Optional<WinningLotto> getWinningLottoFromUser(Lotto lotto) {
        String input = lottoGameView.inputBonusNumber();
        try {
            return Optional.of(
                lottoMachine.issueWinningLotto(lotto, LottoNumber.from(Integer.parseInt(input))));
        } catch (NumberFormatException e) {
            System.err.println(NUMBER_FORMAT_ERROR_MESSAGE);
            return Optional.empty();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return Optional.empty();
        }
    }
}
