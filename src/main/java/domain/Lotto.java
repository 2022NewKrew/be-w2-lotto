package domain;

import dto.LottoDTO;
import view.LottoView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private final List<LottoDTO> lottoDTOs;
    private final List<LottoView> lottoViews;

    public Lotto(int n) {
        lottoDTOs = Stream.generate(LottoDTO::new).limit(n).collect(Collectors.toList());
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
