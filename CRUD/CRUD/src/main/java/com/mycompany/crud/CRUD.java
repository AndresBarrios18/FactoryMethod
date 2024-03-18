package com.mycompany.crud;

/**
 *
 * @author pipe2
 */
public interface CRUD<T> {
    void create(T obj, Storage storage);
    T read(int id);
    void update(T obj);
    void delete(int id);
}

