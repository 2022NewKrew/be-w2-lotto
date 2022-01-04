package presentation.view.output;

import dto.output.PurchaseOutputDto;

public class PurchaseOutputView implements OutputView{
    private final PurchaseOutputDto purchaseOutputDto;

    public PurchaseOutputView(PurchaseOutputDto purchaseOutputDto) {
        this.purchaseOutputDto = purchaseOutputDto;
    }

    @Override
    public void print() {
        System.out.println(purchaseOutputDto);
    }
}
