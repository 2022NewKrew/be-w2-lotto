package com.cold.view;

import com.cold.domain.GameLogic;
import com.cold.domain.SingleTicket;
import com.cold.domain.WholeTickets;
import java.util.Map;

public class OutputView {
  private String PURCHASE_NOTICE = "개를 구매했습니다.\n";
  private String RESULT_STATISTICS = "%d개 일치 (%d원)- %d개\n";
  private String RESULT_BANNER = "당첨통계\n";
  private String HORIZONTAL_LINE = "---------\n";

  private String INVALID_BUILD_EACH_CASE = "당첨 결과 문자열 생성 오류\n";

  public void printPurchaseResult(WholeTickets wholeTickets, int purchasedCount){
    StringBuilder outputString = new StringBuilder();
    outputString.append(purchasedCount + PURCHASE_NOTICE);
    for(SingleTicket ticket : wholeTickets.getTickets()){
      outputString.append(ticket.getNumbers() + "\n");
    }
    System.out.println(outputString);
  }

  public void printGameResult(Map<Integer,Integer> result) throws Exception{
    StringBuilder outputString = new StringBuilder();
    outputString = addBannerString(outputString);
    outputString = checkEachTicket(result, outputString);

    System.out.println(outputString);
  }
  private StringBuilder addBannerString(StringBuilder outputString){
    outputString.append(RESULT_BANNER);
    outputString.append(HORIZONTAL_LINE);
    return outputString;
  }

  private StringBuilder checkEachTicket(Map<Integer, Integer> result,
      StringBuilder outputString) throws Exception{
    for(Integer key : result.keySet()){
      outputString.append(addEachCase(key, result.get(key)));
    }
    return outputString;
  }

  private String addEachCase(Integer match, Integer value) throws Exception{
    switch(match){
      case 3:
        return String.format(RESULT_STATISTICS, 3,5000, value);
      case 4:
        return String.format(RESULT_STATISTICS, 4,50000, value);
      case 5:
        return String.format(RESULT_STATISTICS, 5,1500000, value);
      case 6:
        return String.format(RESULT_STATISTICS, 6,2000000000, value);
      default:
        throw new Exception(INVALID_BUILD_EACH_CASE);
    }
  }
}
