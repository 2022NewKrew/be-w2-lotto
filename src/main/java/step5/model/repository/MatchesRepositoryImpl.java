package step5.model.repository;

import org.h2.jdbcx.JdbcDataSource;
import step5.model.domain.Matches;
import step5.utils.Rank;
import step5.utils.exception.RepositoryException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

public class MatchesRepositoryImpl implements MatchesRepository {
    private static final MatchesRepository INSTANCE = new MatchesRepositoryImpl();

    private final JdbcDataSource ds = new JdbcDataSource();

    private MatchesRepositoryImpl() {
        ds.setURL("jdbc:h2:tcp://localhost/~/lottos");
        ds.setUser("myles.nah");
    }

    public static MatchesRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public Matches selectAllMatches() {
        String sql = "select rank, count from matches";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Matches matches = new Matches();

        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                matches.replaceInMatches(Rank.valueOfByRankStr(rs.getString(1)),
                        rs.getInt(2));
            }

            return matches;
        } catch (Exception e) {
            throw new RepositoryException("구매한 로또와 당첨 번호를 비교한 모든 결과를 DB에서 가져오는데 오류가 발생했습니다.");
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public void updateMatches(Matches matches) {
        String sql = "update matches set count = ? where rank = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            conn.setAutoCommit(false);

            for (Map.Entry<Rank, Integer> entry : matches.entrySet()) {
                pstmt.setInt(1, entry.getValue());
                pstmt.setString(2, entry.getKey().getRankStr());
                pstmt.addBatch();
            }

            pstmt.executeBatch();
            conn.commit();
        } catch (Exception e) {
            throw new RepositoryException("구매한 로또와 당첨 번호를 비교한 모든 결과를 DB에 갱신하는데 오류가 발생했습니다.");
        } finally {
            close(conn, pstmt);
        }
    }
}
