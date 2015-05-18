package com.dr.nlp.sl.executor.strategy.test;

import static org.junit.Assert.assertEquals;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;

import com.dr.nlp.sl.config.Config;
import com.dr.nlp.sl.executor.strategy.XMLToFileStrategy;

public class XMLToFileStrategyTest {
	
	@Test
	public void testXMLToFileStrategy() throws ParserConfigurationException {
		//init config
		Config config = new Config() {
			
			@Override
			public File getOutputFile() {
				return new File("test.xml");
			}
			
			@Override
			public File getInputFile() {
				return null;
			}
		};
				
		new File("test.xml").delete();
		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		XMLToFileStrategy xmlToFileStrategy = new XMLToFileStrategy(config, document);
		assertEquals(new File("test.xml").exists(), false);
		xmlToFileStrategy.execute();
		assertEquals(new File("test.xml").exists(), true);
		new File("test.xml").delete();
	}

}
