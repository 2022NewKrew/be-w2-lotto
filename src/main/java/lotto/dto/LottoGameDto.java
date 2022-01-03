package lotto.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGameDto {
    private final List<Integer> pickedList = new ArrayList<>();

    public LottoGameDto() {
    }

    public List<Integer> getPickedList() {
        return Collections.unmodifiableList(pickedList);
    }

    @Override
    public String toString() {
        return pickedList.toString();
    }
}
