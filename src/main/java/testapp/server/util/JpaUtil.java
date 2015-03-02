package testapp.server.util;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.SQLException;

public class JpaUtil {
    private static final EntityManager entityManager;

    static {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
        entityManager = emf.createEntityManager();
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }

    public static Connection getConnection(){
        final Connection[] connections = new Connection[1];
        Session session = getEntityManager().unwrap(Session.class);
        session.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                connections[0] = connection;
            }
        });
        return connections[0];
    }
}
