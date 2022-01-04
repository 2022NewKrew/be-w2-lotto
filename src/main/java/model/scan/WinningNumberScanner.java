package model.scan;

import validator.LottoNumberValidator;
import validator.ValidatorInterface;

import java.util.ArrayList;
import java.util.List;

public class WinningNumberScanner extends InputData {
    public WinningNumberScanner() { }

    public List<Integer> getWinningNumbers(){
        validatorInterface = new LottoNumberValidator();
        String winningNumbers;
        do {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            winningNumbers = getInput();
        }while(!validatorInterface.validateData(winningNumbers));

        return convertToList(winningNumbers);
    }

    private List<Integer> convertToList(String winningNumbers){
        List<Integer> listWinningNumber = new ArrayList<>();
        for(String number : winningNumbers.split(",")){
            listWinningNumber.add(Integer.parseInt(number));
        }

        return listWinningNumber;
    }
}
