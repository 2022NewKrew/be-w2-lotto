package domain.test;

import domain.Lotto;
import domain.Number;
import service.LottoGenerator;

import java.util.ArrayList;
import java.util.Arrays;

public class LottoTestGenerator implements LottoGenerator {
    public Lotto generate(int a, int b, int c, int d, int e, int f){
        ArrayList<Number> numberList = new ArrayList<>(Arrays.asList(new Number(a),new Number(b),
                new Number(c),new Number(d),new Number(e),new Number(f)));
        return new Lotto(numberList);
    };

    @Override
    public Lotto generate() {
        return null;
    }
}
