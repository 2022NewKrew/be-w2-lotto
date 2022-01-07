package service;

import domain.Lotto;
import domain.PurchasedLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PurchaseLottoService {
    public Lotto purchaseManualLotto(String manualLottoString) {
        List<String> lottoNumbersStringList = Arrays.asList(manualLottoString.split(","));
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String lottoNumbersString : lottoNumbersStringList) {
            lottoNumbers.add(Integer.parseInt(lottoNumbersString));
        }
        return new PurchasedLotto(lottoNumbers);
    }

    public Lotto purchaseRandomLotto() {
        List<Integer> lottoNumbers = RandomSixNumbersService.getRandomSixNumbers();
        return new PurchasedLotto(lottoNumbers);
    }
}


