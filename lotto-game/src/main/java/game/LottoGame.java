package game;

import controller.IOController;
import lotto.Lotto;
import lotto.WinningLotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoGame {
    private int asset;
    private List<Lotto> lottos;
    private WinningLotto winningLotto;

    private int firstPlaceCount;
    private int secondPlaceCount;
    private int thirdPlaceCount;
    private int forthPlaceCount;
    private int fifthPlaceCount;
    private long totalReward;

    public LottoGame(){
        asset = 0;
        lottos = new ArrayList<>();

        firstPlaceCount = 0;
        secondPlaceCount = 0;
        thirdPlaceCount = 0;
        forthPlaceCount = 0;
        fifthPlaceCount = 0;

        totalReward = 0;
    }

    public void start(){
        asset = IOController.getNextInt("구매 금액을 입력해주세요.");
        getNewLottos(asset / 1000);
        getWinningNumbers();
        confirmWinning();
        totalReward = calculateReward();

        int incomeRate = (int) ((totalReward * 100) / asset);
        IOController.printResult(incomeRate, firstPlaceCount, secondPlaceCount, thirdPlaceCount, forthPlaceCount, fifthPlaceCount);
    }
    
    private void getNewLottos(int lottoNumber) {
        IOController.printBuyLottoNum(lottoNumber);
        for(int lottoIndex = 0; lottoIndex < lottoNumber; lottoIndex++){
            Lotto lotto = new Lotto();
            IOController.printLotto(lotto);
            lottos.add(lotto);
        }
    }

    private void getWinningNumbers() {
        String winningNumbers = IOController.getNextString("지난 주 당첨 번호를 입력해주세요.");
        int bonusNumber = IOController.getNextInt("보너스 볼을 입력 주세요.");

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
            case 5:
                fifthPlaceCount++;
                break;
            default:
                break;
        }
    }

    private int calculateReward() {
        return 2000000000*firstPlaceCount
                + 30000000 * secondPlaceCount
                + 1500000 * thirdPlaceCount
                + 50000 * forthPlaceCount
                + 5000 * fifthPlaceCount;
    }
}
