package com.ugurcanlacin.sportclubsystem.service;

public interface GenericService<T> {
	void persist(T o);
	T find(Integer id);
	void update(T o);
	void delete(T o);
	void merge(T o);
}
