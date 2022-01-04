package controller;

import domain.LottoRepository;
import domain.Result;
import view.PurchaseView;
import view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoController {

    private Scanner sc = new Scanner(System.in);
    private int money, quantity;
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
        quantity = money / 1000;
        lottoRepository = new LottoRepository(quantity);
        System.out.println(quantity + "개를 구매했습니다.");
        PurchaseView pv = new PurchaseView(lottoRepository);
        pv.showLottoList();
    }

    private void lottoResult() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        sc.nextLine();
        winningNums = Arrays.asList(sc.nextLine().split(","))
                .stream().map(Integer::parseInt).collect(Collectors.toList());
        System.out.println("보너스 볼을 입력해 주세요.");
        bonusBall = sc.nextInt();
        Result result = new Result(lottoRepository, winningNums, bonusBall);
        ResultView rv = new ResultView(result);
        rv.showResult();
        rv.showYield();
    }

}
