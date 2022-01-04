package view.input;

import domain.LottoResult;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ResultConsolReader implements ResultInputReader{
    @Override
    public LottoResult readResult(Scanner sc) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String resultInput = sc.nextLine();
        List<Integer> result = Arrays.asList(resultInput.split(", ")).stream()
                .map(num -> Integer.parseInt(num.trim()))
                .collect(Collectors.toList());
        return new LottoResult(result);
    }
}
