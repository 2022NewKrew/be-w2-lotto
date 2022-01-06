package dto.output;


import java.util.Collections;
import java.util.List;

public class PurchaseResultDto {
    private final List<List<Integer>> lottoNumberLists;


    public PurchaseResultDto(List<List<Integer>> lottoNumberLists) {
        this.lottoNumberLists = lottoNumberLists;
    }

    public int getSize(){
        return lottoNumberLists.size();
    }

    public List<List<Integer>> getLottoNumberLists() {
        return Collections.unmodifiableList(lottoNumberLists);
    }
}
