package lotto.controller;

import lotto.dto.LottoCheckRequestDto;
import lotto.dto.LottoCheckResponseDto;
import lotto.dto.LottoPurchaseRequestDto;
import lotto.dto.LottoPurchaseResponseDto;
import lotto.service.LottoService;

public class LottoController {

    private LottoController() {
        throw new AssertionError();
    }

    /**
     * 로또 구입금액을 입력 받고, 최대 구입 개수를 계산을 한 뒤, 응답을 반환.
     */
    public static int calculateLottoPurchaseCount(int purchaseAmount) {
        return LottoService.calculateLottoPurchaseCount(purchaseAmount);
    }

    /**
     * 구매 정보를 입력 받고, 구매를 한 뒤, 응답을 반환.
     */
    public static LottoPurchaseResponseDto purchaseLottoBundle(LottoPurchaseRequestDto lottoPurchaseRequestDto) {
        return LottoService.purchaseLottoBundle(lottoPurchaseRequestDto);
    }

    /**
     * 확인하고 싶은 내용<당첨번호, 보너스 볼, 복권 리스트>을 입력 받고, 당첨 정보 및 수익률을 계산한 뒤, 응답을 반환.
     */
    public static LottoCheckResponseDto checkLottoBundle(LottoCheckRequestDto lottoCheckRequestDto) {
        return LottoService.checkLottoBundle(lottoCheckRequestDto);
    }
}
