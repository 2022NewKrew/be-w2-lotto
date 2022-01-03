package com.cold.domain;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class WholeTickets{
  List<SingleTicket> tickets;

  public void purchaseTickets(int purchasedCount){
    tickets = new ArrayList<>(purchasedCount);
    for(int i=0;i<purchasedCount;i++){
      tickets.add(new SingleTicket());
    }
  }
}
