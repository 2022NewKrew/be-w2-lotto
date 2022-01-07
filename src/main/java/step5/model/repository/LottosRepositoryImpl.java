package step5.model.repository;

import org.h2.jdbcx.JdbcDataSource;
import step5.model.domain.Lotto;
import step5.model.domain.Lottos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LottosRepositoryImpl implements LottosRepository {
    private static final LottosRepository INSTANCE = new LottosRepositoryImpl();

    private final JdbcDataSource ds = new JdbcDataSource();

    private LottosRepositoryImpl() {
        ds.setURL("jdbc:h2:tcp://localhost/~/lottos");
        ds.setUser("myles.nah");
    }

    public static LottosRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public Lottos selectAllLottos() {
        String sql = "select numbers from lottos";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Lottos lottos = new Lottos();

        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                lottos.addLotto(new Lotto(rs.getString(1)));
            }

            return lottos;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public void insertLottos(Lottos lottos) {
        String sql = "insert into lottos(numbers) values(?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            conn.setAutoCommit(false);

            for (Lotto lotto : lottos) {
                pstmt.setString(1, lotto.toString());
                pstmt.addBatch();
            }

            pstmt.executeBatch();
            conn.commit();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt);
        }
    }
}
