package lotto;

import lotto.collections.LottoNumber;
import lotto.domain.LottoPack;
import lotto.dto.LottoResults;
import lotto.dto.MatchNum;
import lotto.view.IO;

import java.util.Arrays;
import java.util.List;

//멤버 클래스에서 바깥 인스턴스에 접근할 일이 없다면 무조건 static을 붙여서 정적 멤버 클래스로 만들자.
// cmd + option + m -> 줄 여러개 드래그한후에 단축키 하면 함수 자동 생성해줌.
public class Main {
    public static void main(String[] args) {

        int itemCnt = IO.start();

        LottoPack lottoPack = new LottoPack(itemCnt);
        List<List<LottoNumber>> lottoNums = lottoPack.getNumList();

        IO.printPurchasedLottos(lottoNums);

        MatchNum matchNum =IO.enterMatchNums();
        LottoResults lottoResults = lottoPack.getResults(matchNum); // -> 추후 test, earnRate, prevNum
        IO.showResults(lottoResults);

    }
}
