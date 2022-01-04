package parameters;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class UserLottoLines {
    private final List<LottoLine> userLottoLines;

    public UserLottoLines(int amount) { userLottoLines = new ArrayList<>(amount); }

    public void addLottoLine(LottoLine lottoLine) { userLottoLines.add(lottoLine); }
    public Stream<LottoLine> getUserLottoLinesStream() { return userLottoLines.stream(); }
}
