package com.dr.nlp.sl.executor.strategy.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.dr.nlp.sl.config.Config;
import com.dr.nlp.sl.config.FeatureOneConfig;
import com.dr.nlp.sl.executor.strategy.StringToObjectStrategy;

public class StringToObjectStrategyTest {

	@Test
	public void testStringToObjectStrategy() {
		Config config = new FeatureOneConfig();
		String string = "";
		StringToObjectStrategy stringToObjectStrategy = new StringToObjectStrategy(config, string);
		stringToObjectStrategy.execute();
		assertEquals(0, stringToObjectStrategy.getResult().getParagraphArray().size());
		
		string = "One paragraph.";
		StringToObjectStrategy stringToObjectStrategy2 = new StringToObjectStrategy(config, string);
		stringToObjectStrategy2.execute();
		assertEquals(1, stringToObjectStrategy2.getResult().getParagraphArray().size());
		
		string = "One paragraph. \n\n Two paragraph. \n\n Three paragarph?";
		StringToObjectStrategy stringToObjectStrategy3 = new StringToObjectStrategy(config, string);
		stringToObjectStrategy3.execute();
		assertEquals(3, stringToObjectStrategy3.getResult().getParagraphArray().size());
	}
}
