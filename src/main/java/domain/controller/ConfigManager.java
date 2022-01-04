package domain.controller;

import java.util.HashMap;
import java.util.Map;

public class ConfigManager {

    private final int numOfLottoNumbers;
    private final int basicLottoNumbers;
    private final int extraBonusLottoNumbers;
    private final int lottoNumberLowBoundary;
    private final int lottoNumberHighBoundary;
    private final boolean isManualLottoNumberBuyAvailable;
    private final int lottoUnitPrice;
    private final int numOfWinRanks;
    private final HashMap<Integer, Integer> winPriceByRank;
    private final HashMap<Integer, String> winMessageByRank;



    public ConfigManager(Map<String, Object> config) throws Exception {

        try {
            Map<String, Object> lottoConfig = (Map<String, Object>) config.get("lottoConfig");

            Map<String, Integer> numOfLottoNumbers = (Map<String, Integer>) lottoConfig.get("numOfLottoNumbers");
            this.basicLottoNumbers = numOfLottoNumbers.get("basicLottoNumbers");
            this.extraBonusLottoNumbers = numOfLottoNumbers.get("extraBonusLottoNumbers");
            this.numOfLottoNumbers = this.basicLottoNumbers + this.extraBonusLottoNumbers;
            this.lottoNumberLowBoundary = (int) lottoConfig.get("lottoNumberLowBoundary");
            this.lottoNumberHighBoundary = (int) lottoConfig.get("lottoNumberHighBoundary");
            this.isManualLottoNumberBuyAvailable = (boolean) lottoConfig.get("isManualLottoNumberBuyAvailable");

            Map<String, Object> lottoMarket = (Map<String, Object>) config.get("lottoMarket");
            this.lottoUnitPrice = (int) lottoMarket.get("lottoUnitPrice");

            this.winPriceByRank = (HashMap<Integer, Integer>) lottoMarket.get("winPriceByRank");
            this.winMessageByRank = (HashMap<Integer, String>) lottoMarket.get("winMessageByRank");
            this.numOfWinRanks = winPriceByRank.size();

        } catch (Exception e) {
            throw new Exception("설정 파일에 오류가 있습니다.");
        }
    }

    public int getNumOfLottoNumbers() {
        return numOfLottoNumbers;
    }

    public int getBasicLottoNumbers() {
        return basicLottoNumbers;
    }

    public int getExtraBonusLottoNumbers() {
        return extraBonusLottoNumbers;
    }

    public int getLottoNumberLowBoundary() {
        return lottoNumberLowBoundary;
    }

    public int getLottoNumberHighBoundary() {
        return lottoNumberHighBoundary;
    }

    public int getLottoUnitPrice() {
        return lottoUnitPrice;
    }

    public boolean isManualLottoNumberBuyAvailable() {
        return isManualLottoNumberBuyAvailable;
    }

    public int getNumOfWinRanks() {
        return numOfWinRanks;
    }

    public HashMap<Integer, Integer> getWinPriceByRank() {
        return winPriceByRank;
    }

    public HashMap<Integer, String> getWinMessageByRank() {
        return winMessageByRank;
    }

    public int getWinPriceByRank(int rank) {
        if (rank > numOfWinRanks) {
            return 0;
        }
        return winPriceByRank.get(rank);
    }

    public String getWinMessageByRank(int rank) {
        if (rank > numOfWinRanks) {
            return "";
        }
        return winMessageByRank.get(rank);
    }
}
