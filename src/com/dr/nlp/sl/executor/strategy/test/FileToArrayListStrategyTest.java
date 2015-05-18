package com.dr.nlp.sl.executor.strategy.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.dr.nlp.sl.config.Config;
import com.dr.nlp.sl.config.FeatureTwoConfig;
import com.dr.nlp.sl.executor.strategy.FileToArrayListStrategy;

public class FileToArrayListStrategyTest {

	@Test
	public void testFileToArrayListStrategy() {
		Config config = new FeatureTwoConfig();
		FileToArrayListStrategy fileToArrayListStrategy = new FileToArrayListStrategy(config);
		assertEquals(new ArrayList<String>(), fileToArrayListStrategy.getResult());
		fileToArrayListStrategy.beforeExecute();
		fileToArrayListStrategy.execute();
		assertNotEquals(new ArrayList<String>(), fileToArrayListStrategy.getResult());
		//there are 45 named entities
		assertEquals(45, fileToArrayListStrategy.getResult().size());
		fileToArrayListStrategy.afterExecute();
		
	}
	
	@Test(expected = NullPointerException.class)
	public void testFileToArrayListStrategyException() {
		Config config = new FeatureTwoConfig();
		FileToArrayListStrategy fileToArrayListStrategy = new FileToArrayListStrategy(config);
		fileToArrayListStrategy.execute();
	}
}
