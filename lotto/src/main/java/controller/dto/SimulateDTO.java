package controller.dto;

import spark.Request;

public class SimulateDTO {

  private String winningLotto;
  private int bonusNumber;
  private String wallet;

  public SimulateDTO(Request request) {
    this.winningLotto = request.queryParams("winningLotto");
    this.bonusNumber = Integer.parseInt(request.queryParams("bonus"));
    this.wallet = request.queryParams("wallet");
  }

  public String getWinningLotto() {
    return winningLotto;
  }

  public void setWinningLotto(String winningLotto) {
    this.winningLotto = winningLotto;
  }

  public int getBonusNumber() {
    return bonusNumber;
  }

  public void setBonusNumber(int bonusNumber) {
    this.bonusNumber = bonusNumber;
  }

  public String getWallet() {
    return wallet;
  }

  public void setWallet(String wallet) {
    this.wallet = wallet;
  }

}
