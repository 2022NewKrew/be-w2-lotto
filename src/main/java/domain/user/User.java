package domain.user;

import domain.lotto.LottoNumber;
import domain.lotto.LottoNumbersContainer;
import domain.lotto.LottoNumberContainerDTO;
import domain.lotto.LottoNumberDTO;

public interface User {
    Long getUserId();
    int getOwnedMoney();
    int getCostedMoney();
    void increaseOwnedMoney(int money);
    void increaseCostedMoney(int money);
    void addLottosByDTO(LottoNumberContainerDTO dto) throws Exception;
    void addOneLotto(LottoNumberDTO dto) throws Exception;
    void addOneLotto(LottoNumber lottoNumber) throws Exception;
    LottoNumbersContainer getLottoNumbersContainer();

    LottoNumberContainerDTO getOwnedLottoTicketsDTO();

}
