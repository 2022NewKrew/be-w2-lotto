package dto;

import java.util.ArrayList;

public class LottoNumberContainerDTO {
    private final ArrayList<LottoNumberDTO> lottoNumbers = new ArrayList<>();

    public ArrayList<LottoNumberDTO> getLottoNumbers() {
        return lottoNumbers;
    }

    public void addLottoNumber(LottoNumberDTO lottoNumberDTO) {
        lottoNumbers.add(lottoNumberDTO);
    }
}
