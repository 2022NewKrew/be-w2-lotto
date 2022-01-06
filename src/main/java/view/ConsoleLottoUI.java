package view;

import domain.match.LottoRank;
import domain.match.LottoMatchStateDTO;
import domain.lotto.LottoNumber;
import domain.lotto.LottoNumberContainerDTO;
import domain.lotto.LottoNumberDTO;
import domain.match.WinningLottoNumberDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleLottoUI implements LottoUI {
    private final Scanner scn = new Scanner(System.in);

    @Override
    public int askUserBudget() {
        int result = -1;
        while (result < 0) {
            System.out.println("구입금액을 입력해 주세요.");
            result = safeParseInt(scn.nextLine());
            System.out.println();
        }
        return result;
    }

    private int safeParseInt(String str) {
        int result;
        try {
            result = Integer.parseInt(str);
            validatePositiveIntegerNumberRange(result, 0);
        } catch (NumberFormatException e) {
            System.out.println("0이상의 정수를 입력해 주세요.");
            return -1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
        return result;
    }


    @Override
    public int askUserHowManyManualNumberLotto(int buyLimitNum) {
        if (buyLimitNum==0){
            return 0;
        }
        int result = buyLimitNum + 1;
        while (result > buyLimitNum || result < 0) {
            System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
            result = safeParseLottoNum(scn.nextLine(), buyLimitNum);
            System.out.println();
        }
        return result;
    }

    public int safeParseLottoNum(String str, int buyLimitNum) {
        int result;
        try {
            result = Integer.parseInt(str);
            validatePositiveIntegerNumberRange(result, buyLimitNum);
        } catch (NumberFormatException e) {
            System.out.println("0이상의 정수를 입력해 주세요.");
            return -1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
        return result;
    }

    private void validatePositiveIntegerNumberRange(int i, int high) throws Exception {
        if (i < 0) {
            throw new Exception(String.format("0 이상의 수가 입력되어야 하나 %d가 입력되었습니다.", i));
        }
        if (high == 0) {
            return;
        }
        if (i > high) {
            throw new Exception(String.format("%d 이하의 수가 입력되어야 하나 %d가 입력되었습니다.", high, i));
        }
    }

    @Override
    public LottoNumberContainerDTO askUserManualLottoNumbers(int num) {
        LottoNumberContainerDTO lottoNumberContainerDTO = new LottoNumberContainerDTO();
        if (num <= 0) {
            return lottoNumberContainerDTO;
        }

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < num; i++) {
            lottoNumberContainerDTO.addLottoNumber(new LottoNumberDTO(inputOneLottoNumberLine()));
        }
        System.out.println();

        return lottoNumberContainerDTO;
    }

    public ArrayList<Integer> inputOneLottoNumberLine() {
        while (true) {
            try {
                ArrayList<Integer> lottoNumbers = Arrays.stream(scn.nextLine().split(",")).map(value -> Integer.valueOf(value.trim())).collect(ArrayList::new, List::add, List::addAll);
                validateLottoNumber(lottoNumbers);
                return lottoNumbers;
            } catch (Exception e) {
                System.out.println("1~45 범위 내의 6개 정수를 입력해 주세요.");
            }
        }

    }

    private void validateLottoNumber(ArrayList<Integer> lottoNumbers) throws Exception {
        if (lottoNumbers.stream().distinct().count() != 6) {
            throw new Exception();
        }
        if (lottoNumbers.stream().anyMatch(value -> (value < 1 || value > 46))) {
            throw new Exception();
        }
    }

    @Override
    public void showBoughtLottos(int manualLottosNum, int randomLottosNum, LottoNumberContainerDTO lottoNumberContainerDTO) {
        String message = String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", manualLottosNum, randomLottosNum);
        System.out.println(message);
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
        ArrayList<Integer> basicNumbers = inputOneLottoNumberLine();
        System.out.println("보너스 볼을 입력해 주세요.");
        ArrayList<Integer> extraNumbers = inputExtraLottoNumber(basicNumbers);
        System.out.println();
        return new WinningLottoNumberDTO(basicNumbers, extraNumbers);
    }

    private ArrayList<Integer> inputExtraLottoNumber(ArrayList<Integer> basicNumbers) {
        while (true) {
            try {
                ArrayList<Integer> bonusNumber = Arrays.stream(scn.nextLine().split(",")).map(Integer::parseInt).collect(ArrayList::new, List::add, List::addAll);
                validateBonusNumbers(bonusNumber, basicNumbers);
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateBonusNumbers(ArrayList<Integer> bonusNumbers, ArrayList<Integer> otherNumbers) throws Exception {
        if (bonusNumbers.size() !=1) {
            throw new Exception("숫자를 하나만 입력해주세요.");
        }
        if (bonusNumbers.stream().anyMatch(otherNumbers::contains)) {

            throw new Exception("기본 당첨 번호와 다른 번호를 입력해 주세요.");
        }
        if (bonusNumbers.stream().anyMatch(value -> (value < 1 || value > 45))) {
            throw new Exception("1~45 범위 내의 숫자를 입력해 주세요.");
        }



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
        for (int i = 1; i <= lottoMatchStateDTO.getNumOfWinRanks(); i++) {
            sb.append(LottoRank.values()[i].getMessage());
            sb.append(" (");
            sb.append(LottoRank.values()[i].getPrize());
            sb.append(")- ");
            sb.append(lottoMatchStateDTO.getNumStaticsByRank().get(LottoRank.values()[i]));
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
