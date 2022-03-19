package lt.codeacademy.budget.service;

import lt.codeacademy.budget.dao.RecordDao;
import lt.codeacademy.budget.entity.Record;

public class RecordServiceImpl implements RecordService{
    private RecordDao recordDao;

    public RecordServiceImpl(RecordDao recordDao) {
        this.recordDao = recordDao;
    }

    @Override
    public Record save(Record record) {
        return recordDao.save(record);
    }
}
