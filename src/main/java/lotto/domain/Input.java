package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public abstract class Input {
    protected final Scanner sc = new Scanner(System.in);
}

class SingleInput extends Input {
    protected int input;

    public int getInput(){return input;}
}

class MultipleInput extends Input {
    List<Integer> numList;

    protected List<Integer> getIntegers(){
        String numInput = sc.nextLine();
        return Arrays.stream(numInput.replaceAll(" ","").split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> getInput(){ return numList; }
}


class PriceInput extends SingleInput {
    private final int LOTTO_PRICE = 1000;


    public PriceInput(){
        System.out.println("구입 금액을 입력해 주세요.");
        input = sc.nextInt();
    }


    public int getNumOfPaper() {
        int numOfPaper = input/LOTTO_PRICE;
        System.out.println(numOfPaper +"개를 구매했습니다.");
        return numOfPaper;
    }
}


class WinningInput extends MultipleInput {

    WinningInput(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        numList = getIntegers();
    }
}

