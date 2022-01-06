package Domain.Tickets;

import java.util.Collections;
import java.util.List;

public class AutoTicket extends Ticket {
    public AutoTicket() {
        List<Integer> lottoNumbers = this.LOTTO_NUMBERS;
        Collections.shuffle(lottoNumbers);
        for (int i = 0; i < this.NUM_OF_LOTTO_NUMBERS; i++) {
            this.selectedNumbers.add(lottoNumbers.get(i));
            Collections.sort(this.selectedNumbers);
        }
    }
}
