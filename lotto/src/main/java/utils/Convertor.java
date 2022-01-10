package utils;

import controller.dto.LottoDTO;
import controller.dto.LottoListDTO;
import domain.lottery.WinningLotto;
import domain.lotto.Lotto;
import domain.lotto.LottoList;
import domain.lotto.LottoNumber;
import java.util.List;
import java.util.stream.Collectors;

public final class Convertor {

  private Convertor() {
  }

  public static LottoList dtoToDomain(String lottoListString) {
    List<List<Integer>> lottoList = StringUtils.doubleParseToByDelimiter(
        lottoListString, "\n", ",");

    return LottoList.of(lottoList.stream()
        .map(
            lottoNumbers -> Lotto.of(lottoNumbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toList())))
        .collect(Collectors.toList())
    );
  }


  public static LottoListDTO domainToDto(LottoList lottoList) {
    int manualGenerateSize = lottoList.manualGeneratedSize();
    int randomGenerateSize = lottoList.randomGeneratedSize();

    return new LottoListDTO(lottoList.stream()
        .map(Convertor::domainToDto)
        .collect(Collectors.toList()),
        manualGenerateSize, randomGenerateSize);
  }


  public static LottoDTO domainToDto(Lotto lotto) {
    return new LottoDTO(lotto.stream()
        .map(LottoNumber::toInteger)
        .collect(Collectors.toList()));
  }


  public static WinningLotto dtoToDomain(String lotto, int bonusNumber) {
    List<LottoNumber> winningLotto = StringUtils.integersSplitByDelimiter(
            lotto)
        .stream()
        .map(LottoNumber::of)
        .collect(Collectors.toList());

    return WinningLotto.of(winningLotto, LottoNumber.of(bonusNumber));
  }

}
