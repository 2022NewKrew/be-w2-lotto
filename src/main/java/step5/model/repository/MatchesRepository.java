package step5.model.repository;

import step5.model.domain.Matches;

public interface MatchesRepository extends Repository {
    Matches selectAllMatches();
    void updateMatches(Matches matches);
}
