package jk.uz.pdp.domain.repository;

import jk.uz.pdp.domain.exception.DataNotFoundException;
import jk.uz.pdp.domain.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public abstract class TransActionRepository implements BaseCrudRepository<Transaction,Long> {
    private List<Transaction>transactionList = new ArrayList<>();
    private Long id = 0L;
    @Override
    public void create(Transaction transaction) {
        transaction.setId(id++);
        transactionList.add(transaction);
    }

    @Override
    public Transaction getById(Long id) {
        for (Transaction transaction:transactionList) {
            if (transaction.getId().equals(id)){
                return transaction;
            }
        }
        throw new DataNotFoundException("There is not transaction with this id");
    }

    @Override
    public List<Transaction> getList() {
        return transactionList;
    }

    @Override
    public Transaction update(Transaction update) {
        int i =0;
        for (Transaction transaction:transactionList) {
            if (transaction.getId().equals(update.getId())){
                transactionList.set(i,update);
                return transaction;
            }
            i++;
        }
        throw new DataNotFoundException("There is not transaction with this id");
    }

    @Override
    public void delete(Long id) {
        for (Transaction transaction:transactionList) {
            if (transaction.getId().equals(id)){
                transactionList.remove(transaction);
                break;
            }
        }
    }
}
