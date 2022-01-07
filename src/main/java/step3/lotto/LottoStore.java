package step3.lotto;

import step3.input.CommandLineInputView;
import step3.input.InputView;
import step3.lotto.domain.LottoTicket;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoStore {
    private static LottoCreater autoCreator = new LottoCreatorAuto();
    private static LottoCreater selfCreator = new LottoCreatorSelf();
    private static InputView inputView = new CommandLineInputView();

    public static List<LottoTicket> buy(int buyAmount) {
        System.out.println("수동으로 구매할 로또 수를 입력해주세요.");
        int selfAmount = inputView.inputAmoundOfSelf(buyAmount);

        return Stream.of(buySelf(selfAmount), buyAuto(buyAmount - selfAmount))
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());
    }

    public static List<LottoTicket> buyAuto(int amount) {
        return IntStream.range(0, amount).mapToObj(i -> autoCreator.create()).collect(Collectors.toList());
    }

    public static List<LottoTicket> buySelf(int amount) {
        if(amount != 0){
            System.out.println("수동으로 구매할 번호를 입력해주세요. 입력 예시 : 1,2,3,4,5,6");
        }
        return IntStream.range(0, amount).mapToObj(i -> selfCreator.create()).collect(Collectors.toList());
    }
}
