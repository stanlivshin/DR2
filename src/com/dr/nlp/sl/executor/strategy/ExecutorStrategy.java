package com.dr.nlp.sl.executor.strategy;

import com.dr.nlp.sl.executor.Executor;

/**
 * ExecutorStrategy interface part of the
 * Strategy design pattern to execute
 * various strategies
 * 
 * @see Executor
 * @author Stan Livshin
 *
 * @param <R> generic return type
 */
public interface ExecutorStrategy<R> {
	public void beforeExecute();
	public void execute();
	public void afterExecute();
	public R getResult();
}
