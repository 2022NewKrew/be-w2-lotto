package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public abstract class Input {
    protected final Scanner sc = new Scanner(System.in);
}


class SingleInput extends Input {
    protected int input;

    SingleInput(){
        printMessage();
        input = sc.nextInt();
        System.out.println();
    }

    protected void printMessage(){}
    public int getInput(){return input;}
}


class MultipleInput extends Input {
    protected List<Integer> numList;

    protected List<Integer> getIntegers(){
        String numInput = sc.nextLine();
        return Arrays.stream(numInput.replaceAll(" ","").split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}


class PriceInput extends SingleInput {
    private static final int LOTTO_PRICE = 1000;


    @Override
    protected void printMessage() {
        System.out.println("구입 금액을 입력해 주세요.");
    }


    public int getNumOfNumbers() {
        return input/LOTTO_PRICE;
    }
}


class ManualInput extends SingleInput{
    @Override
    protected void printMessage() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    }
}


class BonusNumberInput extends SingleInput {
    @Override
    protected void printMessage() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }
}


class WinningInput extends MultipleInput {

    WinningInput(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        numList = getIntegers();
    }
    public List<Integer> getInput(){ return numList; }
}


class ManualNumberInput extends MultipleInput{
    private final List<LottoNumber> manualNumbers = new ArrayList<>();
    private final int numOfManual;

    ManualNumberInput(int numOfTry){
        System.out.println("수동으로 구매할 번호를 입력해 주세요");
        numOfManual = numOfTry;
    }

    public void convertToList(){
        for(int i=0;i<numOfManual;i++){
            numList = getIntegers();
            LottoNumber ln = new LottoNumber(numList);
            manualNumbers.add(ln);
        }
        System.out.println();
    }

    public List<LottoNumber> getInput() { return manualNumbers; }
}

