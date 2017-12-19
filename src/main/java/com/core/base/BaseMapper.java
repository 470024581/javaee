package com.core.base;

import java.util.List;

public interface BaseMapper<T> {
	
	public List<T> gets();
	public T get(Long id);
	public int add(T t);
	public int del(Long id);
	public int update(T t);
}
