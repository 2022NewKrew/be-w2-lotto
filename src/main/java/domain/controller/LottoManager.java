package domain.controller;

import domain.lotto.WinningLottoNumber;
import domain.lotto.LottoNumber;
import domain.user.NormalUser;
import domain.user.User;
import dto.LottoNumberDTO;
import dto.LottoMatchStateDTO;
import model.Repository;
import view.LottoUI;

import java.util.Map;

public class LottoManager {
    private final Repository repository;
    private final LottoUI lottoUI;
    private final User user;
    private final ConfigManager configManager;

    private WinningLottoNumber winningLottoNumber;

    public LottoManager(Repository repository, LottoUI lottoUI, Long userId, Map<String, Object> config) throws Exception {
        this.repository = repository;
        this.lottoUI = lottoUI;
        this.user = new NormalUser(userId);
        this.configManager = new ConfigManager(config);
    }

    public void run() throws Exception {

        // 저장소를 초기화한다.
        initRepository();
        // 구입 금액을 입력 받는다.
        askUserBudget();
        // 로또를 구매한다.
        buyLottosAndShowLottos();
        // 로또 당첨 번호를 입력받고 winningLottoNumbers를 생성한다.
        winningLottoNumber = new WinningLottoNumber(lottoUI.askUserWinningNumbers());
        // 로또 결과를 출력한다.
        result();
    }


    private void initRepository() {
        // 유저 아이디에 해당하는 repository를 준비한다.
        repository.init(user.getUserId());

    }

    public void askUserBudget() {
        // 구입 금액을 입력 받는다.
        int money = lottoUI.askUserBudget();
        // 유저에게 반영한다.
        user.increaseOwnedMoney(money);
    }

    public void buyLottosAndShowLottos() throws Exception {
        // 구입 로또 갯수를 정한다.
        int totalNumOfLottos = (user.getOwnedMoney() / configManager.getLottoUnitPrice());
        int numOfManualNumberLottos = 0;
        user.increaseCostedMoney(totalNumOfLottos * configManager.getLottoUnitPrice());

        // 수동로또구매를 물어본다.
        if (configManager.isManualLottoNumberBuyAvailable()){
            numOfManualNumberLottos = lottoUI.askUserHowManyManualNumberLotto(totalNumOfLottos);
            // 수동 번호를 입력받아 유저에게 추가한다.
            user.addLottosByDTO(lottoUI.askUserManualLottoNumbers(numOfManualNumberLottos));
        }

        // 남아있는 로또 구매 숫자는 자동으로 구매한다.
        for(int i = 0; i< (totalNumOfLottos - numOfManualNumberLottos);i++){
            user.addOneLotto(LottoNumber.randomLottoNumberFactory(configManager.getBasicLottoNumbers(), configManager.getLottoNumberLowBoundary(), configManager.getLottoNumberHighBoundary()).getDTO());
        }

        String message = String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", numOfManualNumberLottos, totalNumOfLottos-numOfManualNumberLottos );
        lottoUI.showBoughtLottos(message, user.getOwnedLottoTicketsDTO());

        // 구매한 로또번호를 저장한다.
        repository.save(user.getUserId(), user.getOwnedLottoTicketsDTO());
    }


    public void result() throws Exception {
        // LottoMatchStateDTO를 만든다.
        LottoMatchStateDTO lottoMatchStateDTO = new LottoMatchStateDTO(configManager.getNumOfWinRanks());

        // DTO 상태를 만든다.
        lottoMatchStateDTO.setMoneyTotalCost(user.getCostedMoney());
        int rank;
        user.getOwnedLottoTicketsDTO();
        for (LottoNumberDTO lottoNumberDTO : user.getOwnedLottoTicketsDTO().getLottoNumbers()) {
            rank = winningLottoNumber.calculateRank(lottoNumberDTO);
            if (rank <=configManager.getNumOfWinRanks()){
                lottoMatchStateDTO.addMatch(rank);
                lottoMatchStateDTO.addMoneyTotalWin(configManager.getWinPriceByRank(rank));
            }
        }
        lottoMatchStateDTO.setWinPriceByRank(configManager.getWinPriceByRank());
        lottoMatchStateDTO.setWinMessageByRank(configManager.getWinMessageByRank());

        // 출력한다.
        lottoUI.showResult(lottoMatchStateDTO);
    }
}
