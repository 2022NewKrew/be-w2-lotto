package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoGameResult;
import lotto.domain.LottoGameStatus;
import lotto.domain.LottoMachine;
import lotto.domain.WinningLotto;
import lotto.dto.LottoDTO;
import lotto.dto.LottoResultDTO;
import lotto.view.LottoGameView;

public class LottoGame {

    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "숫자만 입력해주세요.";
    private static final String PRICE_ERROR_MESSAGE = "로또 한 장 당 %d원 입니다.%n"
        + "남은 금액 %d원은 지갑에 다시 넣어드리겠습니다.%n";

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
        int purchasePriceInput = getPurchasePriceInLoop();
        int numberOfTickets = purchasePriceInput / TICKET_PRICE;
        List<Lotto> lottoTickets = lottoMachine.purchaseLottoTickets(numberOfTickets);

        lottoGameStatus = LottoGameStatus.of(purchasePriceInput, lottoTickets);
        lottoGameView.printLottoTickets(convertTicketsToDTOs(lottoTickets));
    }

    private int getPurchasePriceInLoop() {
        Optional<Integer> purchasePriceInput;
        do {
            purchasePriceInput = getPurchasePriceFromUser();
        } while (purchasePriceInput.isEmpty());

        return purchasePriceInput.get();
    }

    private Optional<Integer> getPurchasePriceFromUser() {
        String input = lottoGameView.inputPurchasePrice();
        try {
            return Optional.of(cutOffLessThanOneThousand(Integer.parseInt(input)));
        } catch (NumberFormatException e) {
            System.err.println(NUMBER_FORMAT_ERROR_MESSAGE);
            return Optional.empty();
        }
    }

    private int cutOffLessThanOneThousand(int value) {
        int remainingAmount = value % TICKET_PRICE;
        if (remainingAmount > 0) {
            System.err.printf(PRICE_ERROR_MESSAGE, TICKET_PRICE, remainingAmount);
        }
        return value - remainingAmount;
    }

    private List<LottoDTO> convertTicketsToDTOs(List<Lotto> lottoTickets) {
        return lottoTickets.stream().map(LottoDTO::from)
            .collect(Collectors.toList());
    }

    private void makeGameResult() {
        WinningLotto winningLottoInput = getWinningLottoInLoop();

        LottoGameResult lottoGameResult = LottoGameResult.of(winningLottoInput,
            lottoGameStatus.getLottoTickets(),
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
            return Optional.of(lottoMachine.generateLottoTicketWithNumbers(
                Arrays.stream(input)
                    .map(Integer::valueOf)
                    .collect(Collectors.toList())));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return Optional.empty();
        }
    }

    private Optional<WinningLotto> getWinningLottoFromUser(Lotto lotto) {
        String input = lottoGameView.inputBonusNumber();
        try {
            return Optional.of(lottoMachine.generateWinningLotto(lotto, Integer.parseInt(input)));
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
