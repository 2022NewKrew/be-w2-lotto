package game;

import lotto.Lotto;
import lotto.WinningLotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoGame {
    private static final Scanner scanner = new Scanner(System.in);

    private int asset;
    private List<Lotto> lottos;
    private WinningLotto winningLotto;

    private int firstPlaceCount;
    private int secondPlaceCount;
    private int thirdPlaceCount;
    private int forthPlaceCount;

    private int totalReward;

    public LottoGame(){
        asset = 0;
        lottos = new ArrayList<>();

        firstPlaceCount = 0;
        secondPlaceCount = 0;
        thirdPlaceCount = 0;
        forthPlaceCount = 0;

        totalReward = 0;
    }

    public void start(){
        asset = getInput();
        getNewLottos(asset / 1000);
        getWinningNumbers();
        confirmWinning();
        totalReward = calculateReward();
        
        printResult();
    }

    private void printResult() {
        int incomeRate = (totalReward * 100 / asset);
        System.out.println("당첨 통계");
        System.out.println("--------------");
        System.out.printf("3개 일치 (5000원)- %d개\n",forthPlaceCount);
        System.out.printf("4개 일치 (50000원)- %d개\n",thirdPlaceCount);
        System.out.printf("5개 일치 (1500000원)- %d개\n",secondPlaceCount);
        System.out.printf("6개 일치 (2000000000원)- %d개\n",firstPlaceCount);
        System.out.println("총 수익률은 " + incomeRate + "%입니다.");
    }

    private int getInput() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    private void getNewLottos(int lottoNumber) {
        System.out.println(lottoNumber + "개를 구매했습니다.");
        for(int lottoIndex = 0; lottoIndex < lottoNumber; lottoIndex++){
            Lotto lotto = new Lotto();
            lotto.print();
            lottos.add(lotto);
        }
    }

    private void getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        scanner.nextLine();
        String winningNumbers = scanner.nextLine();
        int bonusNumber = scanner.nextInt();

        winningLotto = new WinningLotto(winningNumbers, bonusNumber);
    }

    private void confirmWinning() {
        for(Lotto lotto : lottos){
            int place = winningLotto.confirmWinning(lotto);
            calculatePlace(place);
        }
    }

    private void calculatePlace(int place) {
        switch (place){
            case 1:
                firstPlaceCount++;
                break;
            case 2:
                secondPlaceCount++;
                break;
            case 3:
                thirdPlaceCount++;
                break;
            case 4:
                forthPlaceCount++;
                break;
            default:
                break;
        }
    }

    private int calculateReward() {
        return 2000000000*firstPlaceCount + 1500000 * secondPlaceCount + 50000 * thirdPlaceCount + 5000 * forthPlaceCount;
    }
}
