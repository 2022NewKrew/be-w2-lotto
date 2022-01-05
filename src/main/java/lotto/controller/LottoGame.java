package lotto.controller;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
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
    private static final String PRICE_ERROR_MESSAGE = "로또 한 장 당 %d원 입니다.%n"
        + "남은 금액은 지갑에 다시 넣어드리겠습니다.%n";

    private static final int TICKET_PRICE = 1000;

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

        LottoTickets lottoTickets = lottoMachine.purchaseLottoTickets(
            purchasePriceInput.availableNumberOfTickets());

        lottoGameStatus = LottoGameStatus.of(lottoTickets, purchasePriceInput);
        lottoGameView.printLottoTickets(LottoTicketsDTO.from(lottoTickets));
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

    private void makeGameResult() {
        WinningLotto winningLottoInput = getWinningLottoInLoop();

        LottoRankCount lottoRankCount = LottoRankCount.of(winningLottoInput,
            lottoGameStatus.getLottoTickets());

        LottoGameResult lottoGameResult = LottoGameResult.of(lottoRankCount,
            lottoGameStatus.getPurchasePrice());

        lottoGameView.printLottoResult(generateLottoResultDTO(lottoGameResult));
    }

    private WinningLotto getWinningLottoInLoop() {
        Lotto lottoInput = getLottoNumbersInLoop();

        Optional<WinningLotto> winningLottoInput;
        do {
            winningLottoInput = getWinningLottoFromUser(lottoInput);
        } while (winningLottoInput.isEmpty());

        return winningLottoInput.get();
    }

    private Lotto getLottoNumbersInLoop() {
        Optional<Lotto> winningLottoInput;
        do {
            winningLottoInput = getLottoNumbersFromUser();
        } while (winningLottoInput.isEmpty());

        return winningLottoInput.get();
    }

    private Optional<Lotto> getLottoNumbersFromUser() {
        String[] input = lottoGameView.inputWinningLottoNumbers();
        try {
            return Optional.of(lottoMachine.issueLottoTicketWithNumbers(
                Arrays.stream(input)
                    .map(Integer::valueOf)
                    .map(LottoNumber::from)
                    .collect(Collectors.toList())));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return Optional.empty();
        }
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

    private LottoResultDTO generateLottoResultDTO(LottoGameResult lottoGameResult) {
        return LottoResultDTO.from(lottoGameResult);
    }
}
