package step2.dto;

import step2.domain.LottoSheetWithId;

import java.util.List;
import java.util.stream.Collectors;

public class LottoSheetDto {
    private Long id;
    private List<LottoDto> lottoDtoList;

    public LottoSheetDto(List<LottoDto> lottoDtoList, Long id) {
        this.id = id;
        this.lottoDtoList = lottoDtoList;
    }

    public List<LottoDto> getLottoDtoList() {
        return lottoDtoList;
    }

    public Long getId() {
        return id;
    }

    public static LottoSheetDto of(LottoSheetWithId lottoSheet) {
        List<LottoDto> lottoDtoList = lottoSheet.getLottoList().stream()
                .map(LottoDto::of)
                .collect(Collectors.toList());
        return new LottoSheetDto(lottoDtoList, lottoSheet.getId());
    }

}
