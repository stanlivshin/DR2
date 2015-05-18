package com.dr.nlp.sl.task;

import org.w3c.dom.Document;

import com.dr.nlp.sl.config.Config;
import com.dr.nlp.sl.config.FeatureOneConfig;
import com.dr.nlp.sl.datastructure.TextFile;
import com.dr.nlp.sl.executor.Executor;
import com.dr.nlp.sl.executor.strategy.FileToStringStrategy;
import com.dr.nlp.sl.executor.strategy.ObjectToXMLStrategy;
import com.dr.nlp.sl.executor.strategy.StringToObjectStrategy;
import com.dr.nlp.sl.executor.strategy.XMLToFileStrategy;

/**
 * Feature one represents the following feature request:
 * 
 * 1. Write a program that identifies sentence boundaries and tokenizes the text in the file 
 * "nlp_data.txt" into words. It should correctly process all symbols, including punctuation 
 * and whitespace. Every word must fall into a sentence. Create data structures that 
 * efficiently express the data you have processed. When your program runs it should 
 * output an XML representation of your Java object model.
 * 
 * @author Stan Livshin
 */
public class FeatureOneTask implements Task<Void> {

	/**
	 * run task
	 */
	@Override
	public void runTask() {
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
		
		//convert com.dr.nlp.sl.datastructure.* Objects into XML Document
		ObjectToXMLStrategy objectToXMLStrategy = new ObjectToXMLStrategy(textFile);
		Executor<Document> objectToXMLExecutor = new Executor<>(objectToXMLStrategy);
		Document document = objectToXMLExecutor.execute();
		
		//output XML Document to the file
		XMLToFileStrategy xmlToFileStrategy = new XMLToFileStrategy(config, document);
		Executor<Void> xmlToFileExecutor = new Executor<>(xmlToFileStrategy);
		xmlToFileExecutor.execute();
	}

	/**
	 * empty
	 */
	@Override
	public Void getResult() {
		return null;
	}
}
