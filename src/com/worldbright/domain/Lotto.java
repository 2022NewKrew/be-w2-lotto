package com.worldbright.domain;

import com.worldbright.dto.LottoDTO;
import com.worldbright.view.LottoView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private final List<LottoDTO> lottoDTOs;
    private final List<LottoView> lottoViews;

    public Lotto(int n) {
        lottoDTOs = IntStream.rangeClosed(0, n).mapToObj(i -> new LottoDTO()).collect(Collectors.toList());
        lottoViews = lottoDTOs.stream().map(dto -> new LottoView(dto)).collect(Collectors.toList());
    }

    public List<LottoView> getLottoViews() {
        return lottoViews;
    }

    public List<Integer> getResult(LottoDTO winning) {
        int[] ret = new int[7];
        for (LottoDTO lotto : lottoDTOs) {
            ret[lotto.getSameNumber(winning)]++;
        }
        return Arrays.stream(ret).boxed().collect(Collectors.toList());
    }
}
