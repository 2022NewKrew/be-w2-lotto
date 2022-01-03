package service;

public interface LottoService {
    Long purchaseLotto(int quantity);

    String getPurchasedLottoBundleString(Long lottoBundleId);
}
