package com.worldbright.view;

import com.worldbright.dto.LottoDTO;

import java.util.stream.Collectors;

public class LottoView {
    LottoDTO lottoDTO;
    String view;

    public LottoView(LottoDTO lottoDTO) {
        this.lottoDTO = lottoDTO;
        this.view = "["
                + String.join(", ",
                lottoDTO.getNumber()
                        .stream()
                        .map(integer -> String.valueOf(integer))
                        .collect(Collectors.toList()))
                + "]";
    }

    public void printLotto() {
        System.out.println(view);
    }
}
