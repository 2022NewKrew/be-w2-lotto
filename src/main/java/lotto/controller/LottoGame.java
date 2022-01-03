package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.dto.LottoDTO;
import lotto.validator.LottoGameInputValidator;
import lotto.view.LottoGameResultView;
import lotto.view.LottoGameView;

public class LottoGame {

    public static final int TICKET_PRICE = 1000;

    private final LottoGameView lottoGameView;
    private final LottoGameInputValidator lottoGameInputValidator;

    private final LottoMachine lottoMachine;

    private List<Lotto> lottoList;
    private int purchasePrice;

    public LottoGame() {
        lottoMachine = new LottoMachine();
        lottoGameView = new LottoGameView();
        lottoGameInputValidator = new LottoGameInputValidator();
    }

    public void run() {
        initGame();
        checkLottoGameResult();
    }

    private void checkLottoGameResult() {
        LottoDTO lottoDTO = null;
        while (lottoDTO == null) {
            lottoDTO = inputAndValidateWinningNumbers();
        }
        LottoGameResultView lottoGameResultView = new LottoGameResultView(lottoDTO,
            convertLottoListToLottoDTOList(lottoList));

        lottoGameResultView.printLottoGameResult(purchasePrice);
    }

    private LottoDTO inputAndValidateWinningNumbers() {
        try {
            LottoDTO winningLotto = lottoGameView.inputWinningNumbers();
            lottoGameInputValidator.winningNumbersValidate(winningLotto);
            return winningLotto;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    private void initGame() {
        purchasePrice = inputAndValidatePrice();

        lottoList = lottoMachine.purchaseLottoTickets(purchasePrice / TICKET_PRICE);
        lottoGameView.printLottoTickets(convertLottoListToLottoDTOList(lottoList));
    }

    private int inputAndValidatePrice() {
        int purchasePrice = lottoGameView.inputPurchasePrice();
        return lottoGameInputValidator.purchasePriceValidate(purchasePrice);
    }

    private List<LottoDTO> convertLottoListToLottoDTOList(List<Lotto> lottoList) {
        return lottoList.stream()
            .map(lotto -> new LottoDTO(lotto.getLottoNumbers()))
            .collect(Collectors.toList());
    }
}
