package view;

import domain.LottoTicket;
import domain.Rank;
import org.apache.commons.lang3.StringUtils;
import spark.Request;

import java.util.*;
import java.util.stream.Collectors;

public class LottoWebView {

    public String inputString(Request request, String paramName) {
        return request.queryParams(paramName);
    }

    public int inputInt(Request request, String paramName) {
        return Integer.parseInt(inputString(request, paramName));
    }

    public List<String> inputMultipleLineIntegerList(Request request, String paramName) {
        return Arrays.asList(inputString(request, paramName).split("\n"));
    }

    public List<Integer> inputIntegerList(String line) {
        return Arrays.stream(line.split(","))
                .map(StringUtils::deleteWhitespace)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<String> printAllTicketsResult(Map<Rank, Integer> rankCount) {
        List<String> stringList = new ArrayList<>();
        int matchCount, prize, ticketCount;

        for (var entry : rankCount.entrySet()) {
            matchCount = entry.getKey().getCountOfMatch();
            prize = entry.getKey().getWinningMoney();
            ticketCount = entry.getValue();

            if (matchCount < 0) continue;
            stringList.add(String.format("%d개 일치 (%d원)- %d개\n", matchCount, prize, ticketCount));
        }

        return stringList;
    }
}