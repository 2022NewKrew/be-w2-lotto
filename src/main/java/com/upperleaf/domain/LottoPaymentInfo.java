package com.upperleaf.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoPaymentInfo {

    private final long paymentAmount;
    private final List<List<Integer>> lottoNumbers;

    private Long id;
    /**
     * 로또 지불 정보
     * @param paymentAmount 사용자가 로또를 사기위해 지불한 금액
     */
    public LottoPaymentInfo(long paymentAmount, String allNumber) {
        validation(paymentAmount);
        this.paymentAmount = paymentAmount;
        this.lottoNumbers = convertAllNumbersToIntegerList(allNumber);
    }

    public LottoPaymentInfo(long paymentAmount, List<String> numbers) {
        validation(paymentAmount);
        this.paymentAmount = paymentAmount;
        this.lottoNumbers = convertNumbersToIntegerList(numbers);
    }

    public long getPaymentAmount() {
        return paymentAmount;
    }

    public List<List<Integer>> getLottoNumbers() {
        return lottoNumbers;
    }

    private void validation(long paymentAmount) {
        if(paymentAmount < 0) {
            throw new IllegalArgumentException("로또 지불 값은 음수 일 수 없습니다.");
        }
    }

    private List<List<Integer>> convertNumbersToIntegerList(List<String> numberList) {
        return numberList.stream().map(numbers -> Arrays.stream(numbers.split(",")))
                .map(numberStream -> numberStream.map(num -> Integer.parseInt(num.trim())))
                .map(numStream -> numStream.collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    private List<List<Integer>> convertAllNumbersToIntegerList(String manualNumber) {
        List<String> numbers = Arrays.stream(manualNumber.split("\n")).collect(Collectors.toList());
        return convertNumbersToIntegerList(numbers);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
