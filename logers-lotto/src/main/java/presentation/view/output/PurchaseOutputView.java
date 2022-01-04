package presentation.view.output;

import dto.output.PurchaseOutputDto;

public class PurchaseOutputView implements OutputView{
    private final PurchaseOutputDto purchaseDto;

    public PurchaseOutputView(PurchaseOutputDto purchaseDto) {
        this.purchaseDto = purchaseDto;
    }

    @Override
    public void print() {

    }
}
