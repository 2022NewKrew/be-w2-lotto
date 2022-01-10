package controller.dto;

import java.util.List;

public class LottoDTO {

  private List<Integer> lottoNumbers;

  public LottoDTO(List<Integer> lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  public List<Integer> getLottoNumbers() {
    return lottoNumbers;
  }

  public void setLottoNumbers(List<Integer> lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  @Override
  public String toString() {
    return lottoNumbers.toString();
  }

}
