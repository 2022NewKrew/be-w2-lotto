package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public abstract class Input {
    protected static final int LOTTO_START_NUMBER = 1;
    protected static final int LOTTO_LAST_NUMBER = 45;
    protected final Scanner sc = new Scanner(System.in);
}


class SingleInput extends Input {
    protected int input;


    protected void init(){
        printMessage();
        input = sc.nextInt();
        validValueCheck();
        System.out.println();
    }

    protected void printMessage(){}
    protected void validValueCheck(){}
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

    protected void validation(){
        ValidInput.wrongLottoNumber(numList);
    }
}


class PriceInput extends SingleInput {
    private static final int LOTTO_PRICE = 1000;


    @Override
    protected void printMessage() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    @Override
    protected void validValueCheck() {
        ValidInput.inputUnderValue(LOTTO_PRICE, input);
    }

    public int getNumOfNumbers() {
        return input/LOTTO_PRICE;
    }
}


class ManualInput extends SingleInput{
    private final int numOfLottoNumbers;

    ManualInput(int numOfNumbers){
        numOfLottoNumbers = numOfNumbers;
    }

    @Override
    protected void printMessage() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    @Override
    protected void validValueCheck() {
        ValidInput.wrongRangeValue(0, numOfLottoNumbers, input);
    }

}


class BonusNumberInput extends SingleInput {


    @Override
    protected void printMessage() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    @Override
    protected void validValueCheck() {
        ValidInput.wrongRangeValue(LOTTO_START_NUMBER, LOTTO_LAST_NUMBER, input);
    }
}


class WinningInput extends MultipleInput {

    WinningInput(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        numList = getIntegers();
        Collections.sort(numList);
        validation();
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
            Collections.sort(numList);
            validation();
            LottoNumber ln = new LottoNumber(numList);
            manualNumbers.add(ln);
        }
        System.out.println();
    }

    public List<LottoNumber> getInput() { return manualNumbers; }
}

