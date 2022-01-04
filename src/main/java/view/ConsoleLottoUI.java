package view;

import dto.LottoMatchStateDTO;
import domain.lotto.LottoNumber;
import dto.LottoNumberContainerDTO;
import dto.LottoNumberDTO;
import dto.WinningLottoNumberDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleLottoUI implements LottoUI {
    private final Scanner scn = new Scanner(System.in);

    @Override
    public int askUserHowManyManualNumberLotto(int buyLimitNum) {
        int result = buyLimitNum + 1;
        while (result > buyLimitNum) {
            System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
            result = Integer.parseInt(scn.nextLine());
            System.out.println();
        }

        return result;
    }

    @Override
    public LottoNumberContainerDTO askUserManualLottoNumbers(int num) {
        // num개 만큼 수동 lotto 번호를 받고 이것을 DTO에 넣어 반환한다.
        LottoNumberContainerDTO lottoNumberContainerDTO = new LottoNumberContainerDTO();

        if (num>0) {
            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        }
        for(int i = 0; i< num; i++) {
            lottoNumberContainerDTO.addLottoNumber(new LottoNumberDTO(inputOneLottoNumberLine()));
        }
        System.out.println();

        return lottoNumberContainerDTO;
    }
    public ArrayList<Integer> inputOneLottoNumberLine(){
        return Arrays.stream(scn.nextLine().split(",")).map(Integer::parseInt).collect(ArrayList::new, List::add, List::addAll);
    }

    @Override
    public void showBoughtLottos(String message, LottoNumberContainerDTO lottoNumberContainerDTO) {
        // %d개를 구매했습니다. 
        System.out.println(message);
        // [  ,  ,  ,  ,  ,  ]
        for (LottoNumberDTO lottoNumberDTO : lottoNumberContainerDTO.getLottoNumbers()) {
            printLottoNumberLine(lottoNumberDTO.getArrayListInteger());
        }
        System.out.println();
    }

    private void printLottoNumberLine(ArrayList<Integer> numbers) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < numbers.size() - 1; i++) {
            sb.append(numbers.get(i));
            sb.append(", ");
        }
        sb.append(numbers.get(numbers.size() - 1));
        sb.append("]");
        System.out.println(sb);
    }

    @Override
    public WinningLottoNumberDTO askUserWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        ArrayList<Integer> basicNumbers = Arrays.stream(scn.nextLine().split(",")).map(Integer::parseInt).collect(ArrayList::new, List::add, List::addAll);
        System.out.println("보너스 볼을 입력해 주세요.");
        ArrayList<Integer> extraNumbers = Arrays.stream(scn.nextLine().split(",")).map(Integer::parseInt).collect(ArrayList::new, List::add, List::addAll);
        System.out.println();
        return new WinningLottoNumberDTO(basicNumbers, extraNumbers);
    }

    @Override public int askUserExtraBounusNumber() {
        return 0;
    }

    @Override
    public int askUserBudget() {
        System.out.println("구입금액을 입력해 주세요.");
        int result = Integer.parseInt(scn.nextLine());
        System.out.println();
        return result;
    }

    public LottoNumber askUserWinNumber() throws Exception {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        ArrayList<Integer> inputs = Arrays.stream(scn.nextLine().split(",")).map(Integer::parseInt).collect(ArrayList::new, List::add, List::addAll);
        return new LottoNumber(inputs);
    }

    @Override
    public void showResult(LottoMatchStateDTO lottoMatchStateDTO) {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n");
        sb.append("---------\n");
        for(int i = 1; i <= lottoMatchStateDTO.getNumOfWinRanks();i++){
            sb.append(lottoMatchStateDTO.getWinMessageByRank().get(i));
            sb.append(" (");
            sb.append(lottoMatchStateDTO.getWinPriceByRank().get(i));
            sb.append(")- ");
            sb.append(lottoMatchStateDTO.getNumStaticsByRank().get(i));
            sb.append("개\n");
        }

        if (lottoMatchStateDTO.getMoneyTotalCost() == 0) {
            sb.append("아무것도 사지 않아 수익률은 0%입니다.");
            System.out.println(sb);
            return;
        }
        sb.append(String.format("총 수익률은 %d%%입니다.", (int) (((float) lottoMatchStateDTO.getMoneyTotalWin() / lottoMatchStateDTO.getMoneyTotalCost()) * 100)));
        System.out.println(sb);
    }
}
