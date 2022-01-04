package dto.output;

import java.util.List;
import java.util.stream.Collectors;

public class PurchaseResultDto {
    private final List<List<Integer>> purchaseNumbers;

    public PurchaseResultDto(List<List<Integer>> lottos) {
        this.purchaseNumbers = lottos;
    }

    @Override
    public String toString() {
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
    }
}
