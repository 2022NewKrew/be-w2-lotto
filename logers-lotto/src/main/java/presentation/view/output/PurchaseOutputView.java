package presentation.view.output;


import dto.output.PurchaseResultDto;

public class PurchaseOutputView implements OutputView{
    private final PurchaseResultDto purchaseResultDto;


    public PurchaseOutputView(PurchaseResultDto purchaseResultDto) {
        this.purchaseResultDto = purchaseResultDto;
    }

    @Override
    public void print() {
        System.out.println(purchaseResultDto);
    }
}
