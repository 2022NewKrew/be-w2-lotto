package service;

import domain.PurchasedLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PurchaseService {
    public PurchasedLotto purchaseRandomLotto() {
        return new PurchasedLotto();
    }

    public PurchasedLotto purchaseManualLotto(List<Integer> manualNumbers) {
        return new PurchasedLotto(manualNumbers);
    }
}
