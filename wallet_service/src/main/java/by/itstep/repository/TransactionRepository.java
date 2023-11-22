package by.itstep.repository;

import by.itstep.dto.Transaction;

import java.util.List;

public interface TransactionRepository {

    void save(Transaction transaction);

    Transaction getById(Long id);

    void update(Transaction transaction);

    void delete(Transaction transaction);

    List<Transaction> getAll();
}
