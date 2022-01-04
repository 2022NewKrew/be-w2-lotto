package view;

import domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoView {

    public static void printLottoNumber(String lottoNumber) {
        System.out.print("[");
        System.out.print(lottoNumber);
        System.out.println("]");
    }
}
