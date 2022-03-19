package lt.codeacademy.budget.dao;

import lt.codeacademy.budget.entity.Record;
import lt.codeacademy.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class RecordDaoHibernateImpl implements RecordDao {
    private static final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    @Override
    public Record save(Record record) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(record);
            session.getTransaction().commit();
        }
        return record;
    }

    @Override
    public List<Record> findAll() {
        List<Record> records;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            records = session.createQuery("from Record", Record.class).list();
            session.getTransaction().commit();
        }
        return records;
    }

    @Override
    public <T extends Record> Optional<T> getById(int id, Class<T> type) {
        Optional<T> record;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            record = Optional.ofNullable(session.get(type, id));
            session.getTransaction().commit();
        }
        return record;
    }

    @Override
    public void edit(Record record) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(record);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(int id) {
        Optional<Record> record = getById(id, Record.class);
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            record.ifPresent(session::delete);
            session.getTransaction().commit();
        }
    }
}
