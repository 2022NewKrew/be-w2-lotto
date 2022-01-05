package presentation.view.input;

import dto.input.PurchaseDto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class PurchaseInputView implements InputView<PurchaseDto> {
    private final Scanner scanner;

    public PurchaseInputView(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public PurchaseDto input() {
        int purchasePrice = inputPurchasePrice();
        int numOfManualLotto = inputNumOfManualLotto();
        List<List<Integer>> manualLottoNumberLists = inputManualLottoNumberLists(numOfManualLotto);

        return new PurchaseDto(purchasePrice, manualLottoNumberLists);
    }

    private int inputPurchasePrice(){
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    private int inputNumOfManualLotto(){
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    private List<List<Integer>> inputManualLottoNumberLists(int numOfManualLotto){
        if(numOfManualLotto == 0){
            return Collections.emptyList();
        }

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return Stream.generate(this::inputManualLottoNumbers)
                .limit(numOfManualLotto)
                .collect(toList());
    }

    private List<Integer> inputManualLottoNumbers(){
        return Arrays.stream(scanner.next().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());
    }
}
