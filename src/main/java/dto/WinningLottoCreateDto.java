package dto;

import java.util.List;

public class WinningLottoCreateDto {
    private List<Integer> sequence;
    private int bonusNumber;

    public WinningLottoCreateDto(List<Integer> sequence, int bonusNumber) {
        this.bonusNumber = bonusNumber;
        this.sequence = sequence;
    }

    public List<Integer> getSequence() {
        return sequence;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
