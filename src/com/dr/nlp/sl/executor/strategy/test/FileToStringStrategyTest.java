package com.dr.nlp.sl.executor.strategy.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import com.dr.nlp.sl.config.Config;
import com.dr.nlp.sl.config.FeatureOneConfig;
import com.dr.nlp.sl.executor.strategy.FileToStringStrategy;

public class FileToStringStrategyTest {

	@Test
	public void testFileToStringStrategy() {
		Config config = new FeatureOneConfig();
		FileToStringStrategy fileToStringStrategy = new FileToStringStrategy(config);
		assertEquals("", fileToStringStrategy.getResult());
		fileToStringStrategy.beforeExecute();
		fileToStringStrategy.execute();
		assertNotEquals("", fileToStringStrategy.getResult());
		fileToStringStrategy.afterExecute();
		
	}
	
	@Test(expected = NullPointerException.class)
	public void testFileToStringStrategyException() {
		Config config = new FeatureOneConfig();
		FileToStringStrategy fileToStringStrategy = new FileToStringStrategy(config);
		fileToStringStrategy.execute();
	}
}
