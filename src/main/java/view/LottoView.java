package view;

import domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoView {

    public static void printLottoNumber(List<Integer> lottoNumber) {
        System.out.print("[");
        System.out.print(lottoNumber.stream().map(v -> v.toString()).collect(Collectors.joining(",")));
        System.out.println("]");
    }
}