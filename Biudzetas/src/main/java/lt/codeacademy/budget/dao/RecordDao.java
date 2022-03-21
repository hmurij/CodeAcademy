package lt.codeacademy.budget.dao;

import lt.codeacademy.budget.entity.Record;

import java.util.List;
import java.util.Optional;

public interface RecordDao {
    Record save(Record record);

    List<Record> findAll();

    <T extends Record> Optional<T> getById(int id, Class<T> type);

    void edit(Record record);

    void delete(Record record);
}
