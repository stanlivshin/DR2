package com.dr.nlp.sl.executor.strategy.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.w3c.dom.Document;

import com.dr.nlp.sl.config.Config;
import com.dr.nlp.sl.config.FeatureOneConfig;
import com.dr.nlp.sl.config.FeatureTwoConfig;
import com.dr.nlp.sl.datastructure.TextFile;
import com.dr.nlp.sl.datastructure.helper.NamedEntitiyList;
import com.dr.nlp.sl.executor.Executor;
import com.dr.nlp.sl.executor.strategy.FileToArrayListStrategy;
import com.dr.nlp.sl.executor.strategy.FileToStringStrategy;
import com.dr.nlp.sl.executor.strategy.ObjectToXMLStrategy;
import com.dr.nlp.sl.executor.strategy.StringToObjectStrategy;

public class ObjectToXMLStrategyTest {
	
	@Test
	public void testObjectToXMLStrategy() {
		//init NamedEntityList
		//init config
		Config config2 = new FeatureTwoConfig();
				
		//read file into ArrayList<String> and store it in the singleton Enum object
		FileToArrayListStrategy fileToArrayListStrategy = new FileToArrayListStrategy(config2);
		Executor<ArrayList<String>> fileToArrayListExecutor = new Executor<>(fileToArrayListStrategy);
		NamedEntitiyList.INSTANCE.init(fileToArrayListExecutor.execute());
		
		//init config
		Config config = new FeatureOneConfig();
				
		//read file into String
		FileToStringStrategy fileToStringStrategy = new FileToStringStrategy(config);
		Executor<String> fileToStringExecutor = new Executor<>(fileToStringStrategy);
		String string = fileToStringExecutor.execute();
				
		//convert String into com.dr.nlp.sl.datastructure.* Objects
		StringToObjectStrategy stringToObjectStrategy = new StringToObjectStrategy(config, string);
		Executor<TextFile> stringToObjectExecutor = new Executor<>(stringToObjectStrategy);
		TextFile textFile = stringToObjectExecutor.execute();
		
		ObjectToXMLStrategy objectToXMLStrategy = new ObjectToXMLStrategy(textFile);
		assertEquals(null, objectToXMLStrategy.getResult());
		objectToXMLStrategy.execute();
		assertNotEquals(null, objectToXMLStrategy.getResult());
		Document document = objectToXMLStrategy.getResult();
		assertEquals(config.getInputFile().getName(), document.getFirstChild().getAttributes().getNamedItem("fileName").getNodeValue());
	}

}
