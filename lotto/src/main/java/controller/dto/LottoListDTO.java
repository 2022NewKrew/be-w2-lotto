package controller.dto;

import java.util.List;

public class LottoListDTO {

  private List<LottoDTO> lottos;
  private int manualGenerateSize;
  private int randomGenerateSize;

  public LottoListDTO(List<LottoDTO> lottoList, int manualGenerateSize, int randomGenerateSize) {
    this.lottos = lottoList;
    this.manualGenerateSize = manualGenerateSize;
    this.randomGenerateSize = randomGenerateSize;
  }

  public List<LottoDTO> getLottos() {
    return lottos;
  }

  public void setLottos(List<LottoDTO> lottos) {
    this.lottos = lottos;
  }

  public int getManualGenerateSize() {
    return manualGenerateSize;
  }

  public void setManualGenerateSize(int manualGenerateSize) {
    this.manualGenerateSize = manualGenerateSize;
  }

  public int getRandomGenerateSize() {
    return randomGenerateSize;
  }

  public void setRandomGenerateSize(int randomGenerateSize) {
    this.randomGenerateSize = randomGenerateSize;
  }

}
