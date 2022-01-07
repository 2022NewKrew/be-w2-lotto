package domain.tickets;

import java.util.Collections;
import java.util.List;

public class ManualTicket extends Ticket {
    public ManualTicket(List<Integer> selectedNumbers) {
        this.selectedNumbers = selectedNumbers;
        Collections.sort(this.selectedNumbers);
    }
}
