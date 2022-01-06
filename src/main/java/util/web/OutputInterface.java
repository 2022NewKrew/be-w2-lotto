package util.web;

import dto.response.CheckedLottoDTO;
import dto.response.PurchasedLottoDTO;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputInterface {
    public Map<String, Object> convertPurchasedDtoToModel(PurchasedLottoDTO purchasedLottoDTO) {
        Map<String, Object> model = new HashMap<>();

        final String lotto = purchasedLottoDTO.getLotto();

        final int numberOfLottoTickets = Arrays.stream(lotto.split("\n"))
                .collect(Collectors.toList())
                .size();
        model.put("lottosSize", numberOfLottoTickets);

        final List<Map<String, String>> lottoTickets = Arrays.stream(lotto.split("\n"))
                .map(ticket -> makeMapElement("lotto", ticket))
                .collect(Collectors.toList());
        model.put("lottos", lottoTickets);

        return model;
    }

    public Map<String, Object> convertCheckedDtoToModel(CheckedLottoDTO checkedLottoDTO) {
        Map<String, Object> model = new HashMap<>();
        Map<String, Object> lottosResult = new HashMap<>();

        final String lottoResult = checkedLottoDTO.getLottoResult();

        List<String> lottoMessage = Arrays.stream(lottoResult.split("\n"))
                .filter(result -> result.contains("개"))
                .collect(Collectors.toList());
        lottosResult.put("message", lottoMessage);

        String lottoRevenueRate = Arrays.stream(lottoResult.split("\n"))
                .filter(result -> !result.contains("개"))
                .collect(Collectors.toList())
                .toString();
        lottoRevenueRate = lottoRevenueRate.replaceAll("[^0-9.]", "").replaceAll("[.]$", "");
        lottosResult.put("totalRateOfReturn", lottoRevenueRate);

        model.put("lottosResult", lottosResult);

        return model;
    }

    private Map<String, String> makeMapElement(String key, String value) {
        final Map<String, String> map = new HashMap<>();
        map.put(key, value);
        return map;
    }
}
