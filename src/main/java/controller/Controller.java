package controller;

import domain.Lotto;
import domain.LottoGenerator;
import domain.Prize;
import domain.WinningLotto;
import view.InputOutputManager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    private final InputOutputManager inputOutputManager;

    public Controller(InputOutputManager inputOutputManager){
        this.inputOutputManager = inputOutputManager;
    }

    public void run(){
        int money = inputOutputManager.getMoney();

        List<Lotto> lottoList = buyLottoWithMoney(money);
        inputOutputManager.printLottoList(lottoList);

        List<Integer> winningSequence = inputOutputManager.getWinningSequence();
        WinningLotto winningLotto = new WinningLotto(winningSequence);

        List<Prize> prizes = lottoList.stream()
                                .map(lotto -> lotto.getResult(winningLotto))
                                .collect(Collectors.toList());
        inputOutputManager.printResult(prizes, money);
    }

    private List<Lotto> buyLottoWithMoney(int money){
        List<Lotto> lottoList = new ArrayList<>();
        for (; money >= Lotto.cost; money -= Lotto.cost)
            lottoList.add(LottoGenerator.generate());
        return lottoList;
    }
}
