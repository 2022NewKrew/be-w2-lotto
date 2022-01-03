package input.dto;

import java.util.List;

public class InputInfo {
    private final int amountOfTicket;
    private List<Integer> target;

    public InputInfo(int amountOfTicket) {
        this.amountOfTicket = amountOfTicket;
    }

    public int getAmountOfTicket() {
        return amountOfTicket;
    }

    public List<Integer> getTarget() {
        return target;
    }

    public void setTarget(List<Integer> target) {
        this.target = target;
    }
}
