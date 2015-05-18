package com.dr.nlp.sl;

import com.dr.nlp.sl.task.FeatureOneTask;
import com.dr.nlp.sl.task.FeatureTwoTask;
import com.dr.nlp.sl.task.TaskRunner;

/**
 * @author Stan Livshin
 * Remote programming exercise 
 * This project should be well tested and code should be checked into GitHub along with any 
 * output produced from running your program. Write your solution in the Java programming 
 * language, using only the standard libraries. Do not use any third-­party libraries for natural 
 * language processing. Describe any assumptions you make in your implementation. What are 
 * the limitations of your approach? What other approaches might be possible? At the end of the 
 * assignment there should be a commit/push for each of the following features. 
 
 * 1. Write a program that identifies sentence boundaries and tokenizes the text in the file 
 * "nlp_data.txt" into words. It should correctly process all symbols, including punctuation 
 * and whitespace. Every word must fall into a sentence. Create data structures that 
 * efficiently express the data you have processed. When your program runs it should 
 * output an XML representation of your Java object model.
 * 
 * 2. Modify your program from #1 to add rudimentary recognition of proper nouns ("named 
 * entities") in the input, and print a list of recognized named entities when it runs. The list 
 * of named entities is in the file "NER.txt". Enhance your data structures and output 
 * schema to store information about which portions of the text represent named entities.
 */
public class Main {

	public static void main(String[] args) {
		//task runner is able to run any number of tasks which implement Task interface
		TaskRunner taskRunner = new TaskRunner();
		//feature two reads in NER.txt file into com.dr.nlp.sl.datastructure.helper.NamedEntitiyList Enum Singleton class
		FeatureTwoTask featureTwoTask = new FeatureTwoTask();
		taskRunner.addTask(featureTwoTask);
		//feature one reads in nlp_data.txt file converts it into com.dr.nlp.sl.datastructure.* Objects
		//and then outputs it in XML format to output.xml file
		FeatureOneTask featureOneTask = new FeatureOneTask(); //feature one task now depends on the NamedEntityList being initialized
		taskRunner.addTask(featureOneTask);
		taskRunner.runTasks();
	}
}
