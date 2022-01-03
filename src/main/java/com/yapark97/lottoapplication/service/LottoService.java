package com.yapark97.lottoapplication.service;

import com.yapark97.lottoapplication.domain.Lotto;
import com.yapark97.lottoapplication.domain.LottoConst;
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
        playLotto();
    }

    private void initLottoSet() {
        lottoSet = new LottoSet(lottoInput.takeLottoSetNumInput());
    }

    private void showLottoSet() {
        lottoOutput.printLottoSetInfo(lottoSet);
    }

    private void playLotto() {
        Lotto winningLotto = createWinnintLotto();
        lottoOutput.printStatistic(lottoSet.getStatistic(winningLotto));
    }

    private Lotto createWinnintLotto() {
        List<Integer> winningNumbers = lottoInput.takeWinningNumbersInput();
        return new Lotto(winningNumbers);
    }
}
