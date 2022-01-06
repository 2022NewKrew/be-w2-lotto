package dto;

import java.util.List;

public class LottoListCreateDto {
    private int budget;
    private List<LottoDto> manualLottoList;

    public LottoListCreateDto() {}

    public LottoListCreateDto(int budget,
                              List<LottoDto> manualLottoList) {
        this.budget = budget;
        this.manualLottoList = manualLottoList;
    }

    public int getBudget() {
        return budget;
    }

    public List<LottoDto> getManualLottoList() {
        return manualLottoList;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public void setManualLottoList(List<LottoDto> manualLottoList) {
        this.manualLottoList = manualLottoList;
    }
}
