package com.upperleaf.domain.lotto.create;

import com.upperleaf.domain.lotto.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManualLottoStrategy implements LottoCreateStrategy {

    private static final Scanner sc = new Scanner(System.in);

    @Override
    public Lotto createLotto() {
        String numbers = sc.nextLine();
        List<Integer> numberList = splitAndConvertToInt(numbers);
        LottoValidator.validation(numberList);
        return new Lotto(numberList);
    }

    private List<Integer> splitAndConvertToInt(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(number -> Integer.parseInt(number.trim()))
                .collect(Collectors.toList());
    }
}
