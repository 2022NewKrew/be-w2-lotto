package step5.model.repository;

import org.h2.jdbcx.JdbcDataSource;
import step5.model.domain.Matches;
import step5.utils.Rank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

public class MatchesRepositoryImpl implements MatchesRepository {
    private static final MatchesRepository INSTANCE = new MatchesRepositoryImpl();

    private final JdbcDataSource ds = new JdbcDataSource();

    private MatchesRepositoryImpl() {
        ds.setURL("jdbc:h2:~/lottos");
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
                matches.replaceInMatches(Rank.valueOf(rs.getString(1)), rs.getInt(2));
            }

            return matches;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public void updateMatches(Matches matches) {
        String sql = "update matches set rank = ?, count = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);

            for (Map.Entry<Rank, Integer> entry : matches.entrySet()) {
                pstmt.setString(1, entry.getKey().getRankStr());
                pstmt.setInt(2, entry.getValue());
                pstmt.executeUpdate();
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt);
        }
    }
}
