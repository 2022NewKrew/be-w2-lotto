package com.david.lotto.web;

import com.david.lotto.Lotto;
import com.david.lotto.LottoGenerator;
import com.david.lotto.LottoMachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoWebInput {

    public int convertToInt(String inputString) {
        return Integer.parseInt(inputString);
    }

    public List<Lotto> convertToLottoList(String inputString, int amount) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        int countOfLotto = amount / LottoMachine.lottoPrice;
        List<String> manualNumberList = Arrays.stream(inputString.split("\\r?\\n")).collect(Collectors.toList());
        int manualCount = manualNumberList.size();
        List<List<Integer>> manualLottoList = new ArrayList<>();
        manualNumberList.forEach(stringNumber -> manualLottoList.add(convertToNumberList(stringNumber)));
        return lottoGenerator.generateLottoList(countOfLotto, manualCount, manualLottoList);
    }

    public List<Integer> convertToNumberList(String inputString) {
        return Arrays.stream(inputString.split("\\s*,\\s*"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
