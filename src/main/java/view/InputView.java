package view;

import domain.LottoNumber;
import domain.LottoPrice;
import domain.LottoTicket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private InputView() {

    }

    public static LottoPrice inputLottoPrice() throws IOException {
        System.out.println("구매금액을 입력해 주세요.");
        return new LottoPrice(stoi(br.readLine()));
    }

    public static LottoTicket inputWinningNumber() throws IOException {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<LottoNumber> winningNumbers = Arrays.stream(br.readLine().split(","))
                .map(numStr -> new LottoNumber(Integer.parseInt(numStr)))
                .collect(Collectors.toList());
        return new LottoTicket(winningNumbers);

    }

    public static int stoi(String input) {
        return Integer.parseInt(input);
    }
}
