package controller;

import dto.PurchasingSheetDTO;
import service.AutoLottoService;
import service.LottoService;

public class ConsoleInputController implements InputController {
    private final LottoService autoLottoService = new AutoLottoService();

    @Override
    public Long purchaseLotto(PurchasingSheetDTO purchasingSheetDTO) {
        return autoLottoService.purchaseLotto(purchasingSheetDTO);
    }
}
