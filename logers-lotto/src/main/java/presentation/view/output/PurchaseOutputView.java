package presentation.view.output;

<<<<<<< HEAD
import dto.output.PurchaseResultDto;

public class PurchaseOutputView implements OutputView{
    private final PurchaseResultDto purchaseResultDto;

    public PurchaseOutputView(PurchaseResultDto purchaseResultDto) {
        this.purchaseResultDto = purchaseResultDto;
=======
import dto.output.PurchaseOutputDto;

public class PurchaseOutputView implements OutputView{
    private final PurchaseOutputDto purchaseDto;

    public PurchaseOutputView(PurchaseOutputDto purchaseDto) {
        this.purchaseDto = purchaseDto;
>>>>>>> a030324 (refactor : 구조개선)
    }

    @Override
    public void print() {
<<<<<<< HEAD
        System.out.println(purchaseResultDto);
=======

>>>>>>> a030324 (refactor : 구조개선)
    }
}
