package domain.tickets;

import java.util.List;

public class TicketMachine {
    public ManualTicket manualTicket = new ManualTicket();
    public AutoTicket autoTicket = new AutoTicket();

    public ManualTicket makeManualTicket(List<Integer> selectedNumbers) {
        return new ManualTicket(selectedNumbers);
    }

    public AutoTicket makeAutoTicket() {
        return new AutoTicket();
    }

}
