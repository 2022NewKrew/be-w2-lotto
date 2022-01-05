package view;

import domain.Lotto;
import domain.LottoConst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInput {
    private final Scanner sc = new Scanner(System.in);

    public int inputPrice() throws IllegalArgumentException{
        System.out.println("구입 금액을 입력해주세요.");
        int price = Integer.parseInt(sc.nextLine());

        checkPositiveNumber(price);

        return price;
    }

    public int inputManualCount() throws IllegalArgumentException{
        System.out.println("수동으로 구매할 로또 수를 입력하세요.");
        int count = Integer.parseInt(sc.nextLine());

        checkPositiveNumber(count);

        return count;
    }

    public List<Lotto> inputManualLotto(int totalPrice) throws IllegalArgumentException{
        int manualCount = inputManualCount();
        if(manualCount * LottoConst.ONE_LOTTO_PRICE > totalPrice){
            throw new IllegalArgumentException("금액을 초과했습니다.");
        }

        List<Lotto> manualLotto = new ArrayList<>();

        System.out.println("수동으로 구매할 번호를 입력하세요.");
        for(int i=0; i<manualCount; i++){
            String[] inputLotto = sc.nextLine().split(",");
            Lotto lotto = new Lotto(Arrays.stream(inputLotto)
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList())
            );
            checkLotto(lotto);
            manualLotto.add(lotto);
        }

        return manualLotto;
    }

    public Lotto inputResultLotto(){
        System.out.println("지난 주 당첨 번호를 입력해주세요.");

        List<Integer> lottoNumber = Arrays.stream(sc.nextLine().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Lotto lotto = new Lotto(lottoNumber);
        checkLotto(lotto);

        return lotto;
    }

    public int inputResultBonusLotto() throws IllegalArgumentException{
        System.out.println("보너스 볼을 입력해주세요.");
        int bonusNumber = Integer.parseInt(sc.nextLine());

        checkPositiveNumber(bonusNumber);
        checkLottoNumber(bonusNumber);

        return bonusNumber;
    }

    private void checkLotto(Lotto lotto) throws IllegalArgumentException{
        int size = (int) lotto.getLotto().stream()
                .distinct()
                .count();

        checkLottoSize(size);
        for (Integer lottoNum : lotto.getLotto()) {
            checkLottoNumber(lottoNum);
        }
    }

    private void checkPositiveNumber(int number){
        if(number < 0) {
            throw new IllegalArgumentException("0보다 작은값은 입력할 수 없습니다.");
        }
    }

    private void checkLottoNumber(int number){
        if(number < LottoConst.LOTTO_MIN_NUMBER || number > LottoConst.LOTTO_MAX_NUMBER){
            throw new IllegalArgumentException("1~45사이의 번호만 입력할 수 있습니다.");
        }
    }

    private void checkLottoSize(int size){
        if(size != LottoConst.LOTTO_SIZE){
            throw new IllegalArgumentException("중복되지 않은 6개의 번호를 입력해야 합니다.");
        }
    }
}
