package lotto.dto;

import java.util.Collections;
import java.util.List;

public class LottoGameDto {
    private final List<Integer> pickedList;

    public LottoGameDto(List<Integer> pickedList) {
        this.pickedList = pickedList;
    }

    public List<Integer> getPickedList() {
        return Collections.unmodifiableList(pickedList);
    }

    @Override
    public String toString() {
        return pickedList.toString();
    }
}
