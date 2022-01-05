package lotto.view;


import lotto.controller.LottoController;
import lotto.domain.component.*;
import lotto.domain.result.LottoResult;
import lotto.dto.GetLottoResultDTO;
import lotto.dto.PurChasingLottoDTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static lotto.domain.component.LottoPrice.LOTTO_MIN_PRICE;

public class InputView {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final LottoController lottoController = new LottoController();

    private InputView() {

    }

    public static PurChasingLottoDTO inputPrice() throws IOException {
        LottoPrice lottoPrice = inputLottoPrice();
        int numberOfManualLotto = inputNumberOfManualPurchaseLotto(lottoPrice.getPrice());
        List<LottoTicket> manualLottoTickets = inputManualLottoNumbers(numberOfManualLotto);
        List<LottoTicket> autoTickets = lottoController.issueAutoLotto(lottoPrice.getPrice() -
                numberOfManualLotto * LOTTO_MIN_PRICE);

        return new PurChasingLottoDTO(manualLottoTickets, autoTickets, lottoPrice.getPrice());
    }

    public static WinningLottoTicket inputWinningTicket() throws IOException {
        return lottoController.issueWinningLotto(inputWinningNumber(), inputBonusBall());
    }

    public static LottoResult inputLottoResult(GetLottoResultDTO getLottoResultDTO) {
        return lottoController.getLottoResult(getLottoResultDTO);
    }


    private static LottoPrice inputLottoPrice() throws IOException {
        System.out.println("구매금액을 입력해 주세요.");
        return new LottoPrice(stoi(br.readLine()));
    }

    private static LottoTicket inputWinningNumber() throws IOException {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new LottoTicket(br.readLine());
    }

    private static LottoNumber inputBonusBall() throws IOException {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new LottoNumber(stoi(br.readLine()));
    }

    private static int inputNumberOfManualPurchaseLotto(int purchasePrice) throws IOException {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return new NumberOfLottoPurchase(stoi(br.readLine()), purchasePrice).getNumber();
    }

    private static List<LottoTicket> inputManualLottoNumbers(int numberOfPurchase) throws IOException {
        System.out.println("수동으로 구매할 로또 번호를 입력해 주세요.");
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < numberOfPurchase; i++) {
            lottoTickets.add(new LottoTicket(br.readLine()));
        }
        return lottoTickets;
    }

    private static int stoi(String input) {
        return Integer.parseInt(input);
    }
}
