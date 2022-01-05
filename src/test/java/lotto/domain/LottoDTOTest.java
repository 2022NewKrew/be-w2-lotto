package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LottoDTOTest {

    @Test
    void getLastWeekLottoNumberList() {

        String lastWeekLottoNumbers = "1,2,3,4,5,6";
        ArrayList<Integer> testArray = new ArrayList<>();
        for(int i=1;i<=6;i++)
            testArray.add(i);
        assertArrayEquals(LottoDTO.getLastWeekLottoNumberList(lastWeekLottoNumbers).toArray(),testArray.toArray());
    }
}