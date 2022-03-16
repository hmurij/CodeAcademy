package lt.codeacademy;

import lt.codeacademy.entity.Users;
import org.hibernate.Session;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();

        Users user = Users.builder()
                .userName("JohnDoe")
                .userPassword("12345")
                .email("john.doe@email.com")
                .build();
        session.save(user);
        session.createQuery("from Users", Users.class)
                .getResultList().forEach(System.out::println);


        session.getTransaction().commit();
        session.close();
    }
}
