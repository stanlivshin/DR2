package com.dr.nlp.sl.task;

/**
 * Task interface - 
 * tasks can be used to group
 * a number of strategies executions
 * together and return result
 * 
 * @author Stan Livshin
 *
 * @param <R> generic result type
 */
public interface Task<R> {
	
	public void runTask();
	public R getResult();
}
