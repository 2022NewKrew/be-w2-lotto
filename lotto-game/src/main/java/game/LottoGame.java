package game;

import controller.IOController;
import lotto.Lotto;
import lotto.LottoResult;
import lotto.WinningLotto;

import java.lang.reflect.Array;
import java.util.*;

public class LottoGame {
    private int asset;
    private List<Lotto> lottos;
    private WinningLotto winningLotto;

    private LottoResult lottoResult;
    private long totalReward;

    public LottoGame(){
        asset = 0;
        lottos = new ArrayList<>();

        lottoResult = new LottoResult();
        totalReward = 0;
    }

    public void start(){
        asset = IOController.getNextInt("구매 금액을 입력해주세요.");
        getNewLottos(asset / 1000);
        getWinningNumbers();
        confirmWinning();

        int incomeRate = (int) ((lottoResult.calculateProceed() * 100) / asset);
        IOController.printResult(incomeRate, lottoResult);
    }
    
    private void getNewLottos(int lottoNumber) {
        int manualNum = IOController.getNextInt("수동으로 구매할 로또 수를 입력해 주세요.");
        int autoNum = lottoNumber - manualNum;
        IOController.printBuyLottoNum(manualNum, autoNum);

        getNewManualLottos(manualNum);
        getNewAutoLottos(autoNum);
    }

    private void getNewAutoLottos(int autoNum) {
        for(int lottoIndex = 0; lottoIndex < autoNum; lottoIndex++){
            Lotto lotto = new Lotto();
            IOController.printLotto(lotto);
            lottos.add(lotto);
        }
    }

    private void getNewManualLottos(int manualNum) {
        for(int lottoIndex = 0; lottoIndex < manualNum; lottoIndex++){
            String manualNumbers = IOController.getNextString("");
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
            lottoResult.addResult(winningLotto.confirmWinning(lotto));
        }
    }
}
