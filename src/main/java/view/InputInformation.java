package view;

import domain.LottoParameter;
import dto.PurchasedLottoDTO;
import dto.WinnigStatisticDTO;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class InputInformation {
    private Scanner scanner;
    private PurchasedLottoDTO purchasedLottoDTO;
    private WinnigStatisticDTO winnigStatisticDTO;

    public InputInformation() {
        scanner = new Scanner(System.in);
    }

    public PurchasedLottoDTO inputPurchaseAmount() {
        purchasedLottoDTO = new PurchasedLottoDTO();
        System.out.println("구매금액을 입력해 주세요.");
        purchasedLottoDTO.setPurchaseAmount(Integer.parseInt(scanner.nextLine()));
        purchasedLottoDTO.setLottoCount(purchasedLottoDTO.getPurchaseAmount() / LottoParameter.priceForOneLotto);
        return purchasedLottoDTO;
    }

    public WinnigStatisticDTO inputPrevWinningNumbers() {
        winnigStatisticDTO = new WinnigStatisticDTO();
        List<Integer> prevWinningNumbers = new ArrayList<>();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        for(String prevWinningString: scanner.nextLine().split(", ")) {
            prevWinningNumbers.add(Integer.parseInt(prevWinningString));
        }
        winnigStatisticDTO.setPrevWinningNumbers(prevWinningNumbers);
        return winnigStatisticDTO;
    }

}
