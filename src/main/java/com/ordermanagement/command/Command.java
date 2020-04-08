/**
 * 
 */
package com.ordermanagement.command;

/**
 * Mar 29, 2020
 *
 *	@author Tharunkumar Bairoju
 * 
 */
public interface Command<E, T> {
	public T execute(E request);
}
