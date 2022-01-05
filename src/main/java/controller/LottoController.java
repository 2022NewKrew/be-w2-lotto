package controller;

import domain.LottoRepository;
import domain.LottoValidation;
import domain.Result;
import view.PurchaseView;
import view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoController {

    private Scanner sc = new Scanner(System.in);
    private int money, autoQuantity, manualQuantity;
    private LottoRepository lottoRepository;
    private List<Integer> winningNums;
    private int bonusBall;

    public LottoController() {
        lottoPurchase();
        lottoResult();
    }

    private void lottoPurchase() {
        System.out.println("구입금액을 입력해 주세요.");
        money = sc.nextInt();
        autoQuantity = money / 1000;
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요");
        manualQuantity = sc.nextInt();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        lottoRepository = new LottoRepository(autoQuantity, manualQuantity);
        System.out.println("수동으로 " + manualQuantity + "장, 자동으로" + autoQuantity + "개를 구매했습니다.");
        PurchaseView pv = new PurchaseView(lottoRepository);
        pv.showLottoList();
    }

    private void lottoResult() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        sc.nextLine();
        winningNums = Arrays.stream(sc.nextLine().split(",")).map(Integer::parseInt).collect(Collectors.toList());
        new LottoValidation(winningNums);
        System.out.println("보너스 볼을 입력해 주세요.");
        bonusBall = sc.nextInt();
        Result result = new Result(lottoRepository, winningNums, bonusBall);
        ResultView rv = new ResultView(result);
        rv.showResult();
        rv.showYield();
    }

}
