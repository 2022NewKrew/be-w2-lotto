package domain.tickets;

import domain.GroundRule;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoTicket extends Ticket {
    private static final List<Integer> NUMBER_CANDIDATES
            = IntStream.range(GroundRule.MIN_SELECTION_NUMBER, GroundRule.MAX_SELECTION_NUMBER).boxed().collect(Collectors.toList());
    public AutoTicket() {
        List<Integer> lottoNumbers = this.NUMBER_CANDIDATES;
        Collections.shuffle(lottoNumbers);
        for (int i = 0; i < GroundRule.NUM_OF_SELECTION; i++) {
            this.selectedNumbers.add(lottoNumbers.get(i));
            Collections.sort(this.selectedNumbers);
        }
    }
}
