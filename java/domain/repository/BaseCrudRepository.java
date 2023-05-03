package jk.uz.pdp.domain.repository;

import java.util.List;

public interface BaseCrudRepository<M, ID>{
    void create(M obj);
    M getById(ID id);
    List<M> getList();
    M update(M update);
    void delete(ID id);

}
