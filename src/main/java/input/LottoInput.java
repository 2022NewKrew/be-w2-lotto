package input;

import domain.Lotto;
import domain.LottoConst;
import exception.ExceptionCheck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoInput {
    protected final ExceptionCheck ec = new ExceptionCheck();

    public int inputPrice(String inputPrice) throws IllegalArgumentException{
        int price = Integer.parseInt(inputPrice);
        ec.checkPositiveNumber(price);
        ec.checkMinPrice(price);
        return price;
    }

    public List<Lotto> inputManualLotto(String inputLottos, int totalPrice) throws IllegalArgumentException{
        List<Lotto> manualLotto = new ArrayList<>();

        for (String inputLotto : inputLottos.split("\n")) {
            Lotto lotto = new Lotto(Arrays.stream(inputLotto.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList())
            );

            ec.checkLotto(lotto);
            manualLotto.add(lotto);
        }

        if(manualLotto.size() * LottoConst.ONE_LOTTO_PRICE > totalPrice){
            throw new IllegalArgumentException("금액을 초과했습니다.");
        }

        return manualLotto;
    }

    public Lotto inputResultLotto(String resultLotto){
        List<Integer> lottoNumber = Arrays.stream(resultLotto.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Lotto lotto = new Lotto(lottoNumber);
        ec.checkLotto(lotto);

        return lotto;
    }

    public int inputResultBonusLotto(String number) throws IllegalArgumentException{
        int bonusNumber = Integer.parseInt(number);

        ec.checkPositiveNumber(bonusNumber);
        ec.checkLottoNumber(bonusNumber);

        return bonusNumber;
    }
}
