package step5.model.repository;

import step5.model.domain.Lotto;
import step5.model.domain.Lottos;
import org.h2.jdbcx.JdbcDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.*;

public class LottosRepositoryImpl implements LottosRepository {
    private JdbcDataSource ds = new JdbcDataSource();
    private static LottosRepository instance = new LottosRepositoryImpl();

    private LottosRepositoryImpl() {
        ds.setURL("jdbc:h2:~/lottos");
        ds.setUser("myles.nah");
    }

    public static LottosRepository getInstance() {
        return instance;
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
            closeConnection(conn);
            closePreparedStatement(pstmt);
            closeResultSet(rs);
        }
    }

    @Override
    public void insertLotto(Lotto lotto) {
        String sql = "insert into lottos(numbers) values(?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, lotto.toString());
            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            closeConnection(conn);
            closePreparedStatement(pstmt);
        }
    }
}
