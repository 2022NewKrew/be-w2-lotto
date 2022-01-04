package domain.user;

import domain.lotto.LottoNumber;
import domain.lotto.LottoNumbersContainer;
import dto.LottoNumberContainerDTO;
import dto.LottoNumberDTO;

public class NormalUser implements User{
    private final Long id;
    private int ownedMoney = 0;
    private int costedMoney = 0;
    private LottoNumbersContainer lottoNumbersContainer = new LottoNumbersContainer();

    public NormalUser(Long id) {
        this.id = id;
    }


    public void increaseOwnedMoney(int money) {
        ownedMoney = ownedMoney + money;
    }
    public void increaseCostedMoney(int money) {
        costedMoney = costedMoney + money;
    }

    @Override
    public void addOneLotto(LottoNumberDTO dto) throws Exception {


        lottoNumbersContainer.add(new LottoNumber(dto.getArrayListInteger()));
    }

    @Override
    public void addLottosByDTO(LottoNumberContainerDTO dto) throws Exception{
        for (LottoNumberDTO lottoNumberDTO : dto.getLottoNumbers()) {
            addOneLotto(lottoNumberDTO);
        }
    }

    @Override
    public Long getUserId() {
        return null;
    }

    @Override
    public int getOwnedMoney() {
        return ownedMoney;
    }

    @Override
    public LottoNumberContainerDTO getOwnedLottoTicketsDTO() {
        return lottoNumbersContainer.getDTO();
    }

    @Override
    public int getCostedMoney() {
        return costedMoney;
    }
}
