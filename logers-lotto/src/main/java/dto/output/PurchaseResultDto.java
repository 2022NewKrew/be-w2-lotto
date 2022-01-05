package dto.output;

<<<<<<< HEAD
import java.util.List;
import java.util.stream.Collectors;

public class PurchaseResultDto {
    private final List<List<Integer>> purchaseNumbers;

    public PurchaseResultDto(List<List<Integer>> lottos) {
        this.purchaseNumbers = lottos;
=======
import domain.LottoOrder;

public class PurchaseResultDto {
    private final LottoOrder lottoOrder;

    public PurchaseResultDto(LottoOrder lottoOrder) {
        this.lottoOrder = lottoOrder;
>>>>>>> 7f4f290 (refactor : ResultOutputDto 수정)
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return String.valueOf(purchaseNumbers.size())
                .concat("개를 구매했습니다.\n")
                .concat(purchaseNumbers.stream()
                        .map(PurchaseResultDto::toString)
                        .collect(Collectors.joining("\n"))
                );
    }

    private static String toString(List<Integer> lottoNumbers) {
        return "["
                .concat(lottoNumbers.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(","))
                ).concat("]");
=======
        return lottoOrder.toString();
>>>>>>> 7f4f290 (refactor : ResultOutputDto 수정)
    }
}
