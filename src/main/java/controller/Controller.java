package controller;

import dto.request.LottoCheckDTO;
import dto.request.LottoPurchaseDTO;
import dto.response.CheckedLottoDTO;
import dto.response.PurchasedLottoDTO;

public interface Controller {
    PurchasedLottoDTO purchase(LottoPurchaseDTO lottoPurchaseDTO);
    CheckedLottoDTO check(LottoCheckDTO lottoCheckDTO);
}
