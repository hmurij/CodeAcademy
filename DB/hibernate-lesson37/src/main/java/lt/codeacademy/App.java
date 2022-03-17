package lt.codeacademy;

import lt.codeacademy.entity.Users;
import lt.codeacademy.entity.Worker;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();

        // save user
/*
        Users user = Users.builder()
                .userName("JohnDoe")
                .userPassword("12345")
                .email("john.doe@email.com")
                .build();
        session.save(user);
*/

        // get all users
/*
        Query<Users> findAll = session.createQuery("from Users", Users.class);
        findAll.list().forEach(System.out::println);
*/
/*
        session.createQuery("from Users", Users.class)
                .getResultList().forEach(System.out::println);
*/
        // find by id
/*
        Query<Users> findById = session.createQuery(
                "from Users where id =: id"
        );
        findById.setParameter("id", 100L);
        findById.list().forEach(System.out::println);
*/
/*
        Optional.ofNullable(session.get(Users.class, 200L))
                        .ifPresentOrElse(
                                user -> System.out.println(user),
                                () -> System.out.println("User not found")
                        );
*/

        // update
/*
        Query<Users> update = session.createQuery(
                "update Users set userName =:newUserName where id =:id"
        );
        update.setParameter("newUserName", "Jane");
        update.setParameter("id", 105L);
        update.executeUpdate();
*/

        // delete
/*
        Query<Users> delete = session.createQuery(
                "delete Users where id =: id");
        delete.setParameter("id", 101L);
        delete.executeUpdate();
*/

        session.createQuery("from Users", Users.class)
                .getResultList().forEach(System.out::println);

/*
        Worker worker = new Worker(0L, "John", "Doe", LocalDate.of(1980, 06, 10));
        session.save(worker);
        session.createQuery("from Worker", Worker.class).list().forEach(System.out::println);
*/

        session.getTransaction().commit();
        session.close();
    }
}
