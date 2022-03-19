package lt.codeacademy.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HibernateUtilsTest {
    private static final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    @Test
    void sessionFactory_openSession_sessionNotNull() {
        Session session = sessionFactory.openSession();

        assertNotNull(session);
        session.close();
    }
}
