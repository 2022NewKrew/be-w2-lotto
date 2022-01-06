package carrot.ez.mapper;

import carrot.ez.dto.response.LottoDto;
import carrot.ez.dto.response.LottosDto;
import carrot.ez.entity.LottoEntity;
import carrot.ez.entity.LottosEntity;

import java.util.List;
import java.util.stream.Collectors;

public class LottosMapper {

    public LottosDto toLottosDto(LottosEntity entity) {
        return new LottosDto(entity.getId(), toLottoDtoList(entity.getLottos()));
    }

    private List<LottoDto> toLottoDtoList(List<LottoEntity> lottos) {
        return lottos.stream()
                .map(lotto -> new LottoDto(lotto.getNumbers()))
                .collect(Collectors.toList());
    }
}
