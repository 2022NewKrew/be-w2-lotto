package com.kakao.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private List<Integer> lottoNumbers;
    private LottoType lottoType;

    public Lotto() {
        makeAutoLotto();
    }

    public Lotto(List<Integer> lottoNumbers) {
        makeCustomLotto(lottoNumbers);
    }

    public List<Integer> getLottoNumber() { return lottoNumbers; }

    public LottoType getType() { return lottoType; }

    private void makeAutoLotto() {
        List<Integer> lottoNumberList = IntStream.range(1, 46).boxed().collect(Collectors.toList());
        Collections.shuffle(lottoNumberList);
        lottoNumbers = lottoNumberList.subList(0, 6);
        Collections.sort(lottoNumbers);
        lottoType = LottoType.AUTO;
    }

    private void makeCustomLotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        lottoType = LottoType.CUSTOM;
    }

    @Override
    public String toString() { return lottoNumbers.toString(); }
}
