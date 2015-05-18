package com.dr.nlp.sl.executor;

import com.dr.nlp.sl.executor.strategy.ExecutorStrategy;

/**
 * Executor class is part of the
 * strategy design pattern which
 * executes various Strategies
 * based on the ExecutorStrategy
 * interface.
 * 
 * @see ExecutorStrategy
 * @author Stan Livshin
 *
 * @param <R> - generic return type 
 */
public class Executor<R> {
	
	//holds stategy
	private ExecutorStrategy<R> strategy;
	
	/**
	 * Constructor
	 * 
	 * @param strategy based on ExecutorStrategy interface
	 */
	public Executor(ExecutorStrategy<R> strategy) {
		this.strategy = strategy;
	}
	
	/**
	 * Execute strategy
	 * @return <R> some generic return type
	 */
	public R execute() {
		strategy.beforeExecute();
		strategy.execute();
		strategy.afterExecute();
		return strategy.getResult();
	}
}
