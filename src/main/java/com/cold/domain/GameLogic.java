package com.cold.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;

@Getter
public class GameLogic {
  private String INVALID_LAST_WINNING_NUMS_RANGE = "지난 주 당첨 번호 범위 오류";
  private String INVALID_LAST_WINNING_NUMS_COUNT = "지난 주 당첨 번호 갯수 오류";

  List<Integer> lastWinningNums;
  Map<Integer, Integer> result;

  public void parseLastWinningNums(String lastWinningNumsString) throws Exception{
    lastWinningNums = new ArrayList<>();

    for(String num : lastWinningNumsString.split(",")){
      num.trim();
      lastWinningNums.add(Integer.parseInt(num));
    }
    validateLastWinningNums();
  }

  public void calculateResult(WholeTickets wholeTickets){
    initResult();
    for(SingleTicket ticket : wholeTickets.getTickets()){
      checkEachTicket(ticket);
    }
  }

  private void initResult(){
    result = new HashMap<>(){
      {
        put(3,0);
        put(4,0);
        put(5,0);
        put(6,0);
      }
    };
  }

  private void checkEachTicket(SingleTicket ticket){
    int cnt = 0;
    for(Integer num : ticket.getNumbers()){
      cnt += checkEachNum(num);
    }
    insertIntoResult(cnt);
  }

  private void insertIntoResult(int cnt){
    if(cnt>2 && cnt<7){
      result.put(cnt,result.get(cnt)+1);
    }
  }

  private int checkEachNum(Integer num){
    return lastWinningNums.contains(num) ? 1 : 0;
  }

  private void validateLastWinningNums() throws Exception {
    validateCount();
    for(Integer num : lastWinningNums){
      validateRange(num);
    }
  }

  private void validateRange(Integer num) throws Exception{
    if(num <1 || num >45){
      throw new Exception(INVALID_LAST_WINNING_NUMS_RANGE);
    }
  }

  public void validateCount() throws Exception{
    if(lastWinningNums.size() != 6){
      throw new Exception(INVALID_LAST_WINNING_NUMS_COUNT);
    }
  }
}

