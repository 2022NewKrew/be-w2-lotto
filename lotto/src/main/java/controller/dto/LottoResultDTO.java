package controller.dto;

import java.util.List;

public class LottoResultDTO {

  private List<MessageDTO> lottosResult;
  private int totalRateOfReturn;

  public LottoResultDTO(List<MessageDTO> lottosResult, int totalRateOfReturn) {
    this.lottosResult = lottosResult;
    this.totalRateOfReturn = totalRateOfReturn;
  }

  public List<MessageDTO> getLottosResult() {
    return lottosResult;
  }

  public void setLottosResult(List<MessageDTO> lottosResult) {
    this.lottosResult = lottosResult;
  }

  public int getTotalRateOfReturn() {
    return totalRateOfReturn;
  }

  public void setTotalRateOfReturn(int totalRateOfReturn) {
    this.totalRateOfReturn = totalRateOfReturn;
  }
}
