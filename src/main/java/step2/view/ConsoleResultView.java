package step2.view;

import step2.domain.PrizeType;
import step2.domain.WinningLotto;
import step2.controller.LottoController;
import step2.dto.LottoResultDto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleResultView implements ResultView{

    private final LottoController lottoController;

    public ConsoleResultView(LottoController lottoController) {
        this.lottoController = lottoController;
    }

    @Override
    public void print(Scanner sc) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        List<Integer> result = getResultList(sc.nextLine());

        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNum = Integer.parseInt(sc.nextLine());

        LottoResultDto lottoResultDto = lottoController.checkLottoeryResult(new WinningLotto(result), Long.parseLong(getCookie(COOKIE_KEY_USER_ID)));

        printLottoResult(lottoResultDto);

    }

    private List<Integer> getResultList(String resultInput){
        return Arrays.asList(resultInput.split(", ")).stream()
                .map(num -> Integer.parseInt(num.trim()))
                .collect(Collectors.toList());
    }

    public void printLottoResult(LottoResultDto lottoResultDto) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> userResult = lottoResultDto.getLottoPrizeToResultMap();
        PrizeType.PRIZE_MAP.keySet().stream()
                .forEach(prizeNum -> {
                    int result = userResult.get(prizeNum) == null ? 0 : userResult.get(prizeNum);
                    sb.append(String.format("%d개 일치 (%d원)- %d개\n", prizeNum, PrizeType.of(prizeNum).getWinningPrize(), result));
                });
        System.out.println(sb);
    }


}
