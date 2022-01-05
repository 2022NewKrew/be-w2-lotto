package com.kakao.lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author    : brody.moon
 * version   : 1.0
 * 로또 번호를 가지고 있는 List<Integer> 를 가독성을 위해 따로 분리한 클래스입니다.
 */
public class LottoNumber {
    private final List<Integer> lottonumber;

    public LottoNumber(List<Integer> lottonumber) {
        this.lottonumber = lottonumber;
    }

    public LottoNumber(int[] lottonumber){
        this.lottonumber = Arrays.stream(lottonumber).boxed().collect(Collectors.toList());
    }

    public int get(int i){
        return lottonumber.get(i);
    }

    public int size(){
        return lottonumber.size();
    }

    public List<Integer> getAll(){
        return lottonumber;
    }

    public LottoNumber toUnmodifiableList(){
        return new LottoNumber(Collections.unmodifiableList(lottonumber));
    }

    @Override
    public String toString() {
        return lottonumber.toString();
    }
}
