package domain.user;

import dto.LottoNumberContainerDTO;
import dto.LottoNumberDTO;

public interface User {
    Long getUserId();
    int getOwnedMoney();
    int getCostedMoney();
    void increaseOwnedMoney(int money);
    void increaseCostedMoney(int money);
    void addLottosByDTO(LottoNumberContainerDTO dto) throws Exception;
    void addOneLotto(LottoNumberDTO dto) throws Exception;
    LottoNumberContainerDTO getOwnedLottoTicketsDTO();

}
