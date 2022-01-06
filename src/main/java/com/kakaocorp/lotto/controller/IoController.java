package com.kakaocorp.lotto.controller;

import com.kakaocorp.lotto.domain.Lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IoController {

    private static final Scanner sc = new Scanner(System.in);

    public int inputInt(String message) {
        System.out.println(message);
        return Integer.parseInt(sc.nextLine());
    }

    public String inputString(String message) {
        System.out.println(message);
        return sc.nextLine();
    }

    public List<Integer> inputNumbers(String message) {
        String numbersLine = inputString(message);
        return splitAndSortNumbersLine(numbersLine);
    }

    private List<Integer> splitAndSortNumbersLine(String numbersLine) {
        List<Integer> result = Arrays.stream(numbersLine.split(","))
                .map(s -> Integer.parseInt(s.trim()))
                .sorted()
                .collect(Collectors.toList());
        return result;
    }

    public List<Lotto> inputManualNumbers(String message, int orderManualNumber) {
        List<Lotto> lottoList = new ArrayList<>();
        System.out.println(message);
        IntStream.range(0, orderManualNumber).forEach(i -> {
            List<Integer> lottoNumbers = splitAndSortNumbersLine(sc.nextLine());
            lottoList.add(new Lotto(lottoNumbers));
        });

        return lottoList;
    }
}
