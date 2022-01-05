package carrot.ez.view;

import carrot.ez.controller.LottoController;
import carrot.ez.dto.LotteryStatisticsDto;
import carrot.ez.dto.WinningNumberDto;
import carrot.ez.lotto.Lotteries;
import carrot.ez.lotto.Lottery;
import carrot.ez.lotto.LotteryDiv;
import carrot.ez.lotto.Rank;
import carrot.ez.util.IOUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoView {

    private final static List<Rank> PRINT_RANKS = Arrays.asList(Rank.Fifth, Rank.Fourth, Rank.Third, Rank.Second, Rank.First);

    private final IOUtil io;
    private final LottoController lottoController;

    public LottoView(IOUtil io, LottoController lottoController) {
        this.io = io;
        this.lottoController = lottoController;
    }

    public void render() {
        long amount = inputAmount();
        Lotteries lotteries = purchaseLotteries(amount);
        printLotteries(lotteries);
        WinningNumberDto winningNumberDto = inputWiningNumber();
        LotteryStatisticsDto winingStatistics = getWiningStatistics(lotteries, winningNumberDto);
        printWiningStatistics(amount, winingStatistics);
    }

    private long inputAmount() {
        return io.inputLong("구입 금액을 입력해주세요.");
    }

    private Lotteries purchaseLotteries(long amount) {
        int manualQuantity = inputManualQuantity();
        List<Lottery> manualLotteries = inputManualLotteries(manualQuantity);
        return lottoController.purchaseLotteries(amount, manualLotteries);
    }

    private int inputManualQuantity() {
        return io.inputInt("수동으로 구매할 로또 수를 입력해주세요.");
    }

    private List<Lottery> inputManualLotteries(int manualQuantity) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lottery> manualLotteries = new ArrayList<>();
        for (int i = 0; i < manualQuantity; i++) {
            List<Integer> numbers = io.inputSplitInt("\\s*[,]\\s*");
            manualLotteries.add(new Lottery(numbers, LotteryDiv.MANUAL));
        }
        return manualLotteries;
    }

    private void printLotteries(Lotteries lotteries) {
        System.out.printf("수동으로 %d장, 자동으로 %d장을 구매했습니다.\n", lotteries.getManualSize(), lotteries.getAutoSize());
        lotteries.getLotteries().forEach(System.out::println);
        System.out.println();
    }

    private WinningNumberDto inputWiningNumber() {
        List<Integer> winingNumbers = io.inputSplitInt("지난 주 당첨 번호를 입력해 주세요.", "\\s*[,]\\s*");
        int bonus = io.inputInt("보너스 볼을 입력해주세요.");
        return new WinningNumberDto(winingNumbers, bonus);
    }

    private LotteryStatisticsDto getWiningStatistics(Lotteries lotteries, WinningNumberDto winingNumbers) {
        return lottoController.checkWiningNumbers(lotteries, winingNumbers);
    }

    private void printWiningStatistics(long amount, LotteryStatisticsDto lotteryStatisticsDto) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        printWinningLotteries(lotteryStatisticsDto);
        double rate = getRate(amount, lotteryStatisticsDto);
        System.out.printf("총 수익률은 %.0f%%입니다.\n", rate);
    }

    private void printWinningLotteries(LotteryStatisticsDto lotteryStatisticsDto) {
        PRINT_RANKS.forEach(rank -> {
            Long rankCount = lotteryStatisticsDto.getRankCount(rank);
            System.out.printf(rank.getStringFormat(), rank.getCorrectNum(), rank.getPrice(), rankCount);
        });
    }

    private double getRate(long amount, LotteryStatisticsDto lotteryStatisticsDto) {
        long sum = lotteryStatisticsDto.getSum();
        return ((double)sum - amount) / amount * 100;
    }

}
