package lotto;

import lotto.controller.LottoController;
import lotto.dto.LottoCheckRequestDto;
import lotto.dto.LottoCheckResponseDto;
import lotto.dto.LottoPurchaseRequestDto;
import lotto.dto.LottoPurchaseResponseDto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {

        // 구입 금액 입력.
        int purchaseAmount = InputView.getPurchaseAmount();
        // 로또 구매 수 계산. InputView 에서 간단히 처리해도 되지만, View 에 로직을 넣고 싶지 않아서 Controller 로 부터 얻도록 분리.
        int lottoPurchaseCount = LottoController.calculateLottoPurchaseCount(purchaseAmount);
        // 수동 구매 수 입력.
        int manualPurchaseCount = InputView.getManualPurchaseCount(lottoPurchaseCount);
        // 수동 구매 번호 입력.
        List<List<Integer>> manualPurchaseNumberLists = InputView.getManualPurchaseNumberLists(manualPurchaseCount);
        // 구매 정보 생성.
        LottoPurchaseRequestDto lottoPurchaseRequestDto = new LottoPurchaseRequestDto(purchaseAmount, manualPurchaseCount, manualPurchaseNumberLists);
        // 로또 구매.
        LottoPurchaseResponseDto lottoPurchaseResponseDto = LottoController.purchaseLottoBundle(lottoPurchaseRequestDto);
        // 구매 로또 출력.
        OutputView.printLottoBundle(manualPurchaseCount, lottoPurchaseCount, lottoPurchaseResponseDto.getLottoBundleString());
        // 당첨 번호 입력.
        List<Integer> winningNumberList = InputView.getWinningNumberList();
        // 보너스 볼 입력.
        int bonusNumber = InputView.getBonusNumber();
        // 확인 정보 생성.
        LottoCheckRequestDto lottoCheckRequestDto = new LottoCheckRequestDto(winningNumberList, bonusNumber, lottoPurchaseResponseDto.getLottoBundle());
        // 로또 당첨 확인.
        LottoCheckResponseDto lottoCheckResponseDto = LottoController.checkLottoBundle(lottoCheckRequestDto);
        // 당첨 통계 출력.
        OutputView.printLottoResults(lottoCheckResponseDto.getEarningRate(), lottoCheckResponseDto.getLottoRankString());
    }
}
