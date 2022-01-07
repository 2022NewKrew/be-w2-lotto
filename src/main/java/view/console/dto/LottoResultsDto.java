package view.console.dto;

import domain.LottoResult;
import domain.LottoResults;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResultsDto {

    private List<LottoResultDto> lottoResultDtos;

    public LottoResultsDto(LottoResults lottoResults) {
        lottoResultDtos = initialize(lottoResults);
    }

    private List<LottoResultDto> initialize(LottoResults lottoResults) {
        return Arrays.stream(LottoResult.values())
                .map(lottoResult -> new LottoResultDto(lottoResult, lottoResults.getCountBy(lottoResult)))
                .sorted()
                .collect(Collectors.toList());
    }

    public List<LottoResultDto> getLottoResultDtos() {
        return lottoResultDtos;
    }
}
