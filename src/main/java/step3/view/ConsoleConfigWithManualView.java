package step3.view;

import step2.controller.LottoController;
import step2.dto.LottoSheetDto;
import step2.view.ConsoleConfigView;
import step3.domain.LottoConfigWithManual;
import step3.domain.ManualLottoInnerConfig;
import step3.util.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleConfigWithManualView extends ConsoleConfigView {
    public ConsoleConfigWithManualView(LottoController lottoController) {
        super(lottoController);
    }

    @Override
    public void print(Scanner sc) {
        LottoConfigWithManual lottoConfigWithManual = readConfig(sc);
        ManualLottoInnerConfig manualLottoInnerConfig = readManualLotto(sc);
        lottoConfigWithManual.setManualLottoInnerConfig(manualLottoInnerConfig);
        printNumberOfLotto(lottoConfigWithManual);
        LottoSheetDto lottoSheetDto = lottoController.purchase(lottoConfigWithManual);
        // 쿠키에 발행된 userId 저장
        setUserIdCookie(COOKIE_KEY_USER_ID, String.valueOf(lottoSheetDto.getId()));
        // 생성된 로또 번호 출력
        printLottoSheet(lottoSheetDto);
    }

    private LottoConfigWithManual readConfig(Scanner sc){
        System.out.println("구입금액을 입력해주세요.");
        final int purchaseAmount = Integer.parseInt(sc.nextLine());
        return new LottoConfigWithManual(purchaseAmount);
    }

    protected void printNumberOfLotto(LottoConfigWithManual lottoConfigWithManual) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.%n",lottoConfigWithManual.getNumberOfManual(), lottoConfigWithManual.getNumberOfAuto());
    }

    private ManualLottoInnerConfig readManualLotto(Scanner sc){
        System.out.println("수동으로 구매한 로또 수를 입력해 주세요.");
        final int numberOfManualLotto = Integer.parseInt(sc.nextLine());

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<List<Integer>> userInputLottoList = readInputLottoList(sc, numberOfManualLotto);

        return new ManualLottoInnerConfig(numberOfManualLotto, userInputLottoList);
    }

    private List<List<Integer>> readInputLottoList (Scanner sc, int numberOfManualLotto){
        List<List<Integer>> userInputLottoList = new ArrayList<>();
        for(int i = 0; i < numberOfManualLotto; i++){
            List<Integer> inputLotto = Arrays.stream(sc.nextLine().split(","))
                    .map(str -> Integer.parseInt(str.trim()))
                    .collect(Collectors.toList());
            Validator.SIX_NUMBER_LIST(inputLotto);
            userInputLottoList.add(inputLotto);
        }
        return userInputLottoList;
    }
}
