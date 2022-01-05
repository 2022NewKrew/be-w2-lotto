package front;

import Constant.Constant;
import back.controller.Controller;
import back.domain.Prize;
import dto.LottoCreateDto;
import dto.LottoDto;
import dto.WinningLottoCreateDto;

import java.util.List;
import java.util.stream.Collectors;

public class View {
    private final InputOutputManager inputOutputManager;
    private final Controller controller;

    public View(Controller controller) {
        this.controller = controller;
        this.inputOutputManager = new InputOutputManager();
    }

    public void main() {
        int budget = inputOutputManager.getBudget();
        inputLottoInfo(budget);
        printLottoInfo();
        inputWinningLottoInfo();
        printResult(budget);
    }

    private void inputLottoInfo(int budget) {
        int manualAmount = inputOutputManager.getManualCount(budget);
        int expenditure = manualAmount * Constant.LOTTO_COST;

        List<LottoCreateDto> lottoList = inputOutputManager.getManualLottoSequenceList(manualAmount)
                .stream()
                .map(lottoSequence -> new LottoCreateDto(lottoSequence, false))
                .collect(Collectors.toList());

        for (int money = budget - expenditure; money >= Constant.LOTTO_COST; money -= Constant.LOTTO_COST)
            lottoList.add(new LottoCreateDto(LottoSequenceGenerator.generate(), true));

        lottoList.forEach(controller::createLotto);
    }

    private void printLottoInfo() {
        List<LottoDto> lottoList = controller.getLottoList();
        inputOutputManager.printLottoList(lottoList);
    }

    private void inputWinningLottoInfo() {
        // WinningLotto 생성
        List<Integer> winningSequence = inputOutputManager.getWinningSequence();
        int bonusNumber = inputOutputManager.getBonusNumber(winningSequence);

        WinningLottoCreateDto winningLotto = new WinningLottoCreateDto(winningSequence, bonusNumber);
        controller.createWinningLotto(winningLotto);
    }

    private void printResult(int budget) {
        List<Prize> prizes = controller.getResults();
        inputOutputManager.printResult(prizes, budget);
    }
}
