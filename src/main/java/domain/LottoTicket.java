package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    public static final int LOTTO_NUMBERS_COUNT = 6;

    private List<LottoNumber> ticket;

    public LottoTicket(List<LottoNumber> ticket){
        validateLottoNumberCount(ticket);
        this.ticket=new ArrayList<>(ticket);
    }

    public List<LottoNumber> getTickets() {
        return Collections.unmodifiableList(this.ticket);
    }

    private void validateLottoNumberCount(List<LottoNumber> ticket) throws IllegalArgumentException{
        if(ticket.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException("로또 번호의 수는 최소"+LOTTO_NUMBERS_COUNT+"개 입력해야합니다.");
        }
    }
}
