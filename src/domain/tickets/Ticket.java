package domain.tickets;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
    protected List<Integer> selectedNumbers = new ArrayList<>();

    public List<Integer> getSelectedNumbers() {
        return this.selectedNumbers;
    }

}
