package util;

import model.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class Util {
    private Util() {
    }

    public static List<LottoNumber> convertIntegerListToLottoList(List<Integer> IntegerList){
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int number: IntegerList){
            lottoNumbers.add(new LottoNumber(number));
        }

        return lottoNumbers;
    }
}
