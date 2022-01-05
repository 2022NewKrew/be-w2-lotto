package dto.output;


import java.util.List;
import java.util.stream.Collectors;

public class PurchaseResultDto {
    private final List<List<Integer>> lottoNumberLists;


    public PurchaseResultDto(List<List<Integer>> lottoNumberLists) {
        this.lottoNumberLists = lottoNumberLists;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumberLists.size())
                .concat("개를 구매했습니다.\n")
                .concat(toStringLottoNumberLists(lottoNumberLists));
    }

    private static String toStringLottoNumberLists(List<List<Integer>> lottoNumberLists){
        return lottoNumberLists.stream()
                .map(PurchaseResultDto::toStringLottoNumbers)
                .collect(Collectors.joining("\n"));
    }

    private static String toStringLottoNumbers(List<Integer> lottoNumbers) {
        return "["
                .concat(lottoNumbers.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(","))
                ).concat("]");
    }
}
