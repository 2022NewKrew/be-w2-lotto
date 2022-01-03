package com.yapark97.lottoapplication.service;

import com.yapark97.lottoapplication.domain.LottoSet;
import com.yapark97.lottoapplication.view.LottoInput;
import com.yapark97.lottoapplication.view.LottoOutput;
import com.yapark97.lottoapplication.view.SimpleLottoInput;
import com.yapark97.lottoapplication.view.SimpleLottoOutput;

import java.util.List;

public class LottoService {
    private final LottoInput lottoInput;
    private final LottoOutput lottoOutput;

    private LottoSet lottoSet;

    public LottoService() {
        // Standart input/output 사용한 view 클래스
        this.lottoInput = SimpleLottoInput.getInstance();
        this.lottoOutput = SimpleLottoOutput.getInstance();
    }

    public void run() {
        initLottoSet();
        showLottoSet();
        setWinnintLotto();
        showStatistic();
    }

    private void initLottoSet() {
        int lottoSetNum = lottoInput.takeLottoSetNumInput();

        lottoSet = new LottoSet(lottoSetNum);
    }

    private void showLottoSet() {
        lottoOutput.printLottoSetInfo(lottoSet);
    }

    private void setWinnintLotto() {
        List<Integer> winningNumbers = lottoInput.takeWinningNumbersInput();
        lottoSet.setWinningLotto(winningNumbers);
    }

    private void showStatistic() {
        lottoOutput.printStatistic(lottoSet.getStatistic());
    }
}
