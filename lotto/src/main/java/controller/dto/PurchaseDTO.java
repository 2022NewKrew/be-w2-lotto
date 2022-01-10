package controller.dto;

import spark.Request;

public class PurchaseDTO {

  private int amount;
  private String lottoList;

  public PurchaseDTO(int amount, String lottoList) {
    this.amount = amount;
    this.lottoList = lottoList;
  }


  public PurchaseDTO(Request request) {
    this.amount = Integer.parseInt(request.queryParams("amount"));
    this.lottoList = request.queryParams("lottoList");
  }


  public int getAmount() {
    return amount;
  }


  public void setAmount(int amount) {
    this.amount = amount;
  }


  public String getLottoList() {
    return lottoList;
  }


  public void setLottoList(String lottoList) {
    this.lottoList = lottoList;
  }

}
