package controller;

import dto.PurchasingSheet;
import service.AutoLottoService;
import service.LottoService;

public class ConsoleInputController implements InputController {
    private final LottoService autoLottoService = new AutoLottoService();

    @Override
    public Long purchaseLotto(PurchasingSheet purchasingSheet) {
        return autoLottoService.purchaseLotto(purchasingSheet);
    }
}
