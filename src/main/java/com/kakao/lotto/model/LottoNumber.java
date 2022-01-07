package com.kakao.lotto.model;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * author    : brody.moon
 * version   : 1.0
 * 로또 번호를 가지고 있는 List<Integer> 를 가독성을 위해 따로 분리한 클래스입니다.
 */
public class LottoNumber {
    private final Set<Integer> lottonumber;

    public LottoNumber(Set<Integer> lottonumber) {
        this.lottonumber = lottonumber;
    }

    public LottoNumber(int[] lottonumber){
        this.lottonumber = Arrays.stream(lottonumber).boxed().collect(Collectors.toUnmodifiableSet());
    }

    public LottoNumber(String lottoNumberString){
        this.lottonumber = Arrays.stream(lottoNumberString.split(",")).map(String::trim).map(Integer::parseInt).collect(Collectors.toUnmodifiableSet());
    }

    public int size(){
        return lottonumber.size();
    }

    public Set<Integer> getAll(){
        return lottonumber;
    }

    @Override
    public String toString() {
        return lottonumber.toString();
    }
}
