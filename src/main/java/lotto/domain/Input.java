package lotto.domain;

import lotto.util.ValidInput;
import java.util.*;
import java.util.stream.Collectors;
import static lotto.util.ConstantValue.*;


public abstract class Input {
    protected final Scanner sc = new Scanner(System.in);
}

/**
 * 단일 입력을 위한 클래스
 */
class SingleInput extends Input {
    protected int input;

    /**
     * int 값 input을 받고 조건에 맞는 값인지 확인합니다.
     */
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


/**
 * 다중 입력을 위한 클래스
 */
class MultipleInput extends Input {
    protected List<Integer> numList;

    /**
     * 여러 정수 값(로또 한 줄)을 입력받습니다.
     * @return 입력받은 정수들이 담긴 List<Integer>
     */
    protected List<Integer> getIntegers(){
        String numInput = sc.nextLine();
        String[] numInputString = numInput.replaceAll(" ", "").split(",");
        ValidInput.wrongSize(numInputString);
        return Arrays.stream(numInputString)
                .map(Integer::parseInt)
                .distinct()
                .collect(Collectors.toList());
    }

    protected void validation(){
        ValidInput.wrongSize(numList);
        ValidInput.wrongLottoNumber(numList);
    }
}


/**
 * 구입 금액을 입력받는 클래스
 */
class PriceInput extends SingleInput {

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


/**
 * 수동으로 입력할 로또 한 줄의 갯수를 입력받는 클래스
 */
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


/**
 * 보너스 볼의 숫자를 입력하는 클래스
 */
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


/**
 * 지난 당첨 번호들을 입력하는 클래스
 */
class WinningInput extends MultipleInput {

    WinningInput(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        numList = getIntegers();
        Collections.sort(numList);
        validation();
    }

    public List<Integer> getInput(){ return numList; }
}


/**
 * 수동으로 로또 번호를 입력하는 클래스, 입력받은 횟수에 기반하여 입력값 생성
 */
class ManualNumberInput extends MultipleInput{
    private final List<LottoNumber> manualNumbers = new ArrayList<>();
    private final int numOfManual;

    ManualNumberInput(int numOfTry){
        System.out.println("수동으로 구매할 번호를 입력해 주세요");
        numOfManual = numOfTry;
    }

    /**
     * 생성한 로또 여러 줄을 List<LottoNumber>에 추가
     */
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

