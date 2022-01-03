package com.kakaocorp.lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
        return Arrays.stream(numbersLine.split(","))
                .map(s -> Integer.parseInt(s.trim()))
                .collect(Collectors.toList());
    }
}
