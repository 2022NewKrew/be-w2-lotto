package lotto.controller;


import lotto.VO.InvalidFormatException;
import lotto.VO.LackOfMoneyException;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import lotto.view.LottoView;
import lotto.view.LottoWebView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static spark.Spark.*;
import static spark.Spark.post;

public class LottoWebApplication implements LottoApplication {
    private static LottoView VIEW = new LottoWebView();

    private Lottos lottos = new Lottos();
    private int accumPayment;
    private int countOfManualLotto;


    public void start() {
        port(8080);
        staticFiles.location("/templates");

        post("/buyLotto", (req, res) -> {
            try {
                Money money = parseMoney(req);
                int maxCountOfLotto = money.getAmount() / Lotto.PRICE;
                for (Lotto lotto : parseManualLottos(req)) {
                    buyManualLotto(money, lotto);
                }
                for (int i = 0; i < maxCountOfLotto - this.countOfManualLotto; i++) {
                    buyRandomLotto(money);
                }

                return VIEW.printLottos(lottos);
            } catch (IllegalArgumentException e) {
                return VIEW.printError(e.getMessage());
            }
        });

        post("/matchLotto", (req, res) -> {
            try {
                WinningLotto winningLotto = parseWinLotto(req);
                LottoResult lottoResult = lottos.match(winningLotto);
                float totalRateOfReturn = (lottoResult.getTotalReturn() - accumPayment) / accumPayment * 100;

                return VIEW.printLottoResult(lottoResult, totalRateOfReturn);//render(matchLotto(req), "result.html");
            } catch (IllegalArgumentException e) {
                return VIEW.printError(e.getMessage());
            }
        });
    }

    public void buyManualLotto(Money payment, Lotto lotto) throws LackOfMoneyException {
        try {
            payment.decrement(Lotto.PRICE);
        } catch (LackOfMoneyException e) {
            throw e;
        }

        this.lottos.add(lotto);
        this.accumPayment += Lotto.PRICE;
        this.countOfManualLotto += 1;
    }

    public void buyRandomLotto(Money payment) throws LackOfMoneyException {
        try {
            payment.decrement(Lotto.PRICE);
        } catch (LackOfMoneyException e) {
            throw e;
        }

        this.lottos.add(LottoGenerator.generateRandomLotto());
    }


    public Money parseMoney(spark.Request req) throws InvalidFormatException {
        int inputNumber = Integer.parseInt(req.queryParams("inputMoney"));
        ExceptionCheck.validateMoneyNumber(inputNumber);

        return new Money(inputNumber);
    }

    public Lottos parseManualLottos(spark.Request req) throws InvalidFormatException {
        List<Lotto> lottos = Arrays.stream(req.queryParams("manualNumber").split("\r?\n"))
                .map(String::trim)
                .map(this::parseManualLotto)
                .collect(Collectors.toList());
        return new Lottos(lottos);
    }

    public Lotto parseManualLotto(String str) throws InvalidFormatException {
        List<Integer> numbers = Arrays.stream(str.trim().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .distinct()
                .collect(Collectors.toList());

        ExceptionCheck.validateLottoNumbers(numbers);

        return new Lotto(numbers);
    }

    public WinningLotto parseWinLotto(spark.Request req) throws InvalidFormatException {
        Lotto lotto = parseManualLotto(req.queryParams("winningNumber"));
        int bonusNumber = Integer.parseInt(req.queryParams("bonusNumber"));

        ExceptionCheck.validateLottoNumber(bonusNumber);

        return new WinningLotto(lotto, bonusNumber);
    }

}
