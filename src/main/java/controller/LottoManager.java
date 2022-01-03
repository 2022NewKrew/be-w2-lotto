package controller;

import model.Repository;
import model.datastructure.LottoMatchStateDTO;
import model.datastructure.LottoNumber;
import model.datastructure.LottoWinPrize;
import view.LottoUI;

public class LottoManager {
    private final Long userId;
    private final Repository repository;
    private final LottoUI lottoUI;
    private final int LOTTO_UNIT_PRICE = 1000;

    private int money;
    private int numOfLottos;
    private LottoNumber winNumbers;

    public LottoManager(Long userId, Repository repository, LottoUI lottoUI) {
        this.userId = userId;
        this.repository = repository;
        this.lottoUI = lottoUI;
    }

    public void run() throws Exception {
        // 구입 금액을 입력 받는다.
        askUserBudget();
        // 로또를 구매한다.
        buyLottos();
        // 로또 당첨 번호를 입력하여 로또를 생성한다.
        winNumbers = lottoUI.askUserWinNumber();
        // 로또 결과를 출력한다.
        result();
    }

    public void askUserBudget() {
        // 구입 금액을 입력 받는다.
        money = lottoUI.askUserBudget();

    }

    public void buyLottos() throws Exception {
        // 구입 로또 갯수를 정한다.
        numOfLottos = (money / LOTTO_UNIT_PRICE);
        System.out.printf("%d개를 구매했습니다.%n", numOfLottos);
        // 유저 아이디에 해당하는 repository를 준비한다.
        repository.init(userId);
        // 로또 번호를 생성하고 저장한다.
        for (int i = 0; i < numOfLottos; i++) {
            repository.save(userId, LottoNumber.randomLottoNumberFactory());
            lottoUI.printLine(repository.get(userId, i).toString());
        }
    }

    public void result() throws Exception {
        // LottoMatchStateDTO를 만든다.
        LottoMatchStateDTO lottoMatchStateDTO = new LottoMatchStateDTO();
        // DTO 상태를 만든다.
        lottoMatchStateDTO.setMoneyTotalCost(numOfLottos * LOTTO_UNIT_PRICE);
        int matchNumbers;
        for (int i = 0; i < repository.size(userId); i++) {
            // 저장된 로또 번호가 당첨 번호와 얼마나 일치하는지 확인하여 그 결과를 DTO에 반영한다.
            matchNumbers = repository.get(userId, i).matchNumbers(winNumbers);
            lottoMatchStateDTO.addMatch(matchNumbers);
            lottoMatchStateDTO.addMoneyTotalWin(LottoWinPrize.lottoWinPrize.get(matchNumbers));
        }

        // 출력한다.
        lottoUI.showResult(lottoMatchStateDTO);
    }
}
