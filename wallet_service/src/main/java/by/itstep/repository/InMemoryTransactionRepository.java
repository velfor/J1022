package by.itstep.repository;

import by.itstep.dto.Transaction;
import by.itstep.exeption.TransactionNotFound;

import java.util.HashMap;
import java.util.List;

public class InMemoryTransactionRepository implements  TransactionRepository{

    private HashMap<Long, Transaction> inMemoryStorage;
    private static Long id;

    InMemoryTransactionRepository(HashMap<Long, Transaction> inMemoryStorage)
    {
        this.inMemoryStorage = inMemoryStorage;
        InMemoryTransactionRepository.id = 0L;
    }

    public void save(Transaction transaction) {
        InMemoryTransactionRepository.id++;
        inMemoryStorage.put(InMemoryTransactionRepository.id, transaction);
    }

    public Transaction getById(Long id) throws TransactionNotFound {
        Transaction res = inMemoryStorage.get(id);
        if (res == null){
            throw new TransactionNotFound("Transaction not found");
        }
        return res;
    }

    public void update(Long id, Transaction transaction) {

    }

    public void delete(Transaction transaction) {

    }

    public List<Transaction> getAll() {
        return null;
    }
}
