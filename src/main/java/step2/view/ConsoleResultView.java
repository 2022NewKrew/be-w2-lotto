package step2.view;

import step2.domain.PrizeType;
import step2.domain.WinningLotto;
import step2.controller.LottoController;
import step2.dto.LottoResultDto;

import java.util.*;
import java.util.stream.Collectors;

public class ConsoleResultView implements ResultView{

    private final LottoController lottoController;

    public ConsoleResultView(LottoController lottoController) {
        this.lottoController = lottoController;
    }

    // 당첨 관련 뷰 출력
    @Override
    public void print(Scanner sc) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> result = getResultList(sc.nextLine());

        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNum = Integer.parseInt(sc.nextLine());

        // WinningLotto(당첨 번호 로또, 보너스 번호)와 뷰 Cookie에 저장된 userId로 결과 요청
        LottoResultDto lottoResultDto = lottoController.checkLotteryResult(new WinningLotto(result, bonusNum), Long.parseLong(getCookie(COOKIE_KEY_USER_ID)));
        // 당첨 결과 출력
        printLottoResult(lottoResultDto);
    }

    private List<Integer> getResultList(String resultInput){
        return Arrays.asList(resultInput.split(", ")).stream()
                .map(num -> Integer.parseInt(num.trim()))
                .collect(Collectors.toList());
    }

    // PrizeType(THREE(3, 5000, "3개 일치"),) enum을 통해 출력
    public void printLottoResult(LottoResultDto lottoResultDto) {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> prizeToCountMap = lottoResultDto.getLottoPrizeToResultMap();
        Arrays.asList(PrizeType.values())
                .forEach(prizeType -> sb.append(String.format("%s (%d원)- %d개\n", prizeType.getPrintingString(), prizeType.getWinningPrize(), prizeToCountMap.get(prizeType.name()) == null ? 0 : prizeToCountMap.get(prizeType.name()))));
        System.out.println(sb);
    }


}
