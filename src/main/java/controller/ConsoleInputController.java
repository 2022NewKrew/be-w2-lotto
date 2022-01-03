package controller;

import service.AutoLottoService;
import service.LottoService;

public class ConsoleInputController implements InputController {
    private final LottoService autoLottoService = new AutoLottoService();

    @Override
    public Long purchaseLotto(int quantity){
        return autoLottoService.purchaseLotto(quantity);
    }
}
