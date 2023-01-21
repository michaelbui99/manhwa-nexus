package io.github.michaelbui99.manhwanexus.core.interfaces.repository;

import java.util.List;

public interface TagRepository extends CrudRepository<String> {
    List<String> getByManhwa(int manhwaId);
}
