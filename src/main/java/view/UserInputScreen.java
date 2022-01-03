package view;

import domain.entity.LottoTicket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInputScreen {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    private int getUserInputInt(String message) throws IOException {
        System.out.println(message);
        return Integer.parseInt(bufferedReader.readLine());
    }

    private String getUserInputString(String message) throws IOException {
        System.out.println(message);
        return bufferedReader.readLine();
    }

    public int queryPurchaseAmount() throws IOException {
        return getUserInputInt("구입금액을 입력해 주세요.");
    }

    public LottoTicket queryWinningLotto() throws IOException {
        String[] inputArray = getUserInputString("지난 주 당첨 번호를 입력해 주세요.").split(",");
        return new LottoTicket(Arrays.stream(inputArray)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }
}
