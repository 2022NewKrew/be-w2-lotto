package domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numberList;
    private static LottoGenerator lottoGenerator = new LottoGenerator();
    Lotto()
    {
        this.numberList = lottoGenerator.getLottoNumbers();
        //lottoGenerator에 의해 lotto번호 생성 됨.
    }

    public List<Integer> getNumberList() {
        return numberList;
    }
}
