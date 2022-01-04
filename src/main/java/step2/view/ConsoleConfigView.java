package step2.view;

import step2.domain.LottoConfig;
import step2.domain.service.LottoSheetIssuer;
import step2.controller.LottoController;
import step2.dto.LottoSheetDto;

import java.util.Scanner;

public class ConsoleConfigView implements ConfigView {

    private final LottoController lottoController;

    public ConsoleConfigView(LottoController lottoController) {
        this.lottoController = lottoController;
    }

    @Override
    public void print(Scanner sc) {
        LottoConfig lottoConfig = readConfig(sc);
        LottoSheetDto lottoSheetDto = lottoController.purchase(lottoConfig);
        setUserIdCookie(COOKIE_KEY_USER_ID, String.valueOf(lottoSheetDto.getId()));
        printLottoSheet(lottoSheetDto);
    }

    private LottoConfig readConfig(Scanner sc){
        System.out.println("구입금액을 입력해주세요.");
        final int purchaseAmount = Integer.parseInt(sc.nextLine());
        final int numberOfLotto = purchaseAmount / LottoSheetIssuer.PRICE;
        System.out.println(numberOfLotto + "개를 구매했습니다.");
        return new LottoConfig(purchaseAmount);
    }

    private void printLottoSheet(LottoSheetDto lottoSheetDto){
        StringBuilder sb = new StringBuilder();
        lottoSheetDto.getLottoDtoList().forEach(lottoDto ->
        {
            sb.append(lottoDto.getNumbers());
            sb.append('\n');
        });
        System.out.println(sb);
    }
}
