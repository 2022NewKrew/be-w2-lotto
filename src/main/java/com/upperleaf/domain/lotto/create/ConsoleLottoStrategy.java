package com.upperleaf.domain.lotto.create;

import com.upperleaf.domain.lotto.Lotto;

import java.util.Scanner;

public class ConsoleLottoStrategy implements LottoCreateStrategy {

    private final LottoCreateStrategy randomStrategy = new RandomLottoStrategy();
    private final LottoCreateStrategy manualStrategy = new LottoCreateStrategyRetry(new ConsoleManualLottoStrategy());

    private int manualNum = 0;
    private int manualCount = 0;
    private boolean initialized;

    public ConsoleLottoStrategy() {
        this.initialized = false;
    }

    @Override
    public Lotto createLotto() {
        initialize();
        if(manualCount == 0 && manualCount < manualNum) {
            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        }
        if(manualCount < manualNum) {
            manualCount++;
            return manualStrategy.createLotto();
        }
        return randomStrategy.createLotto();
    }

    private void initialize() {
        if(!initialized) {
            Scanner sc = new Scanner(System.in);
            System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
            this.manualNum = Integer.parseInt(sc.nextLine());
            initialized = true;
        }
    }
}
