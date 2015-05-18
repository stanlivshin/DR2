package com.dr.nlp.sl.config;

import java.io.File;

/**
 * FeatureTwoConfig extends abstract Config class
 * overriding getInputFile() and getOutputFile()
 * methods.
 * 
 * This config class is used for feature two of the
 * coding challenge. 
 * 
 * @see Config
 * @author Stan Livshin
 */
public class FeatureTwoConfig extends Config {

	/**
	 * @return returns input File
	 * @see File
	 */
	@Override
	public File getInputFile() {
		return new File("NER.txt");
	}

	/**
	 * @return returns output File
	 * @see File
	 */
	@Override
	public File getOutputFile() {
		return null; //feature two doesn't have separate output file
	}

}
