package lotto.view;

import lotto.com.kakao.LottoBundle;

public class ConsoleOutput {

    public static void printLottoCount(int count) {
        System.out.println(Integer.toString(count)+"개를 구매했습니다.");
    }
    public static void printLottoBundle(LottoBundle lottoBundle){
        System.out.println(lottoBundle);
    }
}
