package edu.mum.cs.cs425swe.crudlab.service;

import java.util.List;

public interface IService<T> {
    public abstract  List<T> findAll();
    public abstract  T findById(Long id);
    public abstract T save(T t);
    public abstract void deleteById(Long id);
}
