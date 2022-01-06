package game;

import controller.IOController;
import lotto.Lotto;
import lotto.LottoResult;
import lotto.WinningLotto;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

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
        try{
            getAsset();
            getNewLottos(asset / 1000);
            getWinningNumbers();
            confirmWinning();

            int incomeRate = (int) ((lottoResult.calculateProceed() * 100) / asset);
            IOController.printResult(incomeRate, lottoResult);
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("오류가 발생했습니다. 종료합니다.");
        }
    }

    private void getAsset() {
        asset = IOController.getNextInt("구매 금액을 입력해주세요.");
        if(asset % 1000 != 0) throw new RuntimeException("1000단위로 입력해주세요.");
    }

    private void getNewLottos(int lottoNumber) {
        int manualNum = IOController.getNextInt("수동으로 구매할 로또 수를 입력해 주세요.");
        int autoNum = lottoNumber - manualNum;

        if(autoNum < 0) throw new RuntimeException();
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

            List<Integer> lottoNumbers = getLottoNumberList(manualNumbers);

            Lotto lotto = new Lotto(lottoNumbers);
            IOController.printLotto(lotto);
            lottos.add(lotto);
        }
    }

    private List<Integer> getLottoNumberList(String manualNumbers) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for(String number : manualNumbers.split(", ")){
            lottoNumbers.add(Integer.parseInt(number));
        }
        Collections.sort(lottoNumbers);

        if(lottoNumbers.size() > 6) throw new RuntimeException("너무 많은 숫자를 입력했습니다.");
        if(lottoNumbers.size() < 6) throw new RuntimeException("너무 적은 숫자를 입력했습니다.");
        if(lottoNumbers.get(0) < 1 || lottoNumbers.get(5) > 45) throw new RuntimeException("잘못된 숫자를 입력했습니다.");
        if(lottoNumbers.size() != lottoNumbers.stream().distinct().count()) throw new RuntimeException("숫자가 중복되었습니다.");
        return lottoNumbers;
    }

    private void getWinningNumbers() {
        String winningNumbers = IOController.getNextString("지난 주 당첨 번호를 입력해주세요.");
        int bonusNumber = IOController.getNextInt("보너스 볼을 입력 주세요.");

        List<Integer> lottoNumbers = getLottoNumberList(winningNumbers);

        winningLotto = new WinningLotto(lottoNumbers, bonusNumber);
    }

    private void confirmWinning() {
        for(Lotto lotto : lottos){
            lottoResult.addResult(winningLotto.confirmWinning(lotto));
        }
    }
}
