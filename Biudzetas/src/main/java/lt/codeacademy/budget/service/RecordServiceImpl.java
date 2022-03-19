package lt.codeacademy.budget.service;

import lt.codeacademy.budget.dao.RecordDao;
import lt.codeacademy.budget.entity.Record;

import java.util.List;
import java.util.Optional;

public class RecordServiceImpl implements RecordService{
    private RecordDao recordDao;

    public RecordServiceImpl(RecordDao recordDao) {
        this.recordDao = recordDao;
    }

    @Override
    public Record save(Record record) {
        return recordDao.save(record);
    }

    @Override
    public List<Record> findAll() {
        return recordDao.findAll();
    }

    @Override
    public <T extends Record> Optional<T> getById(int id, Class<T> type) {
        return recordDao.getById(id, type);
    }

    @Override
    public void edit(Record record) {
        recordDao.edit(record);
    }

    @Override
    public void delete(Record record) {
        recordDao.delete(record);
    }
}
