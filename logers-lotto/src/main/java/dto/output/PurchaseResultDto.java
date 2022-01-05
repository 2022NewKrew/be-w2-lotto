package dto.output;


import java.util.List;
import java.util.stream.Collectors;

public class PurchaseResultDto {
    private final List<List<Integer>> lottoNumberLists;

<<<<<<< HEAD

    public PurchaseResultDto(List<List<Integer>> lottos) {
        this.purchaseNumbers = lottos;
=======
    public PurchaseResultDto(List<List<Integer>> lottoNumberLists) {
        this.lottoNumberLists = lottoNumberLists;
>>>>>>> f8c6482 (refactor : 클래스 이름, 변수, 함수 네이밍 변경 및 메서드 로직 가독성 향상)
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
