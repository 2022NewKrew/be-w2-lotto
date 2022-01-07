package com.kakaocorp.lotto.controller;

import com.kakaocorp.lotto.domain.Lotto;
import com.kakaocorp.lotto.exception.MoneyException;
import com.kakaocorp.lotto.exception.NumberSequenceException;

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
            if (validateLottoNumbers(lottoNumbers)) {
                throw new NumberSequenceException("1부터 45까지의 숫자 중 구매할 번호 6개를 ','로 구분하여 입력한 후 엔터키를 누르세요. 그리고 사고 싶은 개수만큼 반복하세요.");
            }
            lottoList.add(new Lotto(lottoNumbers));
        });

        return lottoList;
    }

    private boolean validateLottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            return true;
        }

        return false;
    }

    public int inputOrderPrice(String message) throws MoneyException {
        int inputInt = inputInt(message);
        if (inputInt < 1000) {
            throw new MoneyException("구입 금액은 1000원 이상을 입력해야 합니다(로또 1장에 1000원).");
        }

        return inputInt;
    }

    public int inputOrderManualNumber(String message, int orderPrice) throws MoneyException {
        int inputInt = inputInt(message);
        int orderLimit = orderPrice / 1000;
        if (inputInt > orderLimit) {
            throw new MoneyException(orderPrice + "원으로 구매할 수 있는 로또 수는 " + orderLimit + "개입니다(로또 1장에 1000원).");
        }

        return inputInt;
    }
}
