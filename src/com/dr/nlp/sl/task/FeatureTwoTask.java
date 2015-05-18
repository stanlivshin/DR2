package com.dr.nlp.sl.task;

import java.util.ArrayList;

import com.dr.nlp.sl.config.Config;
import com.dr.nlp.sl.config.FeatureTwoConfig;
import com.dr.nlp.sl.datastructure.helper.NamedEntitiyList;
import com.dr.nlp.sl.executor.Executor;
import com.dr.nlp.sl.executor.strategy.FileToArrayListStrategy;

/**
 * Feature two represents the following feature request:
 * 
 * 2. Modify your program from #1 to add rudimentary recognition of proper nouns ("named 
 * entities") in the input, and print a list of recognized named entities when it runs. The list 
 * of named entities is in the file "NER.txt". Enhance your data structures and output 
 * schema to store information about which portions of the text represent named entities.
 * 
 * @author Stan Livshin
 */
public class FeatureTwoTask implements Task<Void> {

	/**
	 * run task and output named entity list
	 */
	@Override
	public void runTask() {
		//init config
		Config config = new FeatureTwoConfig();
		
		//read file into ArrayList<String> and store it in the singleton Enum object
		FileToArrayListStrategy fileToArrayListStrategy = new FileToArrayListStrategy(config);
		Executor<ArrayList<String>> fileToArrayListExecutor = new Executor<>(fileToArrayListStrategy);
		NamedEntitiyList.INSTANCE.init(fileToArrayListExecutor.execute());
		
		System.out.println("Named Entity List: ");
		for (String namedEntity : NamedEntitiyList.INSTANCE.getNamedEntityList()) {
			System.out.println(namedEntity);
		}
		System.out.println(""); //add empty line to separate outputs
	}

	/**
	 * empty
	 */
	@Override
	public Void getResult() {
		return null;
	}
}
