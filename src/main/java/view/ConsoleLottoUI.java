package view;

import model.datastructure.LottoMatchStateDTO;
import model.datastructure.LottoNumber;
import model.datastructure.LottoWinPrize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleLottoUI implements LottoUI {
    private final Scanner scn = new Scanner(System.in);

    @Override
    public int askUserBudget() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scn.nextLine());
    }

    @Override
    public LottoNumber askUserWinNumber() throws Exception {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        ArrayList<Integer> inputs = Arrays.stream(scn.nextLine().split(",")).map(Integer::parseInt).collect(ArrayList::new, List::add, List::addAll);
        return new LottoNumber(inputs);
    }

    @Override
    public void printLine(String str) {
        System.out.println(str);
    }

    @Override
    public void showResult(LottoMatchStateDTO lottoMatchStateDTO) {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n");
        sb.append("---------\n");
        for (int i = 3; i <= LottoNumber.NUM_OF_NUMBERS; i++) {
            sb.append(String.format("%d개 일치 (%d원)- %d개\n", i, LottoWinPrize.lottoWinPrize.get(i), lottoMatchStateDTO.get(i)));
        }
        if (lottoMatchStateDTO.getMoneyTotalCost() == 0) {
            sb.append("아무것도 사지 않아 수익률은 0%입니다.");
            System.out.println(sb);
            return;
        }
        sb.append(String.format("총 수익률은 %d%%입니다.", (int)(((float)lottoMatchStateDTO.getMoneyTotalWin() / lottoMatchStateDTO.getMoneyTotalCost()) * 100)));
        System.out.println(sb);
    }
}
