package com.s8.arch.fluor;

@FunctionalInterface
public interface S8Filter<T> {

	
	/**
	 * 
	 * @param object
	 * @return
	 */
	public boolean isSelected(T object);
	
}
