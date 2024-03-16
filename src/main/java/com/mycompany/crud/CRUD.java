/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.crud;

/**
 *
 * @author pipe2
 */
public interface CRUD<T> {
    void create(T obj);
    T read(int id);
    void update(T obj);
    void delete(int id);
}

