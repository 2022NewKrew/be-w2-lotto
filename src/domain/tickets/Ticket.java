package domain.tickets;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
    protected List<Integer> selectedNumbers = new ArrayList<>();
    protected final int price = 1000;

    public List<Integer> getSelectedNumbers() {
        return this.selectedNumbers;
    }
    public int getPrice() {
        return price;
    }

}
