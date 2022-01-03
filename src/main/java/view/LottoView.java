package view;

import dto.LottoDTO;

import java.util.stream.Collectors;

public class LottoView {
    LottoDTO lottoDTO;
    String view;

    public LottoView(LottoDTO lottoDTO) {
        this.lottoDTO = lottoDTO;
        this.view = "["
                + lottoDTO.getNumber()
                        .stream()
                        .map(integer -> String.valueOf(integer))
                        .collect(Collectors.joining(", "))
                + "]";
    }

    public void printLotto() {
        System.out.println(view);
    }
}
