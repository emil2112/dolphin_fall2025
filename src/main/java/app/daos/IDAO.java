package app.daos;

import java.util.List;

public interface IDAO <T, I> {

    T create(T t);
    List<T> getAll();
    T getById(I i);
    T update(T t);
    boolean delete(I i);
}
