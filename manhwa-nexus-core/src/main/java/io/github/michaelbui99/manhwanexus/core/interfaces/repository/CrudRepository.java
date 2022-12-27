package io.github.michaelbui99.manhwanexus.core.interfaces.repository;

import java.util.List;

public interface CrudRepository<T> {
    T create(T entity);

    T getById(int id);

    boolean delete(int id);

    T update(int id, T updatedEntity);

    List<T> getAll();
}
