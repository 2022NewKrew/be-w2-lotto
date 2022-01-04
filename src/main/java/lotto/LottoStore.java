package lotto;

import input.CommandLineInputView;
import input.InputView;
import input.Validator;
import lotto.domain.LottoTicket;

import java.util.ArrayList;
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
        ArrayList<LottoTicket> tickets = new ArrayList<>();
        IntStream.range(0, amount).forEach(i -> tickets.add(autoCreator.create()));
        return tickets;
    }

    public static List<LottoTicket> buySelf(int amount) {
        ArrayList<LottoTicket> tickets = new ArrayList<>();
        if(amount != 0){
            System.out.println("수동으로 구매할 번호를 입력해주세요. 입력 예시 : 1,2,3,4,5,6");
            IntStream.range(0, amount).forEach(i -> tickets.add(selfCreator.create()));
        }

        return tickets;
    }
}
