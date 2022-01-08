package step5.model.service;

import step5.model.domain.BonusNumber;
import step5.model.domain.Lottos;
import step5.model.domain.Matches;
import step5.model.domain.Result;

public interface MatchesService {
    Matches selectAllMatchesFromRepository();
    void updateMatchesInRepository(Matches matches);

    default Matches startMatch(Lottos lottos, String resultStr, String bonusNumberStr) {
        Result result = new Result(resultStr);
        BonusNumber bonusNumber = new BonusNumber(Integer.parseInt(bonusNumberStr), result);
        Matches matches = new Matches();
        matches.matchLottosWithResult(lottos, result, bonusNumber);

        return matches;
    }

    default Matches updateMatchesWithAllLottos(Lottos lottos, String resultStr, String bonusNumberStr) {
        Matches matches = startMatch(lottos, resultStr, bonusNumberStr);
        updateMatchesInRepository(matches);

        return matches;
    }
}
