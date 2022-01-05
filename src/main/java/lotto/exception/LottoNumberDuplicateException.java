package lotto.exception;

/**
 * Created by melodist
 * Date: 2022-01-05 005
 * Time: 오후 1:47
 */
public class LottoNumberDuplicateException extends RuntimeException{
    public LottoNumberDuplicateException(String s) {
        super(s);
    }
}
